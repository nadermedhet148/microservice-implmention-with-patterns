package com.order.service;

//import com.order.service.Ports.Messages.EventsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {
	private static ConfigurableApplicationContext context;

	@Value("${topic.name}")
	private String topicName;

	@Value("${topic.partitions-num}")
	private Integer partitions;

	@Value("${topic.replication-factor}")
	private short replicationFactor;

	@Bean
	NewTopic newTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}

	public static void main(String[] args) {
		context = SpringApplication.run(OrderServiceApplication.class, args);
//		EventsController eventsController = (EventsController) context.getBean("eventsController");
//		eventsController.consumeEvents();
	}



}
