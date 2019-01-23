package com.sync.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sync.log.mail.SendMailTLS;

@RestController
public class MyController {
	
	private static Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@GetMapping("/hello")
	public String hello() {
		//SendMailTLS send = new SendMailTLS();
		//send.sendMail();
		logger.info("My Logger Before Messsage....");
		logger.error("There is some error...");
		return "Hello World";
	}

}
