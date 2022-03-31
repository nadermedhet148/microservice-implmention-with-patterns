package com.inventory.service;

//import com.order.service.Ports.Messages.EventsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {
	private static ConfigurableApplicationContext context;


//	@Bean
//	NewTopic newTopic() {
//		return new NewTopic(topicName, partitions, replicationFactor);
//	}

	public static void main(String[] args) {
		context = SpringApplication.run(ProductServiceApplication.class, args);
//		EventsController eventsController = (EventsController) context.getBean("eventsController");
//		eventsController.consumeEvents();
	}



}
