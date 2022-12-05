package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;

public class Task implements Runnable{

    @Autowired
    private SendEmail sendEmail;

    private SendParam sendParam;

    public Task(SendParam sendParam){
        this.sendParam = sendParam;
    }


    @Override
    public void run() {
        sendEmail.send(sendParam);
    }
}
