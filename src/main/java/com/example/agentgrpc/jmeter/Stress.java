package com.example.agentgrpc.jmeter;

import com.example.agentgrpc.bll.CommonMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

@Slf4j
@Component
public class Stress {
    @Autowired
    private ServletContext servletContext;


    private static final String JMETER_PROPERTIES = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter", "bin", "jmeter.properties"));
    private static final String JMETER_HOME = String.valueOf(Paths.get(System.getProperty("user.dir"), "config", "jmeter"));
    private static final String pathToJmeterFunctionJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_functions-5.5.jar"));
    private static final String pathToJmeterComponentsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_components.jar"));
    private static final String pathToJmeterHttpJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_http.jar"));
    private static final String pathToJmeterPlugManagerJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "jmeter-plugins-manager-1.7.jar"));
    private static final String pathToJmeterFunctionsJars = String.valueOf(Paths.get(JMETER_HOME, "lib", "ext", "ApacheJMeter_functions.jar"));

    //jmx文件路径,生成的jtl文件存放目录,jtl文件名,标识(用于servlet上下文)
    public void run(String jmxPath, String jtlDirPath, String jtlName, String id) throws Exception {
        //初始化
        String pathToJmeterJars = pathToJmeterFunctionJars + ";" + pathToJmeterHttpJars
                + ";" + pathToJmeterComponentsJars + ";" + pathToJmeterPlugManagerJars;
        System.setProperty(JMeter.JMETER_NON_GUI, "true");
        System.setProperty("java.class.path", pathToJmeterJars);

        StandardJMeterEngine engine = new StandardJMeterEngine();

        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES);
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.initLocale();

        //获取文件
        File file = new File(jmxPath);

        //加载脚本
        HashTree jmxTree = null;
        try {
            jmxTree = SaveService.loadTree(file);
        } catch (IOException e) {
            log.error("ERROR2: Load jmxTree failed",e);
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