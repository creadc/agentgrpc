package com.example.agentgrpc;

import com.example.agentgrpc.protocol.project.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class projectTest {

    private String IP1="localhost";
    private String IP2="124.70.178.70";
    private String IP3="192.168.101.21";
    private int port1=9090;
    private int port2=9091;

    public ManagedChannel init(){
        return ManagedChannelBuilder.forAddress(IP1, port1)
                .usePlaintext()
                .build();
    }

    @Test
    public void nodeState1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(1)
                .build();
        System.out.println(req);

        NodeStateRes res=stub.nodeState(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void nodeState2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(1)
                .build();
        System.out.println(req);

        NodeStateRes res=stub.nodeState(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void nodeState3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(1)
                .build();
        System.out.println(req);

        NodeStateRes res=stub.nodeState(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startNode1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(2)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void startNode2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(2)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void startNode3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(2)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stopNode1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.stopNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void stopNode2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.stopNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void stopNode3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.stopNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reStartNode1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(4)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.reStartNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void reStartNode2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(4)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.reStartNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void reStartNode3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(4)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.reStartNode(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceJar1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        ReplaceJarReq req = ReplaceJarReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(5)
                .setDownloadUrl("https://fine-build.oss-cn-shanghai.aliyuncs.com/SDET-FR/agent")
                .addFileList("config.tar.gz")
                .build();

        System.out.println(req);

        NodeControlRes res=stub.replaceJar(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void replaceJar2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        ReplaceJarReq req = ReplaceJarReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(5)
                .setDownloadUrl("https://www.voidtools.com/")
                .addFileList("Everything-1.4.1.1018.x86-Setup.exe")
                .addFileList("Everything-1.4.1.1020.x64-Setup.exe")
                .addFileList("Everything-1.4.1.1020.x86.zip")
                .addFileList("Everything-1.4.1.1020.x64.zip")
                .build();

        System.out.println(req);

        NodeControlRes res=stub.replaceJar(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void replaceJar3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        ReplaceJarReq req = ReplaceJarReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(5)
                .setDownloadUrl("https://www.voidtools.com/")
                .addFileList("Everything-1.4.1.1018.x86-Setup.exe")
                .addFileList("Everything-1.4.1.1020.x64-Setup.exe")
                .addFileList("Everything-1.4.1.1020.x86.zip")
                .addFileList("Everything-1.4.1.1020.x64.zip")
                .build();

        System.out.println(req);

        NodeControlRes res=stub.replaceJar(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void StartPrintJStacks1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        PrintStacksReq req=PrintStacksReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(6)
                .setInterval(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startPrintJStacks(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void StartPrintJStacks2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        PrintStacksReq req=PrintStacksReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(6)
                .setInterval(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startPrintJStacks(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void StartPrintJStacks3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        PrintStacksReq req=PrintStacksReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(6)
                .setInterval(3)
                .build();
        System.out.println(req);

        NodeControlRes res=stub.startPrintJStacks(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stopPrintJStacks1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(7)
                .build();
        System.out.println(req);

        Iterator<StopPrintJStacksRes> res=stub.stopPrintJStacks(req);
        while (res.hasNext()) {
            System.out.println(res.next());
        }

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void stopPrintJStacks2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(7)
                .build();
        System.out.println(req);

        Iterator<StopPrintJStacksRes> res=stub.stopPrintJStacks(req);
        while (res.hasNext()) {
            System.out.println(res.next());
        }

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void stopPrintJStacks3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(7)
                .build();
        System.out.println(req);

        Iterator<StopPrintJStacksRes> res=stub.stopPrintJStacks(req);
        while (res.hasNext()) {
            System.out.println(res.next());
        }

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PrintDump1(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node1();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(8)
                .build();
        System.out.println(req);

        NodeControlRes res = stub.printDump(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//windows

    @Test
    public void PrintDump2(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node2();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(8)
                .build();
        System.out.println(req);

        NodeControlRes res = stub.printDump(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//linux 8506

    @Test
    public void PrintDump3(){
        ManagedChannel channel=init();

        ProjectGrpc.ProjectBlockingStub stub = ProjectGrpc.newBlockingStub(channel);

        NodeInfo nodeInfo = node3();

        NodeControlReq req=NodeControlReq.newBuilder()
                .setNode(nodeInfo)
                .setExecId("123456")
                .setIndex(8)
                .build();
        System.out.println(req);

        NodeControlRes res = stub.printDump(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //本地node
    public NodeInfo node1(){
        return NodeInfo.newBuilder()
                .setIp("localhost")
                .setPort("8081")
                .setWebapps("webroot")
                .setServlet("decision")
                .setLibPath("C:\\Users\\yzp\\Downloads\\tomcat-win64\\webapps\\webroot\\WEB-INF\\lib")
                .setBinPath("C:\\Users\\yzp\\Downloads\\tomcat-win64\\bin")
                .build();
    }

    //linux node 8506
    public NodeInfo node2(){
        return NodeInfo.newBuilder()
                .setIp("192.168.101.21")
                .setPort("8506")
                .setWebapps("webroot")
                .setServlet("decision")
                .setLibPath("/home/apps/fr_11.0/webapps/webroot/WEB-INF/lib")
                .setBinPath("/home/apps/fr_11.0/bin")
                .build();
    }

    //国产化
    public NodeInfo node3(){
        return NodeInfo.newBuilder()
                .setIp("124.70.178.70")
                .setPort("18080")
                .setWebapps("webroot")
                .setServlet("decision")
                .setLibPath("/home/user/environment/TAS/bin")
                .setBinPath("/home/bes952/bin")
                .setProjType(3)
                .putAttrs("user","admin")
                .putAttrs("pwd","B#2008_2108#es")
                .build();
    }

    //把byte写入文件
    public void writeFile(byte[] bytes){

    }

}
