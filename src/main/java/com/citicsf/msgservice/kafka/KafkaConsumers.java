package com.citicsf.msgservice.kafka;


import com.citicsf.msgservice.bean.SendParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@Slf4j
public class KafkaConsumers implements Runnable{

    @Autowired
    private ThreadPoolTaskExecutor executorService;


    @Autowired
    private LinkedBlockingQueue<SendParam> queue;


    @Override
    public void run() {

        try {
            while(true){
                SendParam sendParam= queue.take();
                executorService.execute(new Task(sendParam));
                log.info("submit message "+ sendParam.toString()+ "to thread pool");
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
