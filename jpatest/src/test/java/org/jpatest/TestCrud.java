package org.jpatest;

import java.util.Optional;

import org.cc.jpa.entity.UserLaud;
import org.cc.jpa.repository.UserLaudRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestCrud {
	@Autowired
	private UserLaudRepository userLaudRepository;

	@Test
	public void test() {
		Optional<UserLaud> userLaud = userLaudRepository.findById(1L);
		log.info(userLaud.get().getUid().toString());
	}
}
