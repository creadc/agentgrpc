package com.example.agentgrpc.utils;

import com.example.agentgrpc.bll.CommonMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AutoUpdateUtil {
    @Autowired
    private CommonMethod commonMethod;

    private static final String jarUrl = (String) ReadConfUtil.readYml("update.yml","update.jarUrl");
    private static final String versionUrl = (String) ReadConfUtil.readYml("update.yml","update.versionUrl");
    private static final String configUrl = (String) ReadConfUtil.readYml("update.yml","update.configUrl");
    private static final int PORT = (int) ReadConfUtil.readYml("application.yml","server.port");

    @Scheduled(cron = "0 0 6 * * ?")
    public void checkUpdate(){
        //延时，避免同一时刻获取文件
//        try {
//            TimeUnit.SECONDS.sleep(new Random().nextInt(3600)+1);//秒
//        } catch (InterruptedException e) {
//            log.error("ERROR2: Delay failed",e);
//        }

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
            return;
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
            //准备工作完成,调用脚本
            ArrayList<Integer> pids = commonMethod.getAllPid(PORT,path);
            if (pids.get(0) == 0){
                log.error("ERROR2: pid does not exist,auto update failed");
                return;
            }
            if (pids.size() >=2){
                log.error("ERROR2: Multiple pid,auto update failed");
                return;
            }

            String oldJarName;
            File file = new File(path + bar +"agent-grpc.jar");
            if (file.exists())
                oldJarName = "agent-grpc.jar";
            else
                oldJarName = "agent-grpc-" + currentVersion + ".jar";
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

    public void mergeYml(String mainYmlPath ,String addYmlPath){
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResolutionMethod(YamlProcessor.ResolutionMethod.OVERRIDE_AND_IGNORE);
        factoryBean.setResources(new FileSystemResource(addYmlPath),new FileSystemResource(mainYmlPath));
        Properties properties = factoryBean.getObject();
    }
}
