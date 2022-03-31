package com.order.service.Ports.Messages;

import com.avroSchema.OrderCheckingQuantityRecord;
import com.order.service.infrastructure.EventProducers.Mappers.OrderCreatedEventMapper;
import com.order.service.Domain.Events.OrderCheckingQuantityEvent;
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
  public void consume(OrderCheckingQuantityRecord record) {
    OrderCheckingQuantityEvent event = OrderCreatedEventMapper.INSTANCE.mapToEvent((OrderCheckingQuantityRecord) record);
    log.info(String.format("Consumed message -> %s", event));
  }
}