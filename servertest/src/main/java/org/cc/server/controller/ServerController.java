package org.cc.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
	
	@PostMapping("/server/postServer")
	public String testServer() {
		return "success";
	}
}
