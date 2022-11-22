package com.example.agentgrpc.bll;

import com.example.agentgrpc.protocol.stress.*;
import com.example.agentgrpc.utils.ReadConfUtil;
import com.example.agentgrpc.utils.SendHTTPUtil;
import com.example.agentgrpc.utils.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

@Slf4j
@Component
public class StressBLL {

    @Autowired
    private CommonMethod commonMethod;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AsyncTask asyncTask;

    private static final String AGENT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnLinux");
    private static final String AGENT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnWindows");

    public StartStressRes startStress(StartStressReq request){
        //数据准备
        String url = request.getDownloadUrl();//下载url
        String execId = request.getExecId();
        int index = request.getIndex();
        String jmxName = request.getFileList(0);
//        ArrayList<String> jmxNames = new ArrayList<>();//jmx名称的集合
//        for(int i =0;i<request.getFileListCount();i++){
//            jmxNames.add(request.getFileList(i));
//        }
        String jmxPath;//jar路径

        //新建目录
        String[] strs1 = commonMethod.initPath("tempJmx",execId,index,true);
        String[] strs2 = commonMethod.initPath("jtl",execId,index,true);
        //新建目录时报错就返回
        if("fail".equals(strs1[0]) || "fail".equals(strs2[0])){
            log.error("ERROR2: New directory error");
            return StartStressRes.newBuilder()
                    .setCode(1)
                    .setMessage("New directory error")
                    .build();
        }
        //接收jmx文件存放到指定位置,报错就返回
        String jmxDirPath = strs1[1];
        String jtlDirPath = strs2[1];
        jmxPath = jmxDirPath + jmxName;
        int res = SendHTTPUtil.downloadFile(UrlUtil.join(url,jmxName),
                jmxPath);
        if (res == 0) {
            log.error("ERROR2: Download jmx failed");
            //删除目录及文件
            commonMethod.delPath(jmxDirPath);
            commonMethod.delPath(jtlDirPath);
            return StartStressRes.newBuilder()
                    .setCode(1)
                    .setMessage("Download jmx fail")
                    .build();
        }

        //前置条件准备完成，开始压测，先返回执行中
        //压测
        asyncTask.startStress(jmxDirPath,jmxName,jtlDirPath,execId,index);
        log.info("JMeter running......");
        return StartStressRes.newBuilder()
                .setCode(2)
                .setMessage("JMeter running......")
                .build();
    }

    public StopStressRes stopStress(StopStressReq req){
        StandardJMeterEngine engine = ((StandardJMeterEngine)servletContext.getAttribute(req.getExecId()));
        if (engine == null){
            log.error("ERROR2: No stress before");
            return StopStressRes.newBuilder()
                    .setCode(1)
                    .setMessage("No stress before")
                    .build();
        }
        engine.stopTest();
        log.info("Stop stress success");
        return StopStressRes.newBuilder()
                .setCode(0)
                .setMessage("Stop stress success")
                .build();
    }

    public String jsonResult(){
        //新建一个归档文件夹
        String osType = commonMethod.getSystemType();
        String agentPath;//agent目录
        if ("Linux".equals(osType)){
            agentPath = AGENT_PATH_ON_LINUX;
        }
        else {
            agentPath = AGENT_PATH_ON_WINDOWS;
        }
        File jtlBakPath = new File(agentPath+"/jtl_bak");
        if (!jtlBakPath.exists()){ //如果不存在
            jtlBakPath.mkdirs();
        }
        return agentPath;
    }

}
