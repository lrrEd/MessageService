package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.BatchSendParam;
import com.citicsf.msgservice.bean.MsgParam;
import com.citicsf.msgservice.bean.SendParam;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SendServiceAPI implements SendService{

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private NewTopic emailTopic;

    @Autowired
    private NewTopic topic1;

    @Autowired
    private NewTopic topic2;

    @Override
    public void send(SendParam sendParam) {

        //判断templateId, 发送到对应的topic上

        kafkaProducer.send(emailTopic.name(), sendParam);

    }

    @Override
    public void batchSend(BatchSendParam bacthSendParam) {

        //判断templateId, 发送到对应的topic上

        for(MsgParam msgParam:bacthSendParam.getMsgParam()){
            kafkaProducer.send(emailTopic.name(),
                    new SendParam(bacthSendParam.getTemplateId(), msgParam));
        }
    }
}
