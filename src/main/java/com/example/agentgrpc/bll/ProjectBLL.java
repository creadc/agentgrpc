package com.example.agentgrpc.bll;


import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.protocol.project.*;
import com.example.agentgrpc.utils.Constants;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
import com.example.agentgrpc.utils.SendHTTPUtil;
import com.example.agentgrpc.utils.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Component
public class ProjectBLL {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private CommonMethod commonMethod;



    public NodeControlRes startNode(NodeControlReq request) {
        int state = commonMethod.getProjectState(request.getNode());
        //已启动
        if (state == 1){
            log.error("ERROR1: Project is already start");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("Project is already start")
                    .build();
        }

        //宕机或其他错误
        if(state == -1){
            log.error("ERROR1: Start fail,Project status :starting or crash");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("Start fail,Project status : crash")
                    .build();
        }

        //启动
        commonMethod.justStart(request.getNode());
        //新启线程验证
        asyncTask.checkStart(request);
        log.info("Project starting......");
        return NodeControlRes.newBuilder()
                .setCode(2)
                .setMessage("Project starting......")
                .build();
    }

    public NodeControlRes stopNode(NodeControlReq request) {
        NodeInfo node = request.getNode();
        ArrayList<Integer> pids = commonMethod.getAllPid(Integer.parseInt(node.getPort()), node.getBinPath(),node.getProjType());
        //未启动
        if(pids.get(0) == 0){
            log.error("ERROR2: Project is already stop");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("Project is already stop")
                    .build();
        }

        //已启动或状态异常,总结就是端口占用
        for (Integer pid : pids) {
            commonMethod.justStop(node,pid);
        }

        //结果验证
        log.info("Result validation");
        pids = commonMethod.getAllPid(Integer.parseInt(node.getPort()), node.getBinPath(),node.getProjType());
        if (pids.get(0) != 0)
            for (Integer pid : pids) {
                commonMethod.justStop(node,pid);
            }

        int state = commonMethod.getProjectState(node);
        //执行命令后不报错但项目还未关闭
        if(state == 1){
            log.error("ERROR2: Exec command success,stop fail");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("Exec command success,stop fail")
                    .build();
        }
        //项目关闭成功
        log.info("Project stop success");
        return NodeControlRes.newBuilder()
                .setCode(0)
                .setMessage("Project stop success")
                .build();
    }

    public NodeControlRes reStartNode(NodeControlReq request) {
        //重启
        commonMethod.justRestart(request.getNode());
        //新启线程验证
        asyncTask.checkStart(request);
        log.info("Starting......");
        return NodeControlRes.newBuilder()
                .setCode(2)
                .setMessage("Starting")
                .build();
    }

    public NodeControlRes replaceJar(ReplaceJarReq request) {
        //数据准备
        NodeInfo node = request.getNode();
        String osType = commonMethod.getSystemType();
        String url = request.getDownloadUrl();//下载url
        ArrayList<String> jarNames = new ArrayList<>();//jar名称的集合
        for(int i =0;i<request.getFileListCount();i++){
            jarNames.add(request.getFileList(i));
        }
        String jarPath;//jar路径

        //新建目录
        String[] strs = commonMethod.initPath("tempJar",request.getExecId(),request.getIndex(),true);
        //新建目录时报错就返回
        if("fail".equals(strs[0])){
            log.error("ERROR2: New directory error");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("New directory error")
                    .build();
        }
        //接收jar包存放到指定位置,报错就返回
        String jarDirPath = strs[1];
        for (String jarName : jarNames) {
            jarPath = jarDirPath + jarName;
            int res = SendHTTPUtil.downloadFile(UrlUtil.join(url,jarName),
                    jarPath);
            if (res == 0) {
                log.error("ERROR2: Download jars fail");
                //删除目录及文件
                commonMethod.delPath(jarDirPath);
                return NodeControlRes.newBuilder()
                        .setCode(1)
                        .setMessage("Download jars fail")
                        .build();
            }
        }
        //删除和复制
        commonMethod.delSpecificFiles(node.getLibPath(),1);
        commonMethod.copyFiles(jarNames,jarDirPath,node.getLibPath());
        //删除目录及文件
        commonMethod.delPath(jarDirPath);
        //重启
        commonMethod.justRestart(request.getNode());
        //新启线程验证
        NodeControlReq req = NodeControlReq.newBuilder()
                .setNode(node)
                .setExecId(request.getExecId())
                .setIndex(request.getIndex())
                .build();
        asyncTask.checkStart(req);
        log.info("Project starting......");
        return NodeControlRes.newBuilder()
                .setCode(2)
                .setMessage("Project starting......")
                .build();
    }

