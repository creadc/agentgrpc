package com.example.agentgrpc.jmeter;

import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.GenerationException;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Slf4j
@Component
public class Analyze {
//    @Autowired
//    private CommonMethod commonMethod;

    //过滤jtl文件
    public String filterJtl(String jtlDirPath, String jtlName){
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
            //读取数据
            while((s = br.readLine())!=null){
                tempStr = s.split(",");
//                System.out.println(tempStr[4]+"===="+tempStr[8]);
                if(tempStr[4]!=null && !tempStr[8].equals("false"))
                    bw.write(s+"\t\n");
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

    //分析jtl生成json文件,出错返回error
    public String jtlToJson(String jtlDirPath, String jtlName){
        CommonMethod commonMethod = new CommonMethod();
        String userDir = System.getProperty("user.dir");
        String bar = File.separator;
        String jtlPath = jtlDirPath+bar+jtlName;
        File jtlFile = new File(jtlDirPath);
        String[] split = jtlFile.getName().split(Constants.DIVISION);
        Path preJsonPath = Paths.get(userDir,"report-output","statistics.json");
        Path newJsonPath = null;
        ReportGenerator generator;
        //遇到个问题，如果过滤之后的jtl文件没有数据，在生成报告的时候会报错，而且不会执行catch。所以在生成报告之前判断jtl文件是否没有数据
        //使用Files.lines遇到个坑，它不会主动关闭流，如果agent程序不停文件一直被占用删不掉
//        try(Stream<String> stream = Files.lines(Paths.get(jtlPath))){
//            if (stream.count() < 2){
//                log.error("ERROR2: Jtl file is empty");
//                return split[0]+"-"+split[1]+"-"+jtlName.split("_filter")[0]+"-"+"ERROR";
//            }
//        } catch (IOException e){
//            log.error("ERROR2: Get the number of lines of jtl files failed");
//        }
        //换了种方法判空，不用读取全部行数
        if (JtlIsEmpty(jtlPath)){
            log.error("ERROR2: Jtl file is empty");
            return split[0]+Constants.DIVISION+split[1]+Constants.DIVISION+jtlName.split(Constants.DIVISION+"filter")[0]+Constants.DIVISION+"ERROR";
        }

        try {
            //生成报告
            log.info("Start generate report......");
            try {
                generator = new ReportGenerator(jtlPath,null);
                generator.generate();
            } catch (GenerationException e) {
                log.error("ERROR2: Generate report failed",e);
                commonMethod.delPath(jtlPath);
                return "error";
            }
            //获取execid和index，作为json文件名
            newJsonPath = Paths.get(jtlDirPath,split[0]+Constants.DIVISION+split[1]+Constants.DIVISION+jtlName.split(Constants.DIVISION+"filter")[0]+".json");
            //复制json
            try {
                Files.copy(preJsonPath,newJsonPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                log.error("ERROR2: Copy json failed",e);
                commonMethod.delPath(jtlPath);
            }
        } catch (ConfigurationException e) {
            log.error("ERROR2: Jtl to json failed",e);
            commonMethod.delPath(jtlPath);
        }finally {
            //删除html
            commonMethod.delPath(userDir+bar+"config"+bar+"jmeter"+bar+"bin"+bar+"report-output");
            //删除json的文件夹
            commonMethod.delPath(userDir+bar+"report-output");
        }
        return String.valueOf(newJsonPath);
    }

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
