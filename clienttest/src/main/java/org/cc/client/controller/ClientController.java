package org.cc.client.controller;

import org.cc.client.server.ServerTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClientController {
	@Autowired
	private ServerTestService serverTestService;
	@PostMapping("/client/testClient")
	public String testClient() {
		System.out.println(serverTestService.testServer());
		return "调用成功";
	}
}
