package com.example.agentgrpc.jmeter;

import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.pojo.StressCheckEntity;
import com.example.agentgrpc.utils.SendGrpcUtil;
import lombok.extern.slf4j.Slf4j;

import org.apache.jmeter.JMeter;
import org.apache.jmeter.config.CSVDataSet;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.SearchByClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Component
public class Stress {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private CommonMethod commonMethod;

    private static final String JMETER_PROPERTIES = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter", "bin", "jmeter.properties"));
    private static final String JMETER_HOME = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter"));
    private static final String pathToJmeterComponentsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_components.jar"));
    private static final String pathToJmeterHttpJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_http.jar"));
    private static final String pathToJmeterFunctionsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_functions.jar"));
    private static final String pathToJmeterPlugManagerJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "jmeter-plugins-manager-1.7.jar"));
    //压测前检查
    public StressCheckEntity check(String jmxPath, String jmxName, String jtlDirPath, ArrayList<String> fileNames){
        //初始化
        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES);
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.initLocale();

        StressCheckEntity res = new StressCheckEntity();
        //获取jmx文件
        File file = new File(String.valueOf(Paths.get(jmxPath,jmxName)));
        HashTree jmxTree;
        try {
            jmxTree = SaveService.loadTree(file);
        } catch (Exception e) {
            log.error("ERROR2: Load jmxTree failed",e);
            commonMethod.delPath(jtlDirPath);
            res.setRes("JMeter run failed:load jmxTree failed");
            return res;
        }
        //去掉被注释的组件
        JMeter.convertSubTree(jmxTree, false);

        //修改csv文件位置
        SearchByClass<CSVDataSet> csvDataSetSearch = new SearchByClass<>(CSVDataSet.class);
        jmxTree.traverse(csvDataSetSearch);
        Collection<CSVDataSet> csvDataSets = csvDataSetSearch.getSearchResults();
        for (CSVDataSet csvDataSet : csvDataSets) {
            String tempName = csvDataSet.getProperty("filename").getStringValue();
            //jmx中有csv文件但是没有传过来
            if (fileNames.size()==0){
                log.error("ERROR2: Missing csv file");
                commonMethod.delPath(jtlDirPath);
                res.setRes("JMeter run failed:Missing csv file");
                return res;
            }
            //标记
            int flag = 0;
            for (String fileName : fileNames) {
                if(tempName.equals(fileName)){
                    csvDataSet.getProperty("filename").setObjectValue(Paths.get(jmxPath,fileName));
                    flag++;
                }
            }
            //没有替换，说明jmx的csv和传来的csv名字不一致
            if (flag == 0){
                String s = "The csv file is inconsistent,csv file in jmx file is \""+tempName+"\"";
                log.error("ERROR2: "+s);
                res.setRes(s);
                return res;
            }
        }
        res.setRes("success");
        res.setHashTree(jmxTree);
        return res;
    }

    //jmx文件路径,生成的jtl文件存放目录,jtl文件名,标识(用于servlet上下文),附加文件集合(csv等)
    public void run(HashTree jmxTree,String jtlDirPath, String jtlName, String id) throws Exception {

        //初始化
        String pathToJmeterJars = pathToJmeterFunctionsJars + ";" + pathToJmeterHttpJars
                + ";" + pathToJmeterComponentsJars + ";" + pathToJmeterPlugManagerJars;
        System.setProperty(JMeter.JMETER_NON_GUI, "true");
        System.setProperty("java.class.path", pathToJmeterJars);

        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES);
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.initLocale();

        StandardJMeterEngine engine = new StandardJMeterEngine();

        //结果收集
        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        ResultCollector resultCollector = new ResultCollector(summer);
        String jtlFile = jtlDirPath + jtlName;
        resultCollector.setFilename(jtlFile);
        jmxTree.add(jmxTree.getArray()[0], resultCollector);

        //测试执行
        if (!jmxTree.isEmpty()) {
            engine.configure(jmxTree);
            servletContext.setAttribute(id, engine);
            engine.run();
        }
    }

    //jmx文件路径,生成的jtl文件存放目录,jtl文件名,标识(用于servlet上下文),附加文件集合(csv等)
    public void run_bak(String jmxPath,String jmxName, String jtlDirPath, String jtlName, String id,ArrayList<String> fileNames,String execId,int index) throws Exception {

        //初始化
        String pathToJmeterJars = pathToJmeterFunctionsJars + ";" + pathToJmeterHttpJars
                + ";" + pathToJmeterComponentsJars + ";" + pathToJmeterPlugManagerJars;
        System.setProperty(JMeter.JMETER_NON_GUI, "true");

        System.setProperty("java.class.path", pathToJmeterJars);

        StandardJMeterEngine engine = new StandardJMeterEngine();

        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES);
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.initLocale();

        //获取文件
        File file = new File(String.valueOf(Paths.get(jmxPath,jmxName)));

        //加载脚本
        HashTree jmxTree;
        try {
            jmxTree = SaveService.loadTree(file);
        } catch (IOException e) {
            log.error("ERROR2: Load jmxTree failed",e);
            commonMethod.delPath(jtlDirPath);
            SendGrpcUtil.TaskStatus(execId,index,3,1,"JMeter run failed:load jmxTree failed");
            return;
        }
        JMeter.convertSubTree(jmxTree, false);
        //设置jmx脚本文件的工作目录，可以根据这个来找到参数化文件及实现其文件流。
//        FileServer.getFileServer().setBaseForScript(jmxFile);

        //修改csv文件位置
        SearchByClass<CSVDataSet> csvDataSetSearch = new SearchByClass<>(CSVDataSet.class);
        jmxTree.traverse(csvDataSetSearch);
        Collection<CSVDataSet> csvDataSets = csvDataSetSearch.getSearchResults();
        for (CSVDataSet csvDataSet : csvDataSets) {
            String tempName = csvDataSet.getProperty("filename").getStringValue();
            if (fileNames.size()==0){
                log.error("ERROR2: Missing csv file");
                commonMethod.delPath(jtlDirPath);
                SendGrpcUtil.TaskStatus(execId,index,3,1,"JMeter run failed:Missing csv file");
                return;
            }
            for (String fileName : fileNames) {
                if(tempName.equals(fileName)){
                    csvDataSet.getProperty("filename").setObjectValue(Paths.get(jmxPath,fileName));
                }
                //如果不同就报错
                else {
                    log.error("ERROR2: The csv file is inconsistent,csv file in jmx file is \""+tempName+"\",uploaded csv file is \""+fileName+"\"");
                    SendGrpcUtil.TaskStatus(execId,index,3,1,"The csv file is inconsistent,csv file in jmx file is \""+tempName+"\",uploaded csv file is \""+fileName+"\"");
                    return;
                }
            }
        }

        //结果收集
        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        ResultCollector resultCollector = new ResultCollector(summer);
        String jtlFile = jtlDirPath + jtlName;
        resultCollector.setFilename(jtlFile);
        jmxTree.add(jmxTree.getArray()[0], resultCollector);

        //测试执行
        if (!jmxTree.isEmpty()) {
            engine.configure(jmxTree);
            servletContext.setAttribute(id, engine);
            engine.run();
        }
    }
}