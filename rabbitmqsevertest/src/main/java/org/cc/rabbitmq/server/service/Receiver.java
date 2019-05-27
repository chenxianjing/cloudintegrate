package org.cc.rabbitmq.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	@RabbitHandler
	@RabbitListener
	public void helloWorld(String message) {
		System.out.println("Receiver:" + message);
	}
}
