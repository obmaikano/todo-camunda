package com.ohma.todocamunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class TodoCamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCamundaApplication.class, args);
	}

}
