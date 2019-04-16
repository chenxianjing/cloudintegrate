package org.cc.client.controller;

import org.cc.client.server.ServerTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class ClientController {
	@Autowired
	private ServerTestService serverTestService;
	@PostMapping("/client/testClient")
	public String testClient() {
		log.info(serverTestService.testServer());
		return "调用成功";
	}
}
