package org.cc.rabbitmq.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

public class Receiver2 {
	
	
	@RabbitHandler
	public void helloWorld2(String message) {
		System.out.println("Receiver2:" + message);
	}
}
