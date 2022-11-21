package com.example.agentgrpc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskExecutorConfig {

    private int corePoolSize = 8;//核心线程
    private int maxPoolSize = 8;//最大线程
    private int queueCapacity = 1000;//队列最大长度
    private int keepAliveSeconds = 60;//线程池维护线程所允许的空闲时间
    private String threadNamePrefix = "agent-thread-";

    @Bean
    public Executor getAsyncTaskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

        poolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        poolTaskExecutor.setCorePoolSize(corePoolSize);
        poolTaskExecutor.setMaxPoolSize(maxPoolSize);
        poolTaskExecutor.setQueueCapacity(queueCapacity);
//        poolTaskExecutor.setThreadFactory(Executors.defaultThreadFactory());
        poolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//线程池对拒绝任务（无线程可用的）的处理策略
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }
}
