package com.example.agentgrpc.jmeter;

import com.example.agentgrpc.bll.CommonMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.config.CSVDataSet;
import org.apache.jmeter.engine.JMeterEngineException;
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


    private static final String JMETER_PROPERTIES = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter", "bin", "jmeter.properties"));
    private static final String JMETER_HOME = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter"));
    private static final String pathToJmeterComponentsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_components.jar"));
    private static final String pathToJmeterHttpJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_http.jar"));
    private static final String pathToJmeterPlugManagerJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "jmeter-plugins-manager-1.7.jar"));
    private static final String pathToJmeterFunctionsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_functions.jar"));

    //jmx文件路径,生成的jtl文件存放目录,jtl文件名,标识(用于servlet上下文),附加文件集合(csv等)
    public void run(String jmxPath,String jmxName, String jtlDirPath, String jtlName, String id,ArrayList<String> fileNames) throws Exception {
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
        HashTree jmxTree = null;
        try {
            jmxTree = SaveService.loadTree(file);
        } catch (IOException e) {
            log.error("ERROR2: Load jmxTree failed",e);
        }

        //修改csv文件位置
        if (fileNames.size() > 0){
            SearchByClass<CSVDataSet> csvDataSetSearch = new SearchByClass<>(CSVDataSet.class);
            jmxTree.traverse(csvDataSetSearch);
            Collection<CSVDataSet> csvDataSets = csvDataSetSearch.getSearchResults();
            for (CSVDataSet csvDataSet : csvDataSets) {
                String tempName = csvDataSet.getProperty("filename").getStringValue();
                for (String fileName : fileNames) {
                    if(tempName.equalsIgnoreCase(fileName)){
                        csvDataSet.getProperty("filename").setObjectValue(Paths.get(jmxPath,fileName));
                    }
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
        JMeter.convertSubTree(jmxTree, false);

        //测试执行
        if (!jmxTree.isEmpty()) {
            engine.configure(jmxTree);
            servletContext.setAttribute(id, engine);
            engine.run();
        }
    }

}