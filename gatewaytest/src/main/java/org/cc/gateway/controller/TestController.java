package org.cc.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class TestController {
	
	@GetMapping("/fallback")
	public Mono<String> fallback(){
		return Mono.just("fallback");
	}
}
