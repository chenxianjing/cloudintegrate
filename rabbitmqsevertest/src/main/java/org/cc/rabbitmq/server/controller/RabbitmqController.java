package org.cc.rabbitmq.server.controller;

import org.cc.rabbitmq.server.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {
	@Autowired
	private Sender sender;
	
	@GetMapping("/send")
	public void send() {
		sender.send();
	}
}
