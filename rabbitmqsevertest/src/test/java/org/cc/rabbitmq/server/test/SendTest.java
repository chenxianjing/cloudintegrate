package org.cc.rabbitmq.server.test;

import org.cc.rabbitmq.server.RabbitMqServerApplication;
import org.cc.rabbitmq.server.service.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqServerApplication.class)
public class SendTest {
	@Autowired
	private Sender sender;
	
	@Test
	public void testSend() {
		sender.send();
	}
	
	@Test
	public void testSendHeader() {
		sender.sendHeaderExchange();
	}
	
	@Test
	public void testSendTopic() {
		sender.sendTopicExchange();
	}
}
