package org.cc.test;

import org.cc.RedisApplication;
import org.cc.config.TestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisTest {
	@Autowired
	private TestTemplate testTemplate;

	@Autowired

	@Test
	public void test() {
		testTemplate.test1();
	}
}
