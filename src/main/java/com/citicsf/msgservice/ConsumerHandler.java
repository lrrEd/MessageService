package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.SendParam;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;


@Component
public class ConsumerHandler implements InitializingBean  {

    @Autowired
    private LinkedBlockingQueue<SendParam> queue;

    private ExecutorService executorService;

    @Async
    public void execute(int threadNum) throws InterruptedException {
        executorService = new ThreadPoolExecutor(threadNum, threadNum, 0,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100),
                new ThreadPoolExecutor.CallerRunsPolicy());
        while(true){
            if (queue==null) continue;
            executorService.submit(new Task(queue.take()));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        execute(3);
    }

//    public void init() throws InterruptedException {
//        execute(3);
//    }


}
