package com.example.agentgrpc;

import com.example.agentgrpc.protocol.debug.ContextReq;
import com.example.agentgrpc.protocol.debug.ContextRes;
import com.example.agentgrpc.protocol.debug.DebugGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class DebugTest {
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
    public void getServletContext(){
        ManagedChannel channel=init();

        DebugGrpc.DebugBlockingStub stub = DebugGrpc.newBlockingStub(channel);

        ContextReq req = ContextReq.newBuilder().build();
        stub.getServletContext(req);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}