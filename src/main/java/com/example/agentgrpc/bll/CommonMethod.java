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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

        int projectType = node.getProjType();

        //连接失败
        if (jsonObject.containsKey("errorMessage")){
            String message = String.valueOf(jsonObject.get("errorMessage"));

            //常规报错:未启动
            if("ConnectException".equals(message)){
                //华宇启动中也是ConnectException，这里特殊处理
                if (projectType == 5){
                    log.info("Project state:down or starting");
                    return 0;
                }
                else {
                    log.info("Project state:down");
                    return 0;
                }
            }
            //卡住，启动中或宕机
            else if("SocketTimeoutException".equals(message)){
                log.info("Project state:starting or crash");
                return -1;
            }
            //一些国产化中间件启动时是404
            else if ("HttpClientErrorException".equals(message)){
                log.info("Localization project state:starting");
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
        int projType = node.getProjType();//容器类型
        String command;

        //linux
        if ("Linux".equals(osType)){
            //tomcat
            if (projType == 1 || projType == 0)
                command="bash startup.sh";
            //国产化容器
            else
                switch (projType){
                    //东方通
                    case 2:
                    //华宇
                    case 5:
                        command="nohup ./startserver.sh &";break;
                    //宝蓝德
                    case 3:{
                        Map<String,String> map = node.getAttrsMap();
                        String user = map.get("user");
                        String pwd = map.get("pwd");
                        if (user.length()>0 && pwd.length()>0){
                            command="nohup ./iastool --passport "+pwd+" start --server --user "+user+" --password "+pwd+" &";
                        }
                        //用户名或密码为空
                        else{
                            log.error("ERROR2: The user name or password of bes is empty");
                            return;
                        }
                        break;
                    }
                    //金蝶
                    case 4:
                    //中创
                    case 6: {
                        Map<String,String> map = node.getAttrsMap();
                        if (map.size()==0)
                            command="nohup ./asadmin start-domain &";
                        else{
                            String domainName = map.get("domainName");
                            if (domainName.length()>0)
                                command="nohup ./asadmin start-domain "+domainName+" &";
                            else {
                                log.error("ERROR2: The domain of apusic is empty");
                                return;
                            }
                        }
                        break;
                    }
                    //其他，做报错处理
                    default:{
                        log.error("ERROR2: Unknown project type:"+projType);
                        return;
                    }
                }
        }
        //windows
        else if("Windows".equals(osType))
            command="startup.bat";
        //其他
        else{
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
    public void justStop(int pid){
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
                if(!(arrayList.isEmpty())){
                    log.error("ERROR2: The result is not empty:stop project");
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

    //只重启
    public void justRestart(NodeInfo node){
        ArrayList<Integer> pids = getAllPid(Integer.parseInt(node.getPort()),node.getBinPath(),node.getProjType());
        //工程状态为启动，要先停止
        if(pids.get(0) != 0){
            for (Integer pid : pids) {
                justStop(pid);
            }
        }
        //延时
        delay(1);
        //启动
        justStart(node);
    }

    //获取所有pid，用到pgrep和natstat，没有返回0
    public ArrayList<Integer> getAllPid(int port, String binPath,int projType){
        String osType = getSystemType();
        String command;
        ArrayList<String> arrayList;
        ArrayList<Integer> pids = new ArrayList<>();
        int temp;
        //如果binPath最后是/，把/去掉
        if(binPath.endsWith("/"))
            binPath = binPath.substring(0,binPath.length()-1);

        //linux
        if("Linux".equals(osType)){
            if (projType == 1 || projType == 0)
                command = Constants.PGREP_ON_LINUX + " -f " + binPath;
            else {
                switch (projType){
                    //东方通
                    case 2:
                    //华宇
                    case 5:command = Constants.PGREP_ON_LINUX + " -f " + binPath;break;
                    //宝蓝德
                    case 3:
                    //金蝶
                    case 4:
                    //中创
                    case 6:command = Constants.PGREP_ON_LINUX + " -f " + binPathToProjPath(binPath);break;
                    default:{
                        log.error("ERROR2: Unknown project type:"+projType);
                        pids.add(0);
                        return pids;
                    }
                }
            }

            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX,command,"utf-8");
            } catch (IOException e) {
                log.error("ERROR2: Exec command failed:pgrep",e);
                pids.add(0);
                return pids;
            }
            //把pid放到结果集合中
            try {
                for (String s : arrayList) {
                    temp = Integer.parseInt(s);
                    pids.add(temp);
                }
            }
            catch (Exception e){
                log.error("ERROR1: Pid parse int failed,No pid");
            }
            //再用netstat查一次
            command = Constants.NETSTAT_ON_LINUX+" -ntlp |grep :"+ port;
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX,command,"utf-8");
            } catch (IOException e) {
                log.error("ERROR2: Exec command failed:netstat",e);
                if (arrayList.isEmpty())
                    pids.add(0);
                return pids;
            }
            for (String s : arrayList) {
                String[] s2 = removeNullFromList(s.split(" "));
                if(s2.length >= 7 && "LISTEN".equals(s2[5]) && s2[3].contains(":"+port) && s2[6].contains("/")){
                    int res = Integer.parseInt(s2[6].substring(0,s2[6].indexOf("/")));
                    //使用端口查询和使用bin路径查到的pid不一致，说明端口被占用了
                    if (!pids.contains(res)){
                        log.info("ERROR2: Port is occupied,PID:"+res);
                        pids.add(res);
                    }
                }
            }
            //判断pids是否为空，如果为空就加上0，返回没有占用
            if (pids.isEmpty()){
                pids.add(0);
                log.error("ERROR1: PID does not exist");
            }
            for (Integer pid : pids) {
                log.info("PID: "+pid);
            }
            return pids;
        }

        //windows
        //使用netstat查找
        command =Constants.NETSTAT_ON_WINDOWS + " -ano |findstr :"+port;
        try {
            arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_WINDOWS,command,"gbk");
            String arrayString = arrayList.toString();
            //不含有效数据
            if(!arrayString.contains("TCP")){
                log.info("PID does not exist");
                pids.add(0);
                return pids;
            }

            //含有效数据
            for (String stringTemp : arrayList) {
                //获取第一行有效结果
                if (stringTemp.contains("LISTENING") && stringTemp.contains(":"+port)) {
                    //还需要判断port是否在第二个位置，即源端口
                    String[] temp1 = stringTemp.split(" ");
                    String[] temp2 = removeNullFromList(temp1);
                    //找到对应的pid
                    if (temp2[1].contains(":"+port)){
                        log.info("PID:"+temp2[4]);
                        pids.add(Integer.parseInt(temp2[4]));
                        return pids;
                    }
                }
            }
            //没有端口对应的pid
            log.error("ERROR2: PID does not exist");
            pids.add(0);
            return pids;
        } catch (IOException e) {
            log.error("ERROR2: Get pid failed",e);
        }
        log.error("ERROR2: PID does not exist.It should not be here");
        pids.add(0);
        return pids;
    }

    //获取工程pid，只用到pgrep，没有返回0。适用于打堆栈和打dump
    public ArrayList<Integer> getPidByBinPath(int port, String binPath,int projType){
        String osType = getSystemType();
        String command;
        ArrayList<String> arrayList;
        ArrayList<Integer> pids = new ArrayList<>();
        //linux
        if("Linux".equals(osType)){
            if (projType == 1 || projType == 0)
                command = Constants.PGREP_ON_LINUX + " -f " + binPath;
            else {
                switch (projType){
                    //东方通
                    case 2:
                        //华宇
                    case 5:command = Constants.PGREP_ON_LINUX + " -f " + binPath;break;
                    //宝蓝德
                    case 3:
                        //金蝶
                    case 4:
                        //中创
                    case 6:command = Constants.PGREP_ON_LINUX + " -f " + binPathToProjPath(binPath);break;
                    default:{
                        log.error("ERROR2: Unknown project type:"+projType);
                        pids.add(0);
                        return pids;
                    }
                }
            }
            try {
                arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_LINUX,command,"utf-8");
            } catch (IOException e) {
                log.error("ERROR2: Exec command failed:pgrep",e);
                pids.add(0);
                return pids;
            }
            //把pid放到结果集合中
            for (String s : arrayList) {
                pids.add(Integer.valueOf(s));
            }
            //判断pids是否为空，如果为空就加上0，返回没有占用
            if (pids.isEmpty()){
                pids.add(0);
                log.error("ERROR2: PID does not exist");
            }
            for (Integer pid : pids) {
                log.info("PID: "+pid);
            }
            return pids;
        }

        //windows
        //使用netstat查找
        command =Constants.NETSTAT_ON_WINDOWS + " -ano |findstr :"+port;
        try {
            arrayList = ExecSystemCommandUtil.execCommand(DEFAULT_PATH_ON_WINDOWS,command,"gbk");
            String arrayString = arrayList.toString();
            //不含有效数据
            if(!arrayString.contains("TCP")){
                log.info("PID does not exist");
                pids.add(0);
                return pids;
            }

            //含有效数据
            for (String stringTemp : arrayList) {
                //获取第一行有效结果
                if (stringTemp.contains("LISTENING") && stringTemp.contains(":"+port)) {
                    //还需要判断port是否在第二个位置，即源端口
                    String[] temp1 = stringTemp.split(" ");
                    String[] temp2 = removeNullFromList(temp1);
                    //找到对应的pid
                    if (temp2[1].contains(":"+port)){
                        log.info("PID:"+temp2[4]);
                        pids.add(Integer.parseInt(temp2[4]));
                        return pids;
                    }
                }
            }
            //没有端口对应的pid
            log.error("ERROR2: PID does not exist");
            pids.add(0);
            return pids;
        } catch (IOException e) {
            log.error("ERROR2: Get pid failed",e);
        }
        log.error("ERROR2: PID does not exist.It should not be here");
        pids.add(0);
        return pids;
    }

    //旧的获取pid的方法，已弃用
    public int getPID_bak(int port){
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
                log.error("ERROR2: Exec command failed:netstat -ntulp | grep",e);
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
            if(time){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                dirPath = agentPath+bar+dirName+bar+execId+Constants.DIVISION+index+Constants.DIVISION+sdf.format(System.currentTimeMillis())+bar;
            }
            else dirPath = agentPath+bar+dirName+bar+execId+Constants.DIVISION+index+bar;
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

    //删除特定文件，用于换jar包时删除fine-开头的jar包
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
        String jsonStr;
        FileReader fileReader = null;
        Reader reader = null;
        StringBuffer sb;
        try {
            File jsonFile = new File(filePath);
            fileReader = new FileReader(jsonFile);
            reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch;
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

    //去掉/bin
    public String binPathToProjPath(String binPath){
        //如果binPath最后是/，把/去掉
        if(binPath.endsWith("/"))
            binPath = binPath.substring(0,binPath.length()-1);
        if (binPath.endsWith("/bin"))
            return binPath.substring(0,binPath.length()-4);
        return binPath;
    }
}
