package com.example.agentgrpc.service;

import com.example.agentgrpc.protocol.agent.AgentGrpc;
import com.example.agentgrpc.protocol.agent.UpdateAgentReq;
import com.example.agentgrpc.protocol.agent.UpdateAgentRes;
import com.example.agentgrpc.utils.AutoUpdateUtil;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GrpcService
public class AgentImpl extends AgentGrpc.AgentImplBase {
    @Autowired
    AutoUpdateUtil autoUpdateUtil;

    @Override
    public void updateAgent(UpdateAgentReq request, StreamObserver<UpdateAgentRes> responseObserver) {
        UpdateAgentRes res = UpdateAgentRes.newBuilder().build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
        autoUpdateUtil.checkUpdate();
    }
}
