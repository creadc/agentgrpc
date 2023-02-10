package com.example.agentgrpc;

import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.utils.SendGrpcUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.saxon.trans.SymbolicName;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
@Order(value = 1)
public class ApplicationStartup implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("--Automatic performance--");
        String userDir = System.getProperty("user.dir");
        Path jsonPath = Paths.get(userDir,"update.json");
        //判断是否有update.json文件
        File file = new File(String.valueOf(jsonPath));
        //如果不存在，就说明不是更新启动的
        if (!file.exists())
            return;
        //文件存在，读取数据
        List<String> strings = Files.readAllLines(jsonPath);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(strings.get(0));
        //上传
        log.info("--Update success--");
        SendGrpcUtil.TaskStatus((String) jsonObject.get("execid"),(int)jsonObject.get("index"),8,0,"Success");
        //删除文件
        Files.delete(jsonPath);
    }
}
