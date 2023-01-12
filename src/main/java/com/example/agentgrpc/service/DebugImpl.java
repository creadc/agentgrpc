package com.example.agentgrpc.service;

import com.example.agentgrpc.bll.AsyncTask;
import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.protocol.debug.*;
import com.example.agentgrpc.utils.OrganizeDocumentsUtil;
import com.example.agentgrpc.utils.ReadConfUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashSet;

@Slf4j
@GrpcService
public class DebugImpl extends DebugGrpc.DebugImplBase {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private OrganizeDocumentsUtil organizeDocumentsUtil;

    @Autowired
    private Analyze analyze;

    @Autowired
    private CommonMethod commonMethod;

    @Autowired
    private AsyncTask asyncTask;

    @Override
    public void getServletContext(ContextReq request, StreamObserver<ContextRes> responseObserver) {
        HashSet<String> set = new HashSet<>();
        set.add("javax.servlet.context.tempdir");
        set.add("org.apache.catalina.resources");
        set.add("org.apache.catalina.webappVersion");
        set.add("org.springframework.web.context.WebApplicationContext.ROOT");
        set.add("org.springframework.web.context.support.ServletContextScope");
        set.add("org.apache.tomcat.InstanceManager");
        set.add("org.apache.catalina.jsp_classpath");
        set.add("javax.websocket.server.ServerContainer");
        set.add("org.apache.tomcat.JarScanner");

        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        log.info("====Get ServletContext begin====");
        while(attributeNames.hasMoreElements()){
            String key = attributeNames.nextElement();
            if (!set.contains(key)){
                Object value = servletContext.getAttribute(key);
                log.info(key+" : "+value.toString());
            }
        }
        log.info("====Get ServletContext over====");

        //返回
        ContextRes res = ContextRes.newBuilder().build();
        responseObserver.onNext( res );
        responseObserver.onCompleted();
    }

    @Override
    public void test(TestReq request, StreamObserver<TestRes> responseObserver) {

        Path jmeterBinDirPath = Paths.get(System.getProperty("user.dir"),"config","jmeter","bin");
        //把jmeter.log复制过来
        File preLogFile = new File(String.valueOf(Paths.get(String.valueOf(jmeterBinDirPath),"jmeter.log")));
        File newLogFile = new File(String.valueOf(Paths.get("C:\\Users\\yzp\\Desktop\\83f9a878-9316-4ba9-b94b-511c6836b72a_1_2023-01-10-22-02","jmeter.log")));
        try {
            Files.copy(preLogFile.toPath(),newLogFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        organizeDocumentsUtil.organizeJtlBakFiles();
        TestRes res = TestRes.newBuilder().build();
        responseObserver.onNext( res );
        responseObserver.onCompleted();
    }
}
