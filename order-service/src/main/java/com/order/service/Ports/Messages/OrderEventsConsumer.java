package com.order.service.Ports.Messages;

import com.avroSchema.OrderQuantityIsAvailableRecord;
import com.avroSchema.OrderQuantityIsNotAvailableRecord;
import com.order.service.Aapplication.services.OrderService;
import com.order.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.order.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import com.order.service.infrastructure.EventProducers.Mappers.OrderQuantityIsAvailableMapper;
import com.order.service.infrastructure.EventProducers.Mappers.OrderQuantityIsNotAvailableMapper;
import com.order.service.infrastructure.EventProducers.Producer;
import com.order.service.infrastructure.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderEventsConsumer {

  @Autowired
  IOrderRepository OrderRepository;

  @Autowired
  Producer producer;

  @KafkaListener(
      topics = "OrderQuantityIsAvailableEvent",
      groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderQuantityIsAvailableEvent(OrderQuantityIsAvailableRecord record) {
    log.info(String.format("Consumed OrderQuantityIsAvailableEvent -> %s", record));
    OrderQuantityIsAvailableEvent event = OrderQuantityIsAvailableMapper.INSTANCE.mapToEvent((OrderQuantityIsAvailableRecord) record);
    OrderService orderService = new OrderService(this.OrderRepository , this.producer);
    orderService.handelOrderQuantityIsAvailableEvent(event);
  }

  @KafkaListener(
          topics = "OrderQuantityIsNotAvailableEvent",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderQuantityIsNotAvailableEvent(OrderQuantityIsNotAvailableRecord record) {
    log.info(String.format("Consumed OrderQuantityIsNotAvailableEvent -> %s", record));
    OrderQuantityIsNotAvailableEvent event = OrderQuantityIsNotAvailableMapper.INSTANCE.mapToEvent((OrderQuantityIsNotAvailableRecord) record);
    OrderService orderService = new OrderService(this.OrderRepository , this.producer);
    orderService.handelOrderQuantityIsNotAvailableEvent(event);
  }
}