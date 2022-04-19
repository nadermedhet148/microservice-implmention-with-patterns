package com.inventory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductServiceApplication {
	private static ConfigurableApplicationContext context;



	public static void main(String[] args) {
		context = SpringApplication.run(ProductServiceApplication.class, args);

	}



}
