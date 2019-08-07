package org.cc.rabbitmq.server.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Bean
	public Queue helloWorldQueue() {
		return new Queue("helloWorld_queue_test1", true);
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("helloWorld_exchange_test1", true, false);
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout_exchange", true, false);
	}

	@Bean
	public TopicExchange topicExchage() {
		return new TopicExchange("topic_exchange", true, false);
	}

	@Bean
	public HeadersExchange headersExchange() {
		return new HeadersExchange("header_exchange", true, false);
	}

	/*
	 * @Bean public Binding helloWorldBinding() { return
	 * BindingBuilder.bind(helloWorldQueue()).to(fanoutExchange()); }
	 */

	/*
	 * @Bean public Binding directBinding() { return
	 * BindingBuilder.bind(helloWorldQueue()).to(headersExchange()).where("hello").
	 * exists(); }
	 */
	
	@Bean
	public Binding topicBinding() {
		return BindingBuilder.bind(helloWorldQueue()).to(topicExchage()).with("hello");
	}
}
