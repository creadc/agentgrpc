package com.example.agentgrpc.utils;

import com.example.agentgrpc.enumm.SystemEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExecSystemCommandUtil {

    public static ArrayList<String> execCommand(String path, String command, String code) throws IOException {
        ArrayList<String> res = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder();// 命令
        pb.redirectErrorStream(true);// 重定向错误输出流到正常输出流

        //判断系统类型
        String os = System.getProperty("os.name");
        String type1 = null;
        String type2 = null;
        //linux
        if(os.equals("Linux")){
            type1= SystemEnum.LINUX.getCommand1();
            type2= SystemEnum.LINUX.getCommand2();
        }
        //windows
        else if(os.split(" ")[0].equals("Windows")){
            type1= SystemEnum.WINDOWS.getCommand1();
            type2= SystemEnum.WINDOWS.getCommand2();
        }

        Process process = null;
        BufferedReader br = null;
        InputStreamReader inputStreamReader = null;
        //运行
        try {
            log.info("Path:"+path+" || Command:"+type1+" "+type2+" "+command+" || Encoding:"+code);
            pb.command(type1,type2,command);// 执行命令
            pb.directory(new File(path));// 设置目录
            process = pb.start();// 启动进程
            inputStreamReader = new InputStreamReader(process.getInputStream(), code);
            br = new BufferedReader(inputStreamReader);
            String line;
            //遇到个问题,执行startup.bat时,readLine不会停止,所以禁用了
            if(command.equals("startup.bat")){}
            else{
                while (((line = br.readLine()) != null)) {
                    res.add(line);
                }
            }
        } catch (IOException e) {
            log.error("ERROR2: ExecCommandUtil run failed",e);
            throw e;
        }finally {
            //遇到个问题，windows启动后如果立刻关闭流会导致工程未启动，所以延迟1s
            if (command.equals("startup.bat")){
                try {
                    TimeUnit.SECONDS.sleep(1);//秒
                } catch (InterruptedException e) {
                    log.error("ERROR2: Delay failed",e);
                }
            }
            if (br != null)
                br.close();
            if (inputStreamReader != null)
                inputStreamReader.close();
            if (process != null)
                process.destroy();
        }
        return res;
    }
}
