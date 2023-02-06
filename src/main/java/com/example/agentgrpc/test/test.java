package com.example.agentgrpc.test;

import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.AgentgrpcApplication;
import com.example.agentgrpc.conf.TaskExecutorConfig;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.jmeter.Stress;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
import com.example.agentgrpc.utils.PropertiesToMapUtil;
import com.example.agentgrpc.utils.SendHTTPUtil;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.GenerationException;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executor;

@Component
public class test {

    public static void main(String[] args) {
        int[] i = {1,2};
        System.out.println(i[0]);
        System.out.println(i[1]);
        //发送http请求，判断工程状态
//        String url="http://124.71.152.17:8385/webroot/decision/system/info";
//        JSONObject jsonObject = SendHTTPUtil.getReturnJson(url, new HashMap<>());
//        String s = (String) jsonObject.get("errorMessage");
//        System.out.println(s);



//        String mainYmlPath="C:\\Users\\yzp\\Desktop\\application1.yml";
//        String addYmlPath="C:\\Users\\yzp\\Desktop\\application2.yml";
//        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
//        factoryBean.setResolutionMethod(YamlProcessor.ResolutionMethod.OVERRIDE_AND_IGNORE);
//        factoryBean.setResources(new FileSystemResource(addYmlPath),new FileSystemResource(mainYmlPath));
//        Properties properties = factoryBean.getObject();
//
////        Set<Object> objects = properties.keySet();
////        for (Object key : objects) {
////            System.out.println(key + ": " + properties.get(key));
////        }
//
//        write2Yaml(properties,"C:\\Users\\yzp\\Desktop\\application3.yml");
    }

    public static void write2Yaml(Properties properties,String filePath){
        try {
            if (properties == null) {
                return;
            }
            //properties 转化为yaml 格式字符串
            StringBuffer ymlString = PropertiesToMapUtil.prop2YmlString(properties);
            writeStr2File(ymlString,filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 把字符串写到指定的文件
     * @param msg
     * @param filePath
     */
    public static void writeStr2File(StringBuffer msg,String filePath){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            //将字符串写到指定文件
            fos.write(msg.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
