package com.example.agentgrpc.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.pojo.AgentUpdateEntity;
import lombok.extern.slf4j.Slf4j;
import net.sf.saxon.trans.SymbolicName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

@Slf4j
@Component
public class AutoUpdateUtil {
    @Autowired
    private CommonMethod commonMethod;

    private static final String jarUrl = (String) ReadConfUtil.readYml("update.yml","update.jarUrl");
    private static final String versionUrl = (String) ReadConfUtil.readYml("update.yml","update.versionUrl");
    private static final String configUrl = (String) ReadConfUtil.readYml("update.yml","update.configUrl");
    private static final int PORT = (int) ReadConfUtil.readYml("application.yml","server.port");

    //定时更新，现在不用了
//    @Scheduled(cron = "0 0 6 * * ?")
    public void scheduledUpdate(){
        log.info("--Start checking for automatic updates--");
        String path = System.getProperty("user.dir");
        //获取服务器上最新版本
        String newVersion = SendHTTPUtil.getReturnString(versionUrl, new HashMap<>());
        //version.txt获取不到
        if ("error".equals(newVersion)){
            log.error("ERROR2: Get version file failed");
            return;
        }
        //获取config文件夹的version
        String bar = File.separator;
        String currentVersionFilePath = path + bar + "config" + bar + "version.txt";
        String currentVersion = commonMethod.readFile(currentVersionFilePath);
        String systemType = commonMethod.getSystemType();
        //对比版本
        //版本相同，不做修改
        if (currentVersion.equals(newVersion)){
            log.info("--No update required--");
        }
        //版本不同，开始自动更新
        else {
            log.info("--Start automatic update--");
            String command;
            String newJarName = "agent-grpc-"+newVersion+".jar";
//            int flag = 0;
            //先下载文件，下载到当前目录,报错直接返回
            int i = SendHTTPUtil.downloadFile(jarUrl, path + bar + newJarName);
            //下载失败
            if (i ==0){
                log.error("ERROR2: Download agent jar failed");
                return;
            }
            try {
                SendHTTPUtil.downloadFile(configUrl,path+bar+"config.tar.gz");
                //解压缩config文件
                command = Constants.TAR + " -zxvf config.tar.gz";
                try {
                    ExecSystemCommandUtil.execCommand(path,command,"utf-8");
                } catch (IOException e) {
                    log.error("ERROR2: Decompression failed",e);
                }
            }catch (Exception e){
                log.error("ERROR2: Automatic update failed",e);
            }finally {
                //删除压缩文件
                try {
                    Files.delete(Paths.get("config.tar.gz"));
                } catch (IOException e) {
                    log.error("ERROR2: Delete config.tar.gz failed",e);
                }
            }
            //获取agent的pid
            ArrayList<Integer> pids = commonMethod.getAllPid(PORT,path,0);
            if (pids.get(0) == 0){
                log.error("ERROR2: pid does not exist,auto update failed");
                return;
            }
            if (pids.size() >=2){
                log.error("ERROR2: Multiple pid,auto update failed");
                return;
            }
            //获取旧jar包名字
            String oldJarName;
            File file = new File(path + bar +"agent-grpc.jar");
            if (file.exists())
                oldJarName = "agent-grpc.jar";
            else
                oldJarName = "agent-grpc-" + currentVersion + ".jar";
            /*
            准备工作完成,调用脚本：
            1.杀死agent进程
            2.删除旧jar
            3.启动新jar
             */
            if ("Linux".equals(systemType)){
                command =Constants.NOHUP + " bash script"+File.separator+"update.sh "+pids.get(0)+" "+oldJarName+" "+newJarName+" >/dev/null 2>&1 &";
            }
            else {
                command =Constants.START + " script"+File.separator+"update.bat "+pids.get(0)+" "+oldJarName+" "+newJarName;
            }
            try {
                log.info("=====Auto update=====");
                ExecSystemCommandUtil.execCommand(path,command,"utf-8");
            } catch (IOException e) {
                log.error("ERROR2: Exec update command failed",e);
            }
        }
    }

