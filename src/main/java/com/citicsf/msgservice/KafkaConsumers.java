package com.citicsf.msgservice;


import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class KafkaConsumers implements Runnable{

    @Autowired
    private ThreadPoolTaskExecutor executorService;


    @Autowired
    private LinkedBlockingQueue<SendParam> queue;


    @Override
    public void run() {

        try {
            while(true){
                executorService.execute(new Task(queue.take()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void executeTask(){
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }
}
