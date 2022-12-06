package com.citicsf.msgservice.config;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;


@Configuration
public class MessageQueueConfig {
    @Bean
    private static LinkedBlockingQueue<SendParam> queue(){
        return new LinkedBlockingQueue<SendParam>();
    }
}
