package com.order.service.Ports.Messages;

import com.order.service.Domain.models.Order;
import com.order.service.OrderRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerGroupMetadata;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @KafkaListener(
      topics = "#{'${topic.name}'}",
      groupId = "simple-consumer"
  )
  public void consume(OrderRecord record) {
    log.info(String.format("Consumed message -> %s", record));
  }
}