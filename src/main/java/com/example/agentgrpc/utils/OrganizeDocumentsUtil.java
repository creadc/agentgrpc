package com.example.agentgrpc.utils;

import com.example.agentgrpc.bll.AsyncTask;
import com.example.agentgrpc.bll.CommonMethod;
import com.example.agentgrpc.bll.StressBLL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class OrganizeDocumentsUtil {
    @Autowired
    private CommonMethod commonMethod;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private StressBLL stressBLL;

    @Scheduled(cron = "0 1 0 * * ?")
    public void organizeJtlBakFiles(){
        log.info("--Start organize jtl_bak files--");
        String agentPath = stressBLL.jsonResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String jtlBakDirPath = String.valueOf(Paths.get(agentPath, "jtl_bak"));
        String archiveDirPath = String.valueOf(Paths.get(jtlBakDirPath,sdf.format(System.currentTimeMillis())));
        commonMethod.newPath(archiveDirPath);

        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        Matcher matcher;
        File tempFile;
        //遍历，把文件夹都放到archiveDirPath中
        File[] files = new File(jtlBakDirPath).listFiles();
        for (File file : files) {
            //如果是归档文件，就跳过
            matcher = pattern.matcher(file.getName());
            if (!matcher.matches()) {
                tempFile = new File(String.valueOf(Paths.get(archiveDirPath,file.getName())));
                tempFile.mkdirs();
                commonMethod.moveFile(file,tempFile);
                asyncTask.delayDelete(file.getPath(),3);
            }
        }
        log.info("--Organize jtl_bak files over--");
    }
}
