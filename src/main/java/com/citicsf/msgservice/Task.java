package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;


public class Task implements Runnable{

    private SendEmail sendEmail = new SendEmail();

    private SendParam sendParam;

    public Task(SendParam sendParam){
        this.sendParam = sendParam;
    }


    @Override
    public void run() {
        sendEmail.send(sendParam);
    }
}
