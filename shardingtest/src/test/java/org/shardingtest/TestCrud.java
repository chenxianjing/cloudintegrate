package org.shardingtest;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shardingtest.entity.Order;
import org.shardingtest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestCrud {
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testQuery() {
		Optional<Order> order = orderRepository.findById(1L);
		log.info(order.get().getProductName());
	}
	
	@Test
	public void testInsert() {
		Order order = new Order();
		order.setProductName("123");
		orderRepository.save(order);
	}
}
