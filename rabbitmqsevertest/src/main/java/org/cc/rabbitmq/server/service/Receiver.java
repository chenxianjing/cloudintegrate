package org.cc.rabbitmq.server.service;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Receiver {
	
	/**
	 * 消费
	 * @param message
	 * @throws UnsupportedEncodingException 
	 */
	/*
	 * @RabbitListener(queues = "helloWorld_queue_test1") public void
	 * helloWorld(Message message) throws UnsupportedEncodingException {
	 * System.out.println("Receiver1:" + new String(message.getBody(),"UTF-8")); }
	 */
	
	@RabbitListener(queues = "helloWorld_queue_test1")
	public void topic(String message) {
		System.out.println("receiver:" + message);
	}
}
