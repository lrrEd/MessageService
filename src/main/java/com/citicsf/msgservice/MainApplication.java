package com.citicsf.msgservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAsync
public class MainApplication {

//	@Autowired
//	private static ConsumerHandler consumerHandler;

	public static void main(String[] args) throws InterruptedException {



		SpringApplication.run(MainApplication.class, args);
		//consumerHandler.execute(3);
	}




}
