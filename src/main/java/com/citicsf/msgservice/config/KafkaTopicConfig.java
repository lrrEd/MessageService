package com.citicsf.msgservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {



    @Bean
    public NewTopic emailTopic(){
        return TopicBuilder.name("emailTopic").build();
    }

    @Bean
    public NewTopic topic1(){
        return TopicBuilder.name("topic1").build();
    }

    @Bean
    public NewTopic topic2(){
        return TopicBuilder.name("topic2").build();
    }

}