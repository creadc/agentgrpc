package com.example.agentgrpc.service;

import com.example.agentgrpc.bll.AsyncTask;
import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.bll.StressBLL;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.protocol.stress.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;

@Slf4j
@GrpcService
public class StressImpl extends StressGrpc.StressImplBase {

    @Autowired
    private StressBLL stressBLL;

    @Autowired
    private CommonMethod commonMethod;

    @Autowired
    private Analyze analyze;

    @Autowired
    private AsyncTask asyncTask;

    @Override
    public void startStress(StartStressReq request, StreamObserver<StartStressRes> responseObserver) {
        StartStressRes res = stressBLL.startStress(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void stopStress(StopStressReq request, StreamObserver<StopStressRes> responseObserver) {
        StopStressRes res = stressBLL.stopStress(request);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void jsonResult(JsonResultReq request, StreamObserver<JsonResultRes> responseObserver) {
        String agentPath = stressBLL.jsonResult();
        JsonResultRes res = null;

        //找到jtl文件夹中相同execid的、分析完的jtl文件
        ArrayList<String> resultPath = new ArrayList<>();
        File jtlPath = new File(agentPath+"/jtl");
        File[] files1 = jtlPath.listFiles();
        //jtl文件夹为空
        if (files1 == null){
            log.error("ERROR2: No jtl files");
            res = JsonResultRes.newBuilder()
                    .setCode(1)
                    .setMessage("No files")
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
            return;
        }
        for (File file1 : files1) {
            int i = 0;
            //筛选出同一个execid的目录
            if (file1.isDirectory() && request.getExecId().equals(file1.getName().split("-")[0])) {
                //分析jtl文件，生成json
                File[] files2 = file1.listFiles();
                for (File file2 : files2) {
                    if (file2.getName().contains("_filter.jtl")){
                        break;
                    }
                    ++i;
                    //过滤
                    String filterJtl = analyze.filterJtl(file1.getPath(),file2.getName());
                    //转为json
                    String jsonPath = analyze.jtlToJson(file1.getPath(), filterJtl);
//                    String jsonPath = analyze.jtlToJson("C:\\Users\\yzp\\Desktop", "100_filter.jtl");
                    //回传
                    File json = new File(jsonPath);
                    if(json.exists()){
                        log.info("Upload:"+json.getPath());
                        //返回分析后的json文件
//                        System.out.println(commonMethod.readJsonFile(jsonPath));
                        res = JsonResultRes.newBuilder()
                                .setCode(0)
                                .setMessage("Upload success")
                                .setFileName(json.getName())
                                .setChunk(commonMethod.readFile(jsonPath))
                                .build();
                        responseObserver.onNext(res);
                    }
                    else {
                        log.error("ERROR2: Upload: empty file");
                        //返回分析后的json文件
//                        System.out.println(commonMethod.readJsonFile(jsonPath));
                        res = JsonResultRes.newBuilder()
                                .setCode(1)
                                .setMessage("")
                                .setFileName(json.getName())
                                .setChunk("No files")
                                .build();
                        responseObserver.onNext(res);
                    }
                }
                //把对应的文件夹归档
                log.info("Start backup......");
                File bakDir = new File(agentPath+"/jtl_bak/"+file1.getName());
                bakDir.mkdirs();
                commonMethod.moveFile(file1,bakDir);
                asyncTask.delayDelete(file1.getPath(),3);
                log.info("Backup over");
            }
            //有jtl文件，但是没有对应execid的jtl
            if (i==0){
                log.error("ERROR2: No Corresponding jtl files");
                res = JsonResultRes.newBuilder()
                        .setCode(1)
                        .setMessage("No files")
                        .build();
                responseObserver.onNext(res);
                responseObserver.onCompleted();
                return;
            }
        }
        responseObserver.onCompleted();
    }
}