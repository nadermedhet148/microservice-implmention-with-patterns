package com.orders.report;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderReportsApplication {


	public static void main(String[] args) {
		SpringApplication.run(OrderReportsApplication.class, args);
	}




}
