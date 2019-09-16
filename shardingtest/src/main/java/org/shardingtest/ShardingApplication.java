package org.shardingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "org.shardingtest" })
@EnableJpaRepositories(basePackages = "org.shardingtest.repository")
@EntityScan("org.shardingtest.entity")
@EnableTransactionManagement(proxyTargetClass = true)
public class ShardingApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}
}
