package com.example.agentgrpc.bll;

//import com.example.agentgrpc.conf.TaskExecutorConfig;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.jmeter.Stress;
import com.example.agentgrpc.protocol.project.NodeControlReq;
import com.example.agentgrpc.utils.Constants;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
import com.example.agentgrpc.utils.ReadConfUtil;
import com.example.agentgrpc.utils.SendGrpcUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AsyncTask {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private CommonMethod commonMethod;

    @Autowired
    private Stress stress;

    private static final String AGENT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnLinux");
    private static final String AGENT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnWindows");

    private static final int CYCLE_MAX = (int) ReadConfUtil.readYml("application.yml","my.cycleTime");
    private static final int STACK_COUNT_MAX = (int) ReadConfUtil.readYml("application.yml","my.stackCountMax");
    //确认启动
    @Async("TaskExecutor")
    public void checkStart(NodeControlReq request){
        try{
            servletContext.setAttribute(request.getNode().getBinPath()+Constants.DIVISION+"state","1");
            for (int i=0 ; i < CYCLE_MAX ; i++){
                try {
                    TimeUnit.SECONDS.sleep(5);//秒
                    int state = commonMethod.getProjectState(request.getNode());
                    //遇到个问题，tomcat有时换jar的重启失败，需要手动再重启一次
                    if (state == 0){
                        log.error("ERROR2: Check start failed:down,restart now");
                        commonMethod.justRestart(request.getNode());
                    }
                    //工程启动了
                    if(state == 1){
                        SendGrpcUtil.TaskStatus(request.getExecId(),request.getIndex(),1,0,"Project start success");
                        return;
                    }
                } catch (InterruptedException e) {
                    log.error("ERROR2: Check start failed",e);
                }
            }
            //循环结束还没开启
            log.error("ERROR2: The project has not been started for a long time");
            SendGrpcUtil.TaskStatus(request.getExecId(),request.getIndex(),1,1,"Project start fail");
        }finally {
            servletContext.removeAttribute(request.getNode().getBinPath()+Constants.DIVISION+"state");
        }

    }

    //打堆栈
    @Async("TaskExecutor")
    public void printJStacks(String path, String execId, int pid, int interval){
        String command;
        log.info("Start stack......");
        int i;
        for (i = 1;i<STACK_COUNT_MAX+1;i++){
            command = Constants.JSTACK + " "+pid+" > "+i+".txt";
            String tag = (String) servletContext.getAttribute(execId+Constants.DIVISION+"jstack");
            if("1".equals(tag.split(Constants.DIVISION)[0])){
                try {
                    ExecSystemCommandUtil.execCommand(path,command,"utf-8");
                    commonMethod.delay(interval);
                } catch (IOException e) {
                    log.error("ERROR2: Exec command failed:jstack",e);
                }
            }
            else
                break;
        }
        //自动停止的情况
        if (i == STACK_COUNT_MAX)
            log.info("ERROR2: Auto stop:stack,path:"+path);
        log.info("Stop stack");
        servletContext.removeAttribute(execId+Constants.DIVISION+"jstack");
    }

    //打dump
    @Async("TaskExecutor")
    public void printDump(String dirPath,String execId,int index, int pid){
        //数据准备
        String osType = commonMethod.getSystemType();
        String filePath;
        String command;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        filePath = dirPath+"\\"+execId+Constants.DIVISION+index+Constants.DIVISION+sdf.format(System.currentTimeMillis())+".hprof";
        if("Linux".equals(osType)){
            command =Constants.JMAP + " -dump:format=b,file="+filePath+" "+pid;
        }
        else{
            command =Constants.JMAP + " -dump:format=b,file=\""+filePath+"\" "+pid;
        }
        //打dump
        try {
            ExecSystemCommandUtil.execCommand(dirPath,command,"utf-8");
        } catch (IOException e) {
            log.error("ERROR2: Print dump failed",e);
        }
        //回传
        SendGrpcUtil.TaskStatus(execId,index,2,0,filePath);

    }

    //延迟删除
    @Async("TaskExecutor")
    public void delayDelete(String path,int time){
        commonMethod.delay(time);
        commonMethod.delPath(path);
    }

    //压测
    @Async("TaskExecutor")
    public void startStress(String jmxDirPath, String jmxName, String jtlDirPath, String execId, int index, ArrayList<String> fileNames){
        String id = execId+Constants.DIVISION+"stress";
        try {
            //压测
            stress.run(jmxDirPath,jmxName,jtlDirPath,jmxName.split("\\.")[0]+".jtl",id,fileNames,execId,index);
        }catch (Exception e) {
            log.error("ERROR2: Start stress failed",e);
            commonMethod.delPath(jtlDirPath);
            SendGrpcUtil.TaskStatus(execId,index,3,1,"JMeter run failed");
            return;
        }
        finally {
            //删除临时jmx文件
            commonMethod.delPath(jmxDirPath);
            //如果正常，返回grpc
            if (servletContext.getAttribute(id) != null)
                SendGrpcUtil.TaskStatus(execId,index,3,0,"JMeter finish");
            //移除servlet上下文
            servletContext.removeAttribute(id);
        }

    }
}
