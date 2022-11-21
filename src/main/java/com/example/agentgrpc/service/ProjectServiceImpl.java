package com.example.agentgrpc.service;

import com.example.agentgrpc.bll.ProjectBLL;
import com.example.agentgrpc.protocol.project.*;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.Future;

@Slf4j
@GrpcService
public class ProjectServiceImpl extends ProjectGrpc.ProjectImplBase {
    @Autowired
    private ProjectBLL projectBLL;

    @Override
    public void startNode(NodeControlReq request, StreamObserver<NodeControlRes> responseObserver) {
//        System.out.println(request);
        NodeControlRes res = projectBLL.startNode(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void stopNode(NodeControlReq request, StreamObserver<NodeControlRes> responseObserver) {
        NodeControlRes res = projectBLL.stopNode(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void reStartNode(NodeControlReq request, StreamObserver<NodeControlRes> responseObserver) {
        NodeControlRes res = projectBLL.reStartNode(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void replaceJar(ReplaceJarReq request, StreamObserver<NodeControlRes> responseObserver) {
        NodeControlRes res = projectBLL.replaceJar(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void nodeState(NodeControlReq request, StreamObserver<NodeStateRes> responseObserver) {
        NodeStateRes res = projectBLL.nodeState(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void startPrintJStacks(PrintStacksReq request, StreamObserver<NodeControlRes> responseObserver) {
        NodeControlRes res = projectBLL.startPrintJStacks(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void stopPrintJStacks(NodeControlReq request, StreamObserver<StopPrintJStacksRes> responseObserver) {
        String[] strs = projectBLL.stopPrintJStacks(request);
        String str = strs[0];
        //有错误
        if("tag does not exist".equals(str)){
            StopPrintJStacksRes res = StopPrintJStacksRes.newBuilder()
                    .setFileName(str)
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
            return;
        }
        //没有错误回传压缩包
        //不分片
        FileInputStream in = null;
        try {
            in = new FileInputStream(str);
            byte[] data = new byte[in.available()];
            in.read(data);

            StopPrintJStacksRes res = StopPrintJStacksRes.newBuilder()
                    .setFileName(strs[1])
                    .setChunk(ByteString.copyFrom(data))
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("ERROR2: Transfer zip failed",e);
        }
        finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                log.error("ERROR2: Close stream failed",e);
            }
        }

    }

    @Override
    public void printDump(NodeControlReq request, StreamObserver<NodeControlRes> responseObserver) {
        NodeControlRes res = projectBLL.printDump(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    public static byte[] read(String path, int offSet, int blockSize) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(blockSize);
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get(path), StandardOpenOption.READ)) {
                Future<Integer> read = channel.read(buffer, offSet);
                while (!read.isDone()) {
                        // ----- 睡1毫秒， 不抢占资源
                        Thread.sleep(1L);
                    }
            } catch (Exception e) {
                log.error("ERROR2: read failed");
                throw e;
            }
        return buffer.array();
    }
}
