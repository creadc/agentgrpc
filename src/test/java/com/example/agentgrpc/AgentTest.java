package com.example.agentgrpc;

import com.example.agentgrpc.protocol.agent.AgentGrpc;
import com.example.agentgrpc.protocol.agent.UpdateAgentReq;
import com.example.agentgrpc.protocol.debug.ContextReq;
import com.example.agentgrpc.protocol.debug.DebugGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AgentTest {
    private String IP1="localhost";
    private String IP2="192.168.101.101";//windows虚拟机
    private String IP3="192.168.101.88";//21
    private String IP4="192.168.101.229";//229
    private int port1=9090;
    private int port2=9093;

    public ManagedChannel init(){
        return ManagedChannelBuilder.forAddress(IP3, port1)
                .usePlaintext()
                .build();
    }

    @Test
    public void UpdateAgent(){
        ManagedChannel channel=init();

        AgentGrpc.AgentBlockingStub stub = AgentGrpc.newBlockingStub(channel);

        UpdateAgentReq req = UpdateAgentReq.newBuilder()
                .setExecId("123")
                .setIndex(321)
                .build();
        stub.updateAgent(req);

        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
