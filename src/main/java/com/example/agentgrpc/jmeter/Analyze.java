package com.example.agentgrpc.jmeter;

import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.utils.Constants;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

@Slf4j
@Component
public class Analyze {

    //过滤jtl文件
    public String filterJtl(String jtlDirPath, String jtlName,String filterName){
        //输入
        File oldFile = new File(jtlDirPath+"/"+jtlName);
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        //输出
        String newFileName = jtlName.split("\\.")[0]+ Constants.DIVISION+"filter.jtl";
        String newFilePath = jtlDirPath+"/"+newFileName;
        FileWriter newFile = null;
        BufferedWriter bw = null;
        try{
            //输入初始化
            fileInputStream = new FileInputStream(oldFile);
            inputStreamReader = new InputStreamReader(fileInputStream);
            br = new BufferedReader(inputStreamReader);
            //输出初始化
            newFile = new FileWriter(newFilePath);
            bw = new BufferedWriter(newFile);
            //使用readLine方法，一次读一行
            String s;
            String[] tempStr;
            //读取第一行
            s = br.readLine();
            bw.write(s+"\t\n");
            //读取数据并过滤

            //默认
            if (filterName == null || "".equals(filterName)){
                while((s = br.readLine())!=null){
                    tempStr = s.split(",");
                    if(tempStr.length >= 17 && !tempStr[4].equals("") && !tempStr[tempStr.length-10].equals("false"))
                        bw.write(s+"\t\n");
                }
            }
            //melissa
            else if (filterName.contains("melissa")){
                while((s = br.readLine())!=null){
                    tempStr = s.split(",");
                    if(tempStr.length >= 17 && !tempStr[4].equals("") && !tempStr[tempStr.length-10].equals("false") && !tempStr[2].contains("登录"))
                        bw.write(s+"\t\n");
                }
            }
            //nofilter
            else if (filterName.contains("nofilter")){
                while((s = br.readLine())!=null){
                    bw.write(s+"\t\n");
                }
            }
        }catch(Exception e){
            log.error("ERROR2: filter jtl failed",e);
        }
        finally {
            try {
                if (bw != null)
                    bw.close();
                if (newFile != null)
                    newFile.close();
                if (fileInputStream != null)
                    fileInputStream.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                log.error("ERROR2: Close stream failed",e);
            }
        }
        return newFileName;
    }

    //命令行分析jtl生成json文件,出错返回error
    public String jtlToJson(String jtlDirPath, String jtlName){
        CommonMethod commonMethod = new CommonMethod();
        String bar = File.separator;
        String jtlPath = jtlDirPath+bar+jtlName;
        File jtlFile = new File(jtlDirPath);
        String[] split = jtlFile.getName().split(Constants.DIVISION);
        Path jmeterBinDirPath = Paths.get(System.getProperty("user.dir"),"config","jmeter","bin");
        Path reportDirPath = Paths.get(jtlDirPath,"report");
        Path preJsonPath = Paths.get(jtlDirPath,"report","statistics.json");
        Path newJsonPath = Paths.get(jtlDirPath,split[0]+Constants.DIVISION+split[1]+Constants.DIVISION+jtlName.split(Constants.DIVISION+"filter")[0]+".json");
        //换了种方法判空，不用读取全部行数
        if (JtlIsEmpty(jtlPath)){
            log.error("ERROR2: Jtl file is empty");
            return String.valueOf(newJsonPath);
        }
        //如果reprot文件夹存在则删除
        File file = new File(String.valueOf(reportDirPath));
        if (file.exists())
            commonMethod.delPath(String.valueOf(reportDirPath));

        //生成报告
        log.info("Start generate report......");
        try {
            String command;
            //linux给jmeter加权限
            if (commonMethod.getSystemType().equals("Linux")){
                command = Constants.CHMOD+" +x jmeter";
                ExecSystemCommandUtil.execCommand(String.valueOf(jmeterBinDirPath), command, "utf-8");
            }

            //执行生成报告命令
            command = "."+bar+Constants.JMETER+" -g "+jtlPath+" -o "+reportDirPath;
            ArrayList<String> arrayList = ExecSystemCommandUtil.execCommand(String.valueOf(jmeterBinDirPath), command, "utf-8");
            String s = arrayList.toString();
            if(s != null && s.contains("An error occurred")){
                log.error("ERROR2: Exec command failed:genarate report,detailed information: "+s);

                //把jmeter.log复制过来
                File preLogFile = new File(String.valueOf(Paths.get(String.valueOf(jmeterBinDirPath),"jmeter.log")));
                File newLogFile = new File(String.valueOf(Paths.get(jtlDirPath,"jmeter.log")));
                Files.copy(preLogFile.toPath(),newLogFile.toPath());
            }


            //复制json
            try {
                Files.copy(preJsonPath,newJsonPath, StandardCopyOption.REPLACE_EXISTING);
            }
            //没有json文件，说明生成报告失败
            catch (NoSuchFileException e){
                log.error("ERROR2: No json file generated");
                commonMethod.delPath(jtlPath);
            }
            catch (IOException e) {
                log.error("ERROR2: Copy json failed",e);
                commonMethod.delPath(jtlPath);
            }
        } catch (Exception e) {
            log.error("ERROR2: Jtl to json failed",e);
            commonMethod.delPath(jtlPath);
        }finally {
            log.info("Generate report over");
            //删除报告
            commonMethod.delPath(String.valueOf(reportDirPath));
        }
        return String.valueOf(newJsonPath);
    }

