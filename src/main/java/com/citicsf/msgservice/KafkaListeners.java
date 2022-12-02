package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    private SendEmail sendEmail;

    @RetryableTopic(dltStrategy = DltStrategy.FAIL_ON_ERROR)
    @KafkaListener(
            topics = "topic1",
            groupId = "groupId")
    public void listen(SendParam sendParam){
        sendEmail.send(sendParam);
    }

    @RetryableTopic(dltStrategy = DltStrategy.FAIL_ON_ERROR)
    @KafkaListener(
            topics = "emailTopic",
            groupId = "groupId")
    public void listenEmail(SendParam sendParam){
        sendEmail.send(sendParam); //接收到消息后，调用邮件发送接口
    }
}
