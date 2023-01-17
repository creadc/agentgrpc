package com.example.agentgrpc.utils;

import com.example.agentgrpc.protocol.collector.CollectorGrpc;
import com.example.agentgrpc.protocol.collector.TaskStatusReq;
import com.example.agentgrpc.protocol.collector.TaskStatusRes;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SendGrpcUtil {
    private static final String IP = (String) ReadConfUtil.readYml("application.yml","my.client.ip");
    private static final int PORT = (int) ReadConfUtil.readYml("application.yml","my.client.port");

    public static void TaskStatus(String execId,int index,int job_type,int code,String message){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(IP, PORT)
                .usePlaintext()
                .build();

        log.info("Send grpc: {execid:"+execId+",index:"+index+",job_type:"+job_type+",code:"+code+",message:"+message+"}");

        CollectorGrpc.CollectorBlockingStub stub = CollectorGrpc.newBlockingStub(channel);
        TaskStatusReq req = TaskStatusReq.newBuilder()
                .setExecId(execId)
                .setIndex(index)
                .setJobType(job_type)
                .setCode(code)
                .setMessage(message)
                .build();

        TaskStatusRes res = stub.taskStatus(req);
        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("ERROR2: Close channel failed",e);
        }

    }
}
