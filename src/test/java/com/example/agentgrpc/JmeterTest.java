package com.example.agentgrpc;


import com.example.agentgrpc.protocol.stress.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class JmeterTest {

    private String IP1="localhost";
    private String IP2="192.168.101.101";//windows虚拟机
    private String IP3="192.168.101.21";//linux服务器
    private int port=9090;

    public ManagedChannel init(){
        return ManagedChannelBuilder.forAddress(IP1, port)
                .usePlaintext()
                .build();
    }

    @Test
    public void startStress(){
        ManagedChannel channel=init();

        StressGrpc.StressBlockingStub stub = StressGrpc.newBlockingStub(channel);

        StartStressReq req=StartStressReq.newBuilder()
                .setExecId("1234")
                .setIndex(1)
                .setDownloadUrl("https://fine-build.oss-cn-shanghai.aliyuncs.com/SDET-FR/agent/test/")
                .addFileList("9_1picture.jmx")
                .addFileList("user1.csv")
                .build();
        System.out.println(req);

        StartStressRes res=stub.startStress(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startStress222(){
        ManagedChannel channel=init();

        StressGrpc.StressBlockingStub stub = StressGrpc.newBlockingStub(channel);

        StartStressReq req=StartStressReq.newBuilder()
                .setExecId("1234")
                .setIndex(1)
                .setDownloadUrl("http://192.168.4.56:8000/assets/scripts/")
                .addFileList("中国式复杂报表_1.jmx")
                .build();
        System.out.println(req);

        StartStressRes res=stub.startStress(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void stopStress(){
        ManagedChannel channel=init();

        StressGrpc.StressBlockingStub stub = StressGrpc.newBlockingStub(channel);

        StopStressReq req= StopStressReq.newBuilder()
                .setExecId("1234")
                .setIndex(2)
                .build();
        System.out.println(req);

        StopStressRes res=stub.stopStress(req);
        System.out.println(res);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonResult(){
        ManagedChannel channel=init();

        StressGrpc.StressBlockingStub stub = StressGrpc.newBlockingStub(channel);

        JsonResultReq req=JsonResultReq.newBuilder()
                .setExecId("6ef804cb-e77e-4c97-b924-7dfcdb0ba7b1")
                .setIndex(3)
                .setFilterName("")
                .build();
        System.out.println(req);

        Iterator<JsonResultRes> res=stub.jsonResult(req);
        while (res.hasNext()) {
            System.out.println(res.next());
        }

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //把byte写入文件
    public void writeFile(byte[] bytes){

    }

}
