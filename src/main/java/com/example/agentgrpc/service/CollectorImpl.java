package com.example.agentgrpc.service;

import com.example.agentgrpc.protocol.collector.CollectorGrpc;
import com.example.agentgrpc.protocol.collector.TaskStatusReq;
import com.example.agentgrpc.protocol.collector.TaskStatusRes;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class CollectorImpl extends CollectorGrpc.CollectorImplBase {
    @Override
    public void taskStatus(TaskStatusReq request, StreamObserver<TaskStatusRes> responseObserver) {
        log.info("上传结果============"+"\n"+request);
        log.info("结束===============");
        TaskStatusRes res=TaskStatusRes.newBuilder().build();
        responseObserver.onNext( res );
        responseObserver.onCompleted();
    }
}
