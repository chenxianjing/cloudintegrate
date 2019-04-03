package org.cc.jpa.controller;

import org.cc.jpa.entity.UserLaud;
import org.cc.jpa.repository.UserLaudRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLaudController {

	@Autowired
	private UserLaudRepository userRepository;

	public Iterable<UserLaud> addNewUser() {
		return userRepository.findAll();
	}
}
