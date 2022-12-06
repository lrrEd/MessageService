package com.citicsf.msgservice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;


@Configuration
public class ConsumerHandler  {

    @Bean
    public ThreadPoolTaskExecutor executorService() throws InterruptedException {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(3);
        executorService.setMaxPoolSize(3);
        executorService.setQueueCapacity(100);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.initialize();
        return executorService;
    }


}
