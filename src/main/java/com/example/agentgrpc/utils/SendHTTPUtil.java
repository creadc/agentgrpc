package com.example.agentgrpc.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.agentgrpc.conf.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class SendHTTPUtil {

    static RestTemplateConfig restTemplateConfig = new RestTemplateConfig();
    //get无参请求,返回json,用于获取工程状态
    public static JSONObject getReturnJson(String httpUrl, Map<String, String> headerParams) {
        RestTemplate restTemplate = restTemplateConfig.restTemplate(restTemplateConfig.simpleClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (headerParams != null) {
            Set<String> headerKeys = headerParams.keySet();
            headerKeys.stream().forEach(a -> {
                headers.set(a, headerParams.get(a));
            });
        }
        HttpEntity httpEntity = new HttpEntity(headers);
        JSONObject data = new JSONObject();
        log.info("HTTP URL is:"+httpUrl);
        try {
            ResponseEntity<String> result = restTemplate.exchange(httpUrl, HttpMethod.GET, httpEntity, String.class);
            data = JSONObject.parseObject(result.getBody());
            return data;
        } catch (ResourceAccessException e) {
            String s = e.toString();
            if (s.contains("ConnectException")){
                data.put("errorMessage","ConnectException");
            }
            if (s.contains("SocketTimeoutException")){
                data.put("errorMessage","SocketTimeoutException");
            }
            return data;
        } catch (Exception e){
            log.error("ERROR2: Send HTTP failed",e);
            data.put("errorMessage",e.getMessage());
            return data;
        }
    }

    //get无参请求,返回string,用于获取agent版本
    public static String getReturnString(String httpUrl, Map<String, String> headerParams) {
        RestTemplate restTemplate = restTemplateConfig.restTemplate(restTemplateConfig.simpleClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (headerParams != null) {
            Set<String> headerKeys = headerParams.keySet();
            headerKeys.stream().forEach(a -> {
                headers.set(a, headerParams.get(a));
            });
        }
        HttpEntity httpEntity = new HttpEntity(headers);
        log.info("HTTP URL is:"+httpUrl);
        try {
            ResponseEntity<String> result = restTemplate.exchange(httpUrl, HttpMethod.GET, httpEntity, String.class);
            return result.getBody();
        } catch (Exception e) {
            return "error";
        }
    }

    //下载文件,成功返回1,失败返回0
    public static int downloadFile(String httpUrl,String filePath){
    log.info("Start download :"+httpUrl);
    //定义请求头的接收类型
    RequestCallback requestCallback = request -> request.getHeaders()
            .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
    //对响应进行流式处理而不是将其全部加载到内存中
    RestTemplate restTemplate = new RestTemplate();
    try {
        restTemplate.execute(httpUrl, HttpMethod.GET, requestCallback, clientHttpResponse -> {
            Files.copy(clientHttpResponse.getBody(), Paths.get(filePath));
            return 1;
        });
        log.info("Download over");
    }catch (Exception e){
        log.error("ERROR2: Download failed",e);
        return 0;
    }
    return 1;
    }
}
