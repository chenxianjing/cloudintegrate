package org.cc.jpa.controller;

import org.cc.jpa.entity.UserLaud;
import org.cc.jpa.repository.UserLaudRepository;
import org.cc.jpa.repository.UserLaudRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLaudController {

	@Autowired
	private UserLaudRepository userRepository;
	@Autowired
	private UserLaudRepositoryImpl userLaudRepositoryImpl;

	@GetMapping("/get")
	public Iterable<UserLaud> addNewUser() {
		return userRepository.findAll();
	}

	@GetMapping("/save")
	public String save() {
		UserLaud userLaud = new UserLaud();
		userLaudRepositoryImpl.save(userLaud);
		return "success";
	}
}
