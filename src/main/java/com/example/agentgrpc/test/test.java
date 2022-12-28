package com.example.agentgrpc.test;

import com.example.agentgrpc.AgentgrpcApplication;
import com.example.agentgrpc.conf.TaskExecutorConfig;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.utils.ExecSystemCommandUtil;
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
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Executor;

@Component
public class test {

    public static void main(String[] args) {
//        ConfigurableApplicationContext s = SpringApplication.run(AgentgrpcApplication.class);
//        String[] beanDefinitionNames = s.getBeanDefinitionNames();
//        for (String name :beanDefinitionNames){
//     //       System.out.println(name);
//        }
//        TaskExecutorConfig taskExecutorConfig = s.getBean("taskExecutorConfig", TaskExecutorConfig.class);
//        Executor asyncTaskExecutor = taskExecutorConfig.getAsyncTaskExecutor();
//        asyncTaskExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(30);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
    }
}
