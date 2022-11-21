package com.example.agentgrpc;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class AgentgrpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgentgrpcApplication.class, args);
    }
}
