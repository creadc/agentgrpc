package com.example.agentgrpc.service;

import com.example.agentgrpc.pojo.AgentUpdateEntity;
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
public class AgentServiceImpl extends AgentGrpc.AgentImplBase {
    @Autowired
    AutoUpdateUtil autoUpdateUtil;

    @Override
    public void updateAgent(UpdateAgentReq request, StreamObserver<UpdateAgentRes> responseObserver) {
        AgentUpdateEntity agentUpdateEntity = autoUpdateUtil.checkUpdate();
        int flag = agentUpdateEntity.getCode();
        //前置处理失败
        if (flag == 1){
            UpdateAgentRes res = UpdateAgentRes.newBuilder()
                    .setCode(1)
                    .setMessage(agentUpdateEntity.getMessage())
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
        }
        //无需更新
        else if (flag == 0){
            UpdateAgentRes res = UpdateAgentRes.newBuilder()
                    .setCode(0)
                    .setMessage("success")
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
        }
        //需要更新，且前置条件已确认
        else {
            UpdateAgentRes res = UpdateAgentRes.newBuilder()
                    .setCode(2)
                    .setMessage("Updating...")
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();

            agentUpdateEntity.setExecid(request.getExecId());
            agentUpdateEntity.setIndex(request.getIndex());
            autoUpdateUtil.startUpdate(agentUpdateEntity);
        }
    }
}