    //通过java生成报告，有点问题，弃用
//    public String jtlToJson_old(String jtlDirPath, String jtlName){
//        CommonMethod commonMethod = new CommonMethod();
//        String userDir = System.getProperty("user.dir");
//        String bar = File.separator;
//        String jtlPath = jtlDirPath+bar+jtlName;
//        File jtlFile = new File(jtlDirPath);
//        String[] split = jtlFile.getName().split(Constants.DIVISION);
//        Path preJsonPath = Paths.get(userDir,"report-output","statistics.json");
//        Path newJsonPath = null;
//        ReportGenerator generator;
//        //遇到个问题，如果过滤之后的jtl文件没有数据，在生成报告的时候会报错，而且不会执行catch。所以在生成报告之前判断jtl文件是否没有数据
//        //使用Files.lines遇到个坑，它不会主动关闭流，如果agent程序不停文件一直被占用删不掉
////        try(Stream<String> stream = Files.lines(Paths.get(jtlPath))){
////            if (stream.count() < 2){
////                log.error("ERROR2: Jtl file is empty");
////                return split[0]+"-"+split[1]+"-"+jtlName.split("_filter")[0]+"-"+"ERROR";
////            }
////        } catch (IOException e){
////            log.error("ERROR2: Get the number of lines of jtl files failed");
////        }
//        //换了种方法判空，不用读取全部行数
//        if (JtlIsEmpty(jtlPath)){
//            log.error("ERROR2: Jtl file is empty");
//            return split[0]+Constants.DIVISION+split[1]+Constants.DIVISION+jtlName.split(Constants.DIVISION+"filter")[0]+Constants.DIVISION+"ERROR";
//        }
//
//        try {
//            //生成报告
//            log.info("Start generate report......");
//            try {
//                generator = new ReportGenerator(jtlPath,null);
//                generator.generate();
//            } catch (GenerationException e) {
//                log.error("ERROR2: Generate report failed",e);
//                commonMethod.delPath(jtlPath);
//                return "error";
//            }
//            //获取execid和index，作为json文件名
//            newJsonPath = Paths.get(jtlDirPath,split[0]+Constants.DIVISION+split[1]+Constants.DIVISION+jtlName.split(Constants.DIVISION+"filter")[0]+".json");
//            //复制json
//            try {
//                Files.copy(preJsonPath,newJsonPath, StandardCopyOption.REPLACE_EXISTING);
//            } catch (IOException e) {
//                log.error("ERROR2: Copy json failed",e);
//                commonMethod.delPath(jtlPath);
//            }
//        } catch (ConfigurationException e) {
//            log.error("ERROR2: Jtl to json failed",e);
//            commonMethod.delPath(jtlPath);
//        }finally {
//            //删除html
//            commonMethod.delPath(userDir+bar+"config"+bar+"jmeter"+bar+"bin"+bar+"report-output");
//            //删除json的文件夹
//            commonMethod.delPath(userDir+bar+"report-output");
//        }
//        return String.valueOf(newJsonPath);
//    }

    //判断jtl文件是否有数据
    public boolean JtlIsEmpty(String jtlPath){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jtlPath)))) {
            int i = 0;
            while (br.readLine() !=null) {
                i++;
                if (i >= 2){
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            log.error("ERROR2: Check jtl file failed,file not found",e);
        } catch (IOException e) {
            log.error("ERROR2: Check jtl file failed,io error",e);
        }
        return true;
    }
}
