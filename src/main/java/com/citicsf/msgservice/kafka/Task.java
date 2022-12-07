package com.citicsf.msgservice.kafka;

import com.citicsf.msgservice.sendmsg.SendEmail;
import com.citicsf.msgservice.bean.SendParam;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Task implements Runnable{

    private SendParam sendParam;

    public Task(SendParam sendParam){
        this.sendParam = sendParam;
    }


    @SneakyThrows
    @Override
    public void run() {
        SendEmail.send(sendParam);
        log.info("finish sending email: "+ sendParam.toString());

    }
}
