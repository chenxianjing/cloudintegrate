package org.jpatest;

import java.util.Optional;

import org.cc.jpa.entity.UserLaud;
import org.cc.jpa.repository.UserLaudRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCrud {
	@Autowired
	private UserLaudRepository userLaudRepository;

	@Test
	public void test() {
		Optional<UserLaud> list = userLaudRepository.findById(1L);
	}
}
