package org.cc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTemplate {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@GetMapping("/123")
	public void test1() {
		redisTemplate.opsForList().leftPush("key", "key3");
		redisTemplate.opsForList().leftPush("key", "key4");
	}

}
