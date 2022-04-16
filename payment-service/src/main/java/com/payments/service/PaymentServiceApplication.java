package com.payments.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PaymentServiceApplication {
	private static ConfigurableApplicationContext context;



	public static void main(String[] args) {
		context = SpringApplication.run(PaymentServiceApplication.class, args);
	}



}
