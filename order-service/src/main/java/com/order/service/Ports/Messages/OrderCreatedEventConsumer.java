package com.order.service.Ports.Messages;

import com.order.service.Domain.Events.OrderCreatedEvent;
import com.order.service.OrderCreatedRecord;
import com.order.service.infrastructure.EventProducers.Mappers.OrderCreatedEventMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderCreatedEventConsumer {

  @KafkaListener(
      topics = "OrderCreated",
      groupId = "simple-consumer"
  )
  public void consume(OrderCreatedRecord record) {
    OrderCreatedEvent event = OrderCreatedEventMapper.INSTANCE.mapToEvent((OrderCreatedRecord) record);
    log.info(String.format("Consumed message -> %s", event));
  }
}