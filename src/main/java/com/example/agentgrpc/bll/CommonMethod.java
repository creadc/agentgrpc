package com.example.agentgrpc.bll;

import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.protocol.project.NodeInfo;
import com.example.agentgrpc.utils.Constants;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
import com.example.agentgrpc.utils.ReadConfUtil;
import com.example.agentgrpc.utils.SendHTTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CommonMethod {

    private static final String DEFAULT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.defaultPathOnLinux");
    private static final String DEFAULT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.defaultPathOnWindows");
    private static final String AGENT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnLinux");
    private static final String AGENT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnWindows");



    //获取工程状态(无jar版本简略版),返回1为启动,返回0为关闭,返回-1为宕机和未知错误
    public int getProjectState(NodeInfo node){
        //发送http请求，判断工程状态
        String url="http://"+node.getIp()+":"+Integer.parseInt(node.getPort())
                +"/"+node.getWebapps()+"/"+node.getServlet()+"/system/info";
        JSONObject jsonObject = SendHTTPUtil.getReturnJson(url,new HashMap<>());

        //连接失败
        if (jsonObject.containsKey("errorMessage")){
            String message = String.valueOf(jsonObject.get("errorMessage"));

            //常规报错:未启动
            if("ConnectException".equals(message)){
                log.info("Project state:down");
                return 0;
            }
            //宕机
            else if("SocketTimeoutException".equals(message)){
                log.info("Project state:starting or crash");
                return -1;
            }
            //其他错误
            else{
                log.error("ERROR2: Project state:down,other error");
                return -1;
            }
        }
        //无报错信息，说明已启动
        log.info("Project state:up");
        return 1;
    }

    //只启动
    public void justStart(NodeInfo node){
        //数据准备
        String osType =getSystemType();
        String path=node.getBinPath();
        String command;

        switch (osType){
            case "Linux" : command="bash startup.sh";break;
            case "Windows" : command="startup.bat";break;
            default: command="other"; break;
        }
        //其他系统
        if("other".equals(command)){
            log.error("ERROR2: Neither Windows nor Linux");
            return;
        }
        try {
            //执行
            ExecSystemCommandUtil.execCommand(path,command,"utf-8");
        }catch (IOException e) {
            log.error("ERROR2: Failed to execute the command:start project",e);
        }
    }

    //只关闭
    public void justStop(NodeInfo node,int pid){
        String osType = getSystemType();
        String command;
        ArrayList<String> arrayList;
        //执行命令
        //linux
        if("Linux".equals(osType)){
            command = Constants.KILL + " -9 "+pid;
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX, command, "utf-8");
                //结果分析
                if(!arrayList.isEmpty()){
                    log.error("ERROR2: The result is empty:stop project");
                }
            } catch (IOException e) {
                log.error("ERROR2: Failed to execute the command:stop project",e);
            }

        }
        //windows
        else if("Windows".equals(osType)){
            command =Constants.TASKKILL + " /f /t /im "+pid;
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_WINDOWS, command, "gbk");
                //结果分析
                if(!arrayList.toString().contains("成功")){
                    log.error("ERROR2: The result is empty:stop project");
                }
            } catch (IOException e) {
                log.error("ERROR2: Failed to execute the command:stop project",e);
            }
        }
    }

    //获取工程pid，没有返回0
    public int getPID(int port){
        String osType = getSystemType();
        String command;

        //linux
        if("Linux".equals(osType)){
            //先使用ss命令查找
            command =Constants.SS + " -pntl 'sport = :"+port+"'";
            ArrayList<String> arrayList = null;
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX,command,"utf-8");
                String arrString1 = arrayList.toString();
                //结果不包含pid
                if (!arrString1.contains("pid=")){
                    log.error("ERROR2: PID does not exist");
                    return 0;
                }
                //结果包含pid
                String[] arrString2 = arrString1.split("users:");
                String[] arrString3 = arrString2[1].split("pid=");
                //只有一个结果
                if (arrString3.length==2){
                    int res = Integer.parseInt(arrString3[1].substring(0,arrString3[1].indexOf(",")));
                    log.info("PID:"+res);
                    return res;
                }
            } catch (IOException e) {
                log.error("ERROR2: Get pid failed",e);
            }
            //有多个结果无法判断,此时换成netstat命令再次运行
            log.info("Use netstat -ntulp | grep");
            command =Constants.NETSTAT_ON_LINUX + " -ntulp | grep "+port;
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX,command,"utf-8");
            } catch (IOException e) {
                log.error("ERROR2: Exec command failed:netstat -ntulp | grep");
            }
            String s1 = arrayList.get(0);
            String[] s2 = removeNullFromList(s1.split(" "));
            if(String.valueOf(port).equals(s2[3].split(":")[1]) && "LISTEN".equals(s2[5])){
                int res = Integer.parseInt(s2[6].substring(0,s2[6].indexOf("/")));
                log.info("PID:"+res);
                return res;
            }
            log.error("ERROR2: PID does not exist.It should not be here");
            return 0;
        }

        //windows
        //使用netstat查找
        command =Constants.NETSTAT_ON_WINDOWS + " -ano |findstr "+port;
        ArrayList<String> arrayList;
        try {
            arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_WINDOWS,command,"gbk");
            String arrayString = arrayList.toString();
            //不含有效数据
            if(!arrayString.contains("TCP")){
                log.error("ERROR2: PID does not exist");
                return 0;
            }

            //含有效数据
            String s1 = null;
            for (String stringTemp : arrayList) {
                //获取第一行有效结果
                if (stringTemp.contains(String.valueOf(port))) {
                    s1 = stringTemp;
                    break;
                }
            }
            String[] s2 = removeNullFromList(s1.split(" "));
            //有端口对应的pid
            if(String.valueOf(port).equals(s2[1].split(":")[1]) && "LISTENING".equals(s2[3])){
                int res = Integer.parseInt(s2[4]);
                log.info("PID:"+res);
                return res;
            }
            //没有端口对应的pid
            log.error("ERROR2: PID does not exist");
            return 0;
        } catch (IOException e) {
            log.error("ERROR2: Get pid failed",e);
        }
        log.error("ERROR2: PID does not exist.It should not be here");
        return 0;
    }

    //获取系统类型
    public String getSystemType(){
        String os = System.getProperty("os.name");//判断系统类型
        if(os.equals("Linux")){
            return "Linux";
        }
        else if("Windows".equals(os.split(" ")[0])){
            return "Windows";
        }
        return "other";
    }

    //新建路径，若存在直接返回
    public boolean newPath(String filePath){
        File path = new File(filePath);
        if (!path.exists()){ //如果不存在
            return path.mkdirs();
        }
        return true;
    }

    //获取路径
    public String getPath(String dirName,String execId,int index,boolean time){
        //数据准备
        String osType = getSystemType();
        String agentPath;//agent目录
        String dirPath;//存放目录路径,为agent子目录
        String bar = File.separator;
        if("Linux".equals(osType)){
            agentPath = AGENT_PATH_ON_LINUX;
        }
        else{
            agentPath = AGENT_PATH_ON_WINDOWS;
        }
        if("null".equals(execId))
            dirPath = agentPath+bar+dirName+bar;
        else
            //加时间戳
            if(time)
                dirPath = agentPath+bar+dirName+bar+execId+"-"+index+"-"+System.currentTimeMillis()+bar;
            else dirPath = agentPath+bar+dirName+bar+execId+"-"+index+bar;
        return dirPath;
    }

    //初始化路径
    public String[] initPath(String dirName,String execId,int index,boolean time){
        String dirPath = getPath(dirName,execId,index,time);

        //新建目录
        boolean bool = newPath(dirPath);
        String[] strs = new String[2];
        
        if (!bool)
            strs[0] = "fail";
        else {
            strs[0] = "success";
            strs[1] = dirPath;
        }
        return strs;
    }

    //删除目录及其文件
    public void delPath(String dirPath){
        String osType =getSystemType();
        String defaultPath;
        String command;
        switch (osType){
            case "Linux":
                defaultPath = DEFAULT_PATH_ON_LINUX;
                command=Constants.RM + " -rf "+dirPath;
                break;
            case "Windows":
                defaultPath = DEFAULT_PATH_ON_WINDOWS;
                command=Constants.RMDIR + " /Q /S "+dirPath;
                break;
            default:
                return;
        }
        try {
            ExecSystemCommandUtil.execCommand(defaultPath,command,"UTF-8");
            log.info("Delete success");
        } catch (IOException e) {
            log.error("ERROR2: Delete fail",e);
        }
    }

    //删除特定文件
    public void delSpecificFiles(String path,int i){
        File dirPath = new File(path);
        File[] files = dirPath.listFiles();
        String tempFileName;
        log.info("Delete previous jar in "+path);
        for (File file : files) {
            tempFileName = file.getName();
            if (tempFileName.startsWith("fine-")){
                try {
                    Files.delete(Paths.get(file.getPath()));
                } catch (IOException e) {
                    log.error("ERROR2: Delete specific files failed",e);
                }
            }
        }
    }

    //调用系统命令复制文件
    public void copyFiles(ArrayList<String> fileNames,String origPath,String targPath){
        String osType =getSystemType();
        String command;
        String code;

        //文件名处理成长字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (String fileName : fileNames) stringBuilder.append(fileName).append(" ");
        String longFileNames = stringBuilder.toString();

        switch (osType){
            case "Linux":
                command=Constants.CP + " -f "+longFileNames+targPath;
                code="utf-8";
                break;
            case "Windows":
                command=Constants.ROBOCOPY + " "+origPath+" "+targPath+" /S /R:1 /W:2";
                code="gbk";
                break;
            default:
                return;
        }

        try {
            ExecSystemCommandUtil.execCommand(origPath,command,code);
            log.info("Copy success");
        } catch (IOException e) {
            log.error("ERROR2: Failed to execute the command:copy files",e);
        }
    }

    //移动文件
    public void moveFile(File srcDir,File decDir){
        File[] files = srcDir.listFiles ();//获取要复制文件夹所有内容
        if (files == null) return;//同样排除无权限的目录
        for (File file : files){//遍历文件数组
            if (file.isFile ()){//如果是文件,直接复制
                File file1 = new File ( decDir +"/"+ file.getName() );//先在目标目录创建文件
                try {
                    Files.copy(file.toPath(),file1.toPath());
                } catch (IOException e) {
                    log.error("ERROR2: Files.copy failed",e);
                }
            }else{//如果是文件夹
                //先创建目标目录下相对应文件夹
                File file1 = new File ( decDir +"/"+ file.getName() );
                //创建目录
                file1.mkdir ();
                moveFile(file,file1);//递归调用
            }
        }
    }

    //延时
    public void delay(int time){
        try {
            TimeUnit.SECONDS.sleep(time);//秒
        } catch (InterruptedException e) {
            log.error("ERROR2: Delay failed",e);
        }
    }

    //删除数组中为空的字符串
    public String[] removeNullFromList(String[] req){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : req) {
            if(!"".equals(s)){
                arrayList.add(s);
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    //读文件
    public String readFile(String filePath){
        String jsonStr = "";
        FileReader fileReader = null;
        Reader reader = null;
        StringBuffer sb;
        try {
            File jsonFile = new File(filePath);
            fileReader = new FileReader(jsonFile);
            reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            log.error("ERROR2: Read file failed",e);
            return null;
        }finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                log.error("ERROR2: Close stream failed",e);
            }
        }
    }
}
