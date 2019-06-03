package org.cc.rabbitmq.server.service;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate; 
	
	/**
	 * 发送消息
	 */
	public void send() {
		String message = "message" + new Date();
		rabbitTemplate.convertAndSend("helloWorld_exchange_test1","hello_world_route_key",message);
	}
}
