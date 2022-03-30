package com.order.service.Ports.Messages;

import com.order.service.Domain.models.Order;
import com.order.service.OrderRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
@RequiredArgsConstructor
public class Producer {

  @Value("${topic.name}")
  private String TOPIC;

  private final KafkaTemplate<String, OrderRecord> kafkaTemplate;

  public void sendMessage(Order order) {
    log.info(String.format("Produced order -> %s", order ));

    OrderRecord record = new OrderRecord(order.getName() , order.getStatus() , order.getId(), 0 , order.getAmount());
    this.kafkaTemplate.send(this.TOPIC, order.getName(),record  );
    log.info(String.format("Produced order -> %s", record ));
  }
}