    public NodeStateRes nodeState(NodeControlReq request) {
        //数据准备
        NodeInfo node = request.getNode();
        int isUp;  //是否启动

        //先判断工程是否处于启动中，如果是直接返回
        if (servletContext.getAttribute(request.getNode().getBinPath()+Constants.DIVISION+"state") != null){
            if (servletContext.getAttribute(request.getNode().getBinPath()+Constants.DIVISION+"state") == "1"){
                isUp = 5;
                log.info("Project state:starting......");
                return NodeStateRes.newBuilder()
                        .setCode(0)
                        .setIsUp(isUp)
                        .build();
            }
        }

        //发送http请求，判断工程状态
        String url="http://"+node.getIp()+":"+Integer.parseInt(node.getPort())
                +"/"+node.getWebapps()+"/"+node.getServlet()+"/system/info";
        JSONObject jsonObject = SendHTTPUtil.getReturnJson(url,new HashMap<>());
        //连接失败
        if (jsonObject.containsKey("errorMessage")){
            String message = String.valueOf(jsonObject.get("errorMessage"));
            //常规报错:未启动
            if("ConnectException".equals(message)){
                isUp = 1;
                NodeStateRes res = NodeStateRes.newBuilder()
                        .setCode(0)
                        .setIsUp(isUp)
                        .build();
                log.info("Project state:down");
                return res;
            }
            //宕机
            else if("SocketTimeoutException".equals(message)){
                isUp = 2;
                NodeStateRes res = NodeStateRes.newBuilder()
                        .setCode(0)
                        .setIsUp(isUp)
                        .build();
                log.info("Project state:crash");
                return res;
            }
            //其他报错
            else{
                isUp = 3;
                log.info(message);
                NodeStateRes res = NodeStateRes.newBuilder()
                        .setCode(0)
                        .setIsUp(isUp)
                        .putAttrs("errorMessage",message)
                        .build();
                log.error("ERROR2: Project state:down,other error");
                return res;
            }
        }

        //连接成功
        isUp = 0;

        //返回值解析，包括jar-time、version、project
        JSONObject data  = jsonObject.getJSONObject("data");
        List<Object> list = (data.getJSONArray("versionInfo"));
        JSONObject report = JSONObject.parseObject(String.valueOf(list.get(3)));

        NodeStateRes res = NodeStateRes.newBuilder()
                .setCode(0)
                .setIsUp(isUp)
                .putAttrs("jar_time",report.getString("jarTime"))
                .putAttrs("version",report.getString("version"))
                .putAttrs("product",report.getString("name"))
                .build();
        log.info("Project state:up");
        return res;
    }

    public NodeControlRes startPrintJStacks(PrintStacksReq request) {
        ArrayList<Integer> pids = commonMethod.getPidByBinPath(Integer.parseInt(request.getNode().getPort()),request.getNode().getBinPath());
        //pid不存在
        if(pids.get(0) == 0){
            log.error("ERROR2: pid does not exist,cannot stack");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("PID does not exist")
                    .build();
        }
        //pid有多个
        if (pids.size() >= 2){
            log.error("ERROR2: Multiple pid,cannot stack");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("PID does not exist")
                    .build();
        }
        //新建目录
        String[] dirStrs = commonMethod.initPath("stack",request.getExecId(),request.getIndex(),false);
        //新建目录时报错就返回
        if("fail".equals(dirStrs[0])){
            log.error("ERROR2: New directory error");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("New directory error")
                    .build();
        }
        //前置条件确认完成，发起异步任务打堆栈
        servletContext.setAttribute(request.getExecId()+Constants.DIVISION+"jstack","1"+Constants.DIVISION+request.getIndex());
        asyncTask.printJStacks(dirStrs[1],request.getExecId(),pids.get(0),request.getInterval());
        //返回结果
        return NodeControlRes.newBuilder()
                .setCode(0)
                .setMessage("Stack starting......")
                .build();
    }

    public String[] stopPrintJStacks(NodeControlReq request) {
        String attribute;
        String index;//开始打堆栈的索引
        String[] res = new String[2];
        //判断tag是否存在
        if(servletContext.getAttribute(request.getExecId()+Constants.DIVISION+"jstack") != null){
            attribute = (String) servletContext.getAttribute(request.getExecId()+Constants.DIVISION+"jstack");
            index = attribute.split(Constants.DIVISION)[1];
        }
        else{
            res[0] = "No stacking before";
            log.error("ERROR2: No stacking before");
            return res;
        }
        servletContext.setAttribute(request.getExecId()+Constants.DIVISION+"jstack","0"+Constants.DIVISION+index);
        //打包
        String stackPath = commonMethod.getPath("stack","null",0,false);//stack目录
        String tempPath = request.getExecId()+Constants.DIVISION+index;//堆栈临时路径(相对路径)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String tarName = tempPath+Constants.DIVISION+sdf.format(System.currentTimeMillis())+".tar.gz";
        String fullPath = commonMethod.getPath("stack",request.getExecId(), Integer.parseInt(index),false);//堆栈完整路径
        String command = Constants.TAR + " -zcvf "+tarName+" "+tempPath;
        try {
            ExecSystemCommandUtil.execCommand(stackPath,command,"utf-8");
        } catch (IOException e) {
            log.error("ERROR2: Failed to execute the command:Stop print jstacks",e);
        }
        //删除文件夹,保留压缩包
        asyncTask.delayDelete(fullPath,3);
        //返回gz路径
        res[0] = stackPath+tarName;
        res[1] = tarName;
        return res;
    }

    public NodeControlRes printDump(NodeControlReq request) {
        ArrayList<Integer> pids = commonMethod.getPidByBinPath(Integer.parseInt(request.getNode().getPort()),request.getNode().getBinPath());
        //pid不存在
        if(pids.get(0) == 0){
            log.error("ERROR2: pid does not exist,unable to dump");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("PID does not exist")
                    .build();
        }
        //pid有多个
        if (pids.size() >= 2){
            log.error("ERROR2: Multiple pid,unable to dump");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("PID does not exist")
                    .build();
        }
        //新建目录
        String[] dirStrs = commonMethod.initPath("dump",request.getExecId(),request.getIndex(),true);
        //新建目录时报错就返回
        if("fail".equals(dirStrs[0])){
            log.error("ERROR2: New directory error");
            return NodeControlRes.newBuilder()
                    .setCode(1)
                    .setMessage("New directory error")
                    .build();
        }
        //前置条件确认完成,新启一个线程打dump
        asyncTask.printDump(dirStrs[1],request.getExecId(),request.getIndex(),pids.get(0));

        return NodeControlRes.newBuilder()
                .setCode(2)
                .setMessage("Start dump......")
                .build();
    }
}
