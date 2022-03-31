package com.inventory.service.Ports.Messages;

import com.inventory.service.Aapplication.services.ProductService;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.infrastructure.EventProducers.Mappers.OrderCreatedEventMapper;
import com.inventory.service.infrastructure.EventProducers.Producer;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import com.order.service.OrderCheckingQuantityRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderCreatedEventConsumer {

  @Autowired
  Producer producer;

  @Autowired
  IProductRepository productRepository;

  @KafkaListener(
      topics = "OrderCreated",
      groupId = "simple-consumer"
  )
  @Transactional
  public void consume(OrderCheckingQuantityRecord record) {
    OrderCheckingQuantityEvent event = OrderCreatedEventMapper.INSTANCE.mapToEvent((OrderCheckingQuantityRecord) record);
    ProductService productService = new ProductService(producer , productRepository);
    log.info(String.format("Consumed message -> %s", event));
    productService.checkOrderProductQuantityAvailability(event);
  }
}