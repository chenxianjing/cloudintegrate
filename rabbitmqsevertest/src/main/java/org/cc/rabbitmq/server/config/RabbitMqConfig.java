package org.cc.rabbitmq.server.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
	
	@Bean
	public Queue helloWorldQueue() {
		return new Queue("helloWorld_queue_test1",true);
	}
	
	@Bean
	public DirectExchange helloWorldExchange() {
		return new DirectExchange("helloWorld_exchange_test1",true,false);
	}
	
	@Bean
	public Binding helloWorldBinding() {
		return BindingBuilder.bind(helloWorldQueue()).to(helloWorldExchange()).with("hello_world_route_key");
	}
}
