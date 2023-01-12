package com.example.agentgrpc.service;

import com.example.agentgrpc.bll.AsyncTask;
import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.bll.StressBLL;
import com.example.agentgrpc.jmeter.Analyze;
import com.example.agentgrpc.protocol.stress.*;
import com.example.agentgrpc.utils.Constants;
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
        log.info("--Json result start--");
        String agentPath = stressBLL.jsonResult();
        JsonResultRes res;

        File jtlPath = new File(agentPath+"/jtl");
        File[] files1 = jtlPath.listFiles();
        int i = 0;
        //jtl文件夹为空
        if (files1 == null||files1.length == 0){
            log.error("ERROR2: No jtl files");
            res = JsonResultRes.newBuilder()
                    .setCode(1)
                    .setMessage("No files")
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
            return;
        }
        //对每个文件夹进行处理
        for (File file1 : files1) {
            //筛选出同一个execid的目录
            if (file1.isDirectory() && request.getExecId().equals(file1.getName().split(Constants.DIVISION)[0])) {
                //分析jtl文件，生成json
                File[] files2 = file1.listFiles();
                for (File file2 : files2) {
                    //已经过滤，退出
                    if (file2.getName().contains(Constants.DIVISION+"filter.jtl")){
                        break;
                    }
                    //不为jtl文件，继续
                    if(!file2.getName().endsWith(".jtl"))
                        continue;
                    ++i;
                    //过滤
                    String filterJtl = analyze.filterJtl(file1.getPath(),file2.getName(),request.getFilterName());
                    //转为json
                    String jsonPath = analyze.jtlToJson(file1.getPath(), filterJtl);
                    commonMethod.delay(1);
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
                    else{
                        log.error("ERROR2: Upload: empty file");
                        //返回分析后的json文件
//                        System.out.println(commonMethod.readJsonFile(jsonPath));
                        res = JsonResultRes.newBuilder()
                                .setCode(1)
                                .setMessage("No json file,there is a problem with the jtl file")
                                .build();
                        responseObserver.onNext(res);
                    }
                }
                //把对应的文件夹归档
                log.info("Start backup "+file1.getName()+"......");
                File bakDir = new File(agentPath+"/jtl_bak/"+file1.getName());
                bakDir.mkdirs();
                commonMethod.moveFile(file1,bakDir);
                asyncTask.delayDelete(file1.getPath(),3);
                log.info("Backup over");
            }
        }
        //有jtl文件，但是没有对应execid的jtl
        if (i==0){
            log.error("ERROR2: No Corresponding jtl files");
            res = JsonResultRes.newBuilder()
                    .setCode(1)
                    .setMessage("No jtl files with execid \""+request.getExecId()+"\"")
                    .build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
            return;
        }
        log.info("--Json result over--");
        responseObserver.onCompleted();
    }
}
