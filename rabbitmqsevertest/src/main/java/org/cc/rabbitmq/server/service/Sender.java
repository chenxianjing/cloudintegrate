package org.cc.rabbitmq.server.service;

import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
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
		rabbitTemplate.convertAndSend("header_exchange",null,message);
	}
	
	public void sendHeaderExchange() {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
		messageProperties.setContentType("UTF-8");
		messageProperties.setHeader("hello", "");
		Message message = new Message("hello,world".getBytes(), messageProperties);
		rabbitTemplate.convertAndSend("header_exchange", null, message);
	}
	
	public void sendTopicExchange() {
		rabbitTemplate.convertAndSend("topic_exchange", "hello","123");
	}
}
