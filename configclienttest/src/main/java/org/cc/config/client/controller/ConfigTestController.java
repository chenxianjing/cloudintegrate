package org.cc.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {
	@Value("${spring.redis.database}")
	private String redisServerPort;
	
	@PostMapping("/hi")
	public String hi() {
		return redisServerPort;
	}
}
