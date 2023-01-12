package com.example.agentgrpc.bll;

import com.example.agentgrpc.utils.ReadConfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Localization {
    private static final String DEFAULT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.defaultPathOnLinux");
    private static final String DEFAULT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.defaultPathOnWindows");
    private static final String AGENT_PATH_ON_LINUX = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnLinux");
    private static final String AGENT_PATH_ON_WINDOWS = (String) ReadConfUtil.readYml("application.yml","my.agentPathOnWindows");

}
