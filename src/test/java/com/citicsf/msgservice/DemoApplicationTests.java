package com.citicsf.msgservice;

import com.citicsf.msgservice.bean.MsgParam;
import com.citicsf.msgservice.bean.SendParam;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
class DemoApplicationTests {


	@Autowired
	private SendServiceAPI sendServiceAPI;


	@Test
	void sendEmail() throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new MyThread(), "Thread-"+i);
			t.start();
			t.join();
		}

	}

}

class MyThread implements Runnable{

	private SendServiceAPI sendServiceAPI = SpringUtils.getBean("sendServiceAPI");

	@Override
	public void run(){

		SendParam sendParam = new SendParam();
		sendParam.setTemplateId("123456");
		MsgParam msgParam = new MsgParam();
		msgParam.setReceiver("lrr_ed@163.com");
		Map<String, String> map = new HashMap<>();
		map.put("from", "lrr_nk@163.com");
		map.put("text", Thread.currentThread().getName());
		map.put("subject", Thread.currentThread().getName());
		msgParam.setVariables(map);
		sendParam.setMsgParam(msgParam);
		sendServiceAPI.send(sendParam);

		System.out.println(Thread.currentThread().getName()+" send email");
	}

}