    public AgentUpdateEntity checkUpdate(){
        log.info("--Start checking for automatic updates--");
        AgentUpdateEntity agentUpdateEntity = new AgentUpdateEntity();
        String userDir = System.getProperty("user.dir");
        //获取服务器上最新版本
        String newVersion = SendHTTPUtil.getReturnString(versionUrl, new HashMap<>());
        //version.txt获取不到
        if ("error".equals(newVersion)){
            return exceptionHandling("Get version file failed");
        }
        //获取config文件夹的version
        String bar = File.separator;
        String currentVersionFilePath = userDir + bar + "config" + bar + "version.txt";
        String currentVersion = commonMethod.readFile(currentVersionFilePath);
        //对比版本
        //版本相同，无需更新
        if (currentVersion.equals(newVersion)){
            log.info("--No update required--");
            agentUpdateEntity.setCode(0);
            return agentUpdateEntity;
        }
        //版本不同，下载文件做好准备工作
        else {
            log.info("--Start automatic update--");
            String newJarPath = userDir + bar + "agent-grpc-" + newVersion + ".jar";
            //下载jar包和config压缩包，下载到当前目录,报错直接返回
            int i = SendHTTPUtil.downloadFile(jarUrl, newJarPath);
            if (i == 0)
                return exceptionHandling("Download agent-jar failed");
            i = SendHTTPUtil.downloadFile(configUrl, userDir + bar + "config.tar.gz");
            if (i == 0){
                try {
                    Files.delete(Paths.get(newJarPath));
                } catch (IOException e) {
                    log.error("ERROR2: Delete agent-jar failed", e);
                }
                return exceptionHandling("Download config file failed");
            }

            //获取agent的pid
            ArrayList<Integer> pids = commonMethod.getAllPid(PORT, userDir, 0);
            if (pids.get(0) == 0) {
                return exceptionHandling("pid does not exist,auto update failed");
            }
            if (pids.size() >= 2) {
                return exceptionHandling("Multiple pid,auto update failed");
            }
            //获取旧jar包名字
            String oldJarName;
            File file = new File(userDir + bar +"agent-grpc.jar");
            if (file.exists())
                oldJarName = "agent-grpc.jar";
            else
                oldJarName = "agent-grpc-" + currentVersion + ".jar";

            //自动更新前置条件完成，返回响应信息
            agentUpdateEntity.setPid(pids.get(0));
            agentUpdateEntity.setCode(2);
            agentUpdateEntity.setOldJarName(oldJarName);
            agentUpdateEntity.setNewJarName("agent-grpc-" + newVersion + ".jar");
            return agentUpdateEntity;
        }
    }

    public void startUpdate(AgentUpdateEntity req){
        String command;
        String systemType = commonMethod.getSystemType();
        String userDir = System.getProperty("user.dir");
        //把更新信息写入本地
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("execid",req.getExecid());
            jsonObject.put("index",req.getIndex());
            jsonObject.put("isUpdate",1);
            Files.write(Paths.get(userDir,"update.json"),jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            log.error("ERROR2: Write to file failed");
            SendGrpcUtil.TaskStatus(req.getExecid(),req.getIndex(),8,1,"Write to file failed");
            //删除之前下载的文件
            try {
                Files.delete(Paths.get(userDir,"config.tar.gz"));
                Files.delete(Paths.get(userDir,req.getNewJarName()));
            } catch (IOException ioException) {
                log.error("ERROR2: Delete file failed");
            }
        }
        //解压缩config文件
        try {
            command = Constants.TAR + " -zxvf config.tar.gz";
            ExecSystemCommandUtil.execCommand(userDir, command, "utf-8");
        }
        catch (IOException e) {
            log.error("ERROR2: Decompression failed",e);
            SendGrpcUtil.TaskStatus(req.getExecid(),req.getIndex(),8,1,"Decompression failed");
        }
        finally {
            //删除压缩文件
            try {
                Files.delete(Paths.get(userDir,"config.tar.gz"));
            } catch (IOException e) {
                log.error("ERROR2: Delete config.tar.gz failed",e);
                SendGrpcUtil.TaskStatus(req.getExecid(),req.getIndex(),8,1,"Delete config.tar.gz failed");
            }
        }
        /*
            准备工作完成,调用脚本：
            1.杀死agent进程
            2.删除旧jar
            3.启动新jar
             */
        if ("Linux".equals(systemType)){
            command =Constants.NOHUP + " bash script"+File.separator+"update.sh "+req.getPid()+" "+req.getOldJarName()+" "+req.getNewJarName()+" >/dev/null 2>&1 &";
        }
        else {
            command =Constants.START + " script"+File.separator+"update.bat "+req.getPid()+" "+req.getOldJarName()+" "+req.getNewJarName();
        }
        try {
            log.info("=====Auto update=====");
            ExecSystemCommandUtil.execCommand(userDir,command,"utf-8");
        } catch (IOException e) {
            log.error("ERROR2: Exec update command failed",e);
            SendGrpcUtil.TaskStatus(req.getExecid(),req.getIndex(),8,1,"Exec update command failed");
        }
    }

    public AgentUpdateEntity exceptionHandling(String message){
        AgentUpdateEntity agentUpdateEntity = new AgentUpdateEntity();
        log.error("ERROR2: "+message);
        agentUpdateEntity.setCode(1);
        agentUpdateEntity.setMessage(message);
        return agentUpdateEntity;
    }

    public void mergeYml(String mainYmlPath ,String addYmlPath){
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResolutionMethod(YamlProcessor.ResolutionMethod.OVERRIDE_AND_IGNORE);
        factoryBean.setResources(new FileSystemResource(addYmlPath),new FileSystemResource(mainYmlPath));
        Properties properties = factoryBean.getObject();
    }
}
