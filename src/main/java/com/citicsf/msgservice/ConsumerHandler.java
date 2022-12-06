package com.citicsf.msgservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;


@Configuration
public class ConsumerHandler  {

    @Value("${async.executor.thread.core-pool-size}")
    private int corePoolSize;

    @Value("${async.executor.thread.max-pool-size}")
    private int maxPoolSize;

    @Value("${async.executor.thread.queue-capacity}")
    private int queueCapacity;



    @Bean
    public ThreadPoolTaskExecutor executorService(){
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(corePoolSize);
        executorService.setMaxPoolSize(maxPoolSize);
        executorService.setQueueCapacity(queueCapacity);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.setWaitForTasksToCompleteOnShutdown(true);
        executorService.initialize();
        return executorService;
    }


}
