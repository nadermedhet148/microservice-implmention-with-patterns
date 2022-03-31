package com.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrderServiceApplication {
	private static ConfigurableApplicationContext context;



	public static void main(String[] args) {
		context = SpringApplication.run(OrderServiceApplication.class, args);
	}



}
