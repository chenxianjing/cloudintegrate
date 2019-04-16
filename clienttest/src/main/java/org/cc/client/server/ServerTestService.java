package org.cc.client.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("TestServer")
public interface ServerTestService {
	
	@PostMapping("/server/postServer")
	public String testServer();
}
