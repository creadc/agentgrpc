package com.example.agentgrpc.bll;

import com.example.agentgrpc.jmeter.Stress;
import com.example.agentgrpc.pojo.StressCheck;
import com.example.agentgrpc.protocol.stress.*;
import com.example.agentgrpc.utils.Constants;
import com.example.agentgrpc.utils.ReadConfUtil;
import com.example.agentgrpc.utils.SendHTTPUtil;
import com.example.agentgrpc.utils.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jorphan.collections.HashTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
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

    @Autowired
    private Stress stress;

    private static final String AGENT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnLinux");
    private static final String AGENT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnWindows");

    public StartStressRes startStress(StartStressReq request){
        //数据准备
        String url = request.getDownloadUrl();//下载url
        String execId = request.getExecId();
        int index = request.getIndex();
        String jmxName = null;//脚本文件名
        String jmxPath;//jar路径
        String fileName;//临时csv文件名

        ArrayList<String> fileNames = new ArrayList<>();//文件名称的集合
        for(int i =0;i<request.getFileListCount();i++){
            fileName = request.getFileList(i);
            if (fileName.contains(".jmx"))
                jmxName = fileName;
            fileNames.add(fileName);
        }
        //下载的文件没有jmx
        if (jmxName == null){
            log.error("ERROR2: No jmx file");
            return StartStressRes.newBuilder()
                    .setCode(1)
                    .setMessage("Download jmx fail")
                    .build();
        }

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

        for (String name : fileNames) {
            jmxPath = jmxDirPath + name;
            int res = SendHTTPUtil.downloadFile(UrlUtil.join(url, name), jmxPath);
            if (res == 0) {
                log.error("ERROR2: Download jmx or csv failed");
                //删除目录及文件
                commonMethod.delPath(jmxDirPath);
                commonMethod.delPath(jtlDirPath);
                return StartStressRes.newBuilder()
                        .setCode(1)
                        .setMessage("Download jmx fail")
                        .build();
            }
        }
        //把jmx文件名从arraylist中分离出来
        fileNames.remove(jmxName);
        //压测前检查
        StressCheck sc;
        try {
            sc = stress.check(jmxDirPath, jmxName, jtlDirPath, fileNames);
        }
        catch (Exception e){
            log.error("ERROR2: Check jmx file failed",e);
            commonMethod.delPath(jtlDirPath);
            return StartStressRes.newBuilder()
                    .setCode(1)
                    .setMessage("Check jmx file failed")
                    .build();
        }
        if (!sc.getRes().equals("success")){
            return StartStressRes.newBuilder()
                    .setCode(1)
                    .setMessage(sc.getRes())
                    .build();
        }
        HashTree jmxtree = sc.getHashTree();
        //前置条件准备完成，开始压测，先返回执行中
        asyncTask.startStress(jmxtree,jmxDirPath,jmxName,jtlDirPath,execId,index);
        log.info("JMeter running......");
        return StartStressRes.newBuilder()
                .setCode(2)
                .setMessage("JMeter running......")
                .build();
    }

    public StopStressRes stopStress(StopStressReq req){
        StandardJMeterEngine engine = ((StandardJMeterEngine)servletContext.getAttribute(req.getExecId()+ Constants.DIVISION+"stress"));
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
        //归档文件夹
        String osType = commonMethod.getSystemType();
        String agentPath;//agent目录
        if ("Linux".equals(osType)){
            agentPath = AGENT_PATH_ON_LINUX;
        }
        else {
            agentPath = AGENT_PATH_ON_WINDOWS;
        }
        File jtlBakPath = new File(agentPath+File.separator+"jtl_bak");
        if (!jtlBakPath.exists()){ //如果不存在
            jtlBakPath.mkdirs();
        }
        return agentPath;
    }

}
