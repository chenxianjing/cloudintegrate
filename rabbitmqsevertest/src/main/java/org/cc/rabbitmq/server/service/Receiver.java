package org.cc.rabbitmq.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	/**
	 * 消费
	 * @param message
	 */
	@RabbitHandler
	@RabbitListener(queues = "helloWorld_queue_test1")
	public void helloWorld(String message) {
		System.out.println("Receiver123:" + message);
	}
}
