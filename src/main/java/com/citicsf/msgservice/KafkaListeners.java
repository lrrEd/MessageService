package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class KafkaListeners {

    @Autowired
    private LinkedBlockingQueue<SendParam> queue;


    @RetryableTopic(dltStrategy = DltStrategy.FAIL_ON_ERROR)
    @KafkaListener(
            topics = "emailTopic",
            groupId = "groupId")
    public void listenEmail(SendParam sendParam) throws InterruptedException {
        //sendEmail.send(sendParam); //接收到消息后，调用邮件发送接口
        queue.put(sendParam);
    }
}
