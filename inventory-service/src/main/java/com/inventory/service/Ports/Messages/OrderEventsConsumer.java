package com.inventory.service.Ports.Messages;

import com.avroSchema.OrderCheckingQuantityRecord;
import com.avroSchema.OrderPaymentIsFailedRecord;
import com.inventory.service.Aapplication.services.ProductService;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.Domain.Events.OrderPaymentIsFailedEvent;
import com.inventory.service.infrastructure.Cache.ProductCacheManager;
import com.inventory.service.infrastructure.EventProducers.Mappers.OrderCreatedEventMapper;
import com.inventory.service.infrastructure.EventProducers.Mappers.OrderPaymentIsFailedEventMapper;
import com.inventory.service.infrastructure.EventProducers.Producer;
import com.inventory.service.infrastructure.repositories.IDuctedQuantityRepository;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderEventsConsumer {

  @Autowired
  Producer producer;

  @Autowired
  IProductRepository productRepository;

  @Autowired
  IDuctedQuantityRepository ductedQuantityRepository;


  @Autowired
  ProductCacheManager productCache;


  @KafkaListener(
      topics = "OrderCreated",
      groupId = "simple-consumer"
  )
  @Transactional
  public void consume(OrderCheckingQuantityRecord record) {
    OrderCheckingQuantityEvent event = OrderCreatedEventMapper.INSTANCE.mapToEvent((OrderCheckingQuantityRecord) record);
    ProductService productService = new ProductService(producer , productRepository,ductedQuantityRepository,productCache);
    log.info(String.format("Consumed message -> %s", event));
    productService.checkOrderProductQuantityAvailability(event);
  }


  @KafkaListener(
          topics = "OrderPaymentIsFailedEvent",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderPaymentIsFailedEvent(OrderPaymentIsFailedRecord record) {
    log.info(String.format("Consumed OrderPaymentIsFailedEvent -> %s", record));
    OrderPaymentIsFailedEvent event = OrderPaymentIsFailedEventMapper.INSTANCE.mapToEvent((OrderPaymentIsFailedRecord) record);
    ProductService productService = new ProductService(producer , productRepository,ductedQuantityRepository,productCache);
    log.info(String.format("Consumed message -> %s", event));
    productService.revertDuctedQuantity(event);
  }
}