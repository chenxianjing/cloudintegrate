package org.cc.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return new HelloWorldCommandLineRunner();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	public static class HelloWorldCommandLineRunner implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello,World!");
		}
		
	}
}
