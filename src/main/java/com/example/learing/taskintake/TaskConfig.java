package com.example.learing.taskintake;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

	@Bean
	public TaskProcessor geTaskProcessor() {
		return new TaskProcessor();
	}
	
}
