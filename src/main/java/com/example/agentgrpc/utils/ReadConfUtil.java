package com.example.agentgrpc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
//获取yml文件配置
public class ReadConfUtil {
    public static Object readYml(String ymlName, String key){
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        //获取yml路径
        String bar = File.separator;
        String ymlPath = System.getProperty("user.dir")+bar+"config"+bar+ymlName;
        factoryBean.setResources(new FileSystemResource(ymlPath)); //绝对路径
//        factoryBean.setResources(new ClassPathResource(ymlName));   //工程内路径
        Properties properties = factoryBean.getObject();
//        properties.keySet().forEach(key -> System.out.println(key + "=====" + properties.get(key)));
        return properties.get(key);
    }

    public static String readProperties(String propertiesName, String key)  {
        ClassPathResource classPathResource = new ClassPathResource(propertiesName);
        //判断文件是否存在
        boolean exists = classPathResource.exists();
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = classPathResource.getInputStream();
            properties.load(inputStream);
            String res = properties.getProperty(key);
            //多个结果
//            String[] split = res.split(",");
//            Arrays.stream(split).forEach(System.out::println);

            return res;
        } catch (IOException e) {
            log.error("ERROR2: Read properties failed",e);
        }
        finally {
            try {
                inputStream.close();
                properties.clear();
            } catch (IOException e) {
                log.error("ERROR2: Close stream failed",e);
            }
        }
        return  null;
    }
}
