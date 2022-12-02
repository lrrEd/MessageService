package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,SendParam> kafkaTemplate;


    public void send(String topicName, SendParam sendParam){
        kafkaTemplate.send(topicName,sendParam);
    }

}
