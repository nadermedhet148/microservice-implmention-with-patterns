package com.inventory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApplication {
	private static ConfigurableApplicationContext context;



	public static void main(String[] args) {
		context = SpringApplication.run(ProductServiceApplication.class, args);

	}







}
