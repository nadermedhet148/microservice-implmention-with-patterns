package com.orders.report.Ports.Messages;

import com.avroSchema.*;
import com.orders.report.Application.OrderReportService;
import com.orders.report.Domain.Events.OrderCheckingQuantityEvent;
import com.orders.report.Domain.Events.OrderPaymentIsFailedEvent;
import com.orders.report.Domain.Events.OrderPaymentIsSucceedEvent;
import com.orders.report.Domain.Events.OrderQuantityIsNotAvailableEvent;
import com.orders.report.Ports.WebServices.IProductService;
import com.orders.report.infrastructure.EventProducers.Mappers.OrderCheckingQuantityEventMapper;
import com.orders.report.infrastructure.EventProducers.Mappers.OrderPaymentIsFailedEventMapper;
import com.orders.report.infrastructure.EventProducers.Mappers.OrderPaymentIsSucceedEventMapper;
import com.orders.report.infrastructure.EventProducers.Mappers.OrderQuantityIsNotAvailableMapper;
import com.orders.report.infrastructure.repositories.IOrderRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderEventsConsumer {

  @Autowired
  IOrderRepository orderRepository;

  @Autowired
  IProductService productService;



  @KafkaListener(
          topics = "OrderCreated",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consume(OrderCheckingQuantityRecord record) {
    OrderCheckingQuantityEvent event = OrderCheckingQuantityEventMapper.INSTANCE.mapToEvent((OrderCheckingQuantityRecord) record);
    OrderReportService orderReportService = new OrderReportService(this.orderRepository , this.productService);
    log.info(String.format("Consumed message -> %s", event));
    orderReportService.createOrder(event.getProductQuantity(),event.getProductId(),event.getOrderId());
  }

  @KafkaListener(
          topics = "OrderQuantityIsNotAvailableEvent",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderQuantityIsNotAvailableEvent(OrderQuantityIsNotAvailableRecord record) {
    log.info(String.format("Consumed OrderQuantityIsNotAvailableEvent -> %s", record));
    OrderQuantityIsNotAvailableEvent event = OrderQuantityIsNotAvailableMapper.INSTANCE.mapToEvent((OrderQuantityIsNotAvailableRecord) record);
    OrderReportService orderReportService = new OrderReportService(this.orderRepository , this.productService);
    orderReportService.handelOrderQuantityIsNotAvailableEvent(event.getOrderId());
  }
  @KafkaListener(
          topics = "OrderPaymentIsFailedEvent",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderPaymentIsFailedEvent(OrderPaymentIsFailedRecord record) {
    log.info(String.format("Consumed OrderPaymentIsFailedEvent -> %s", record));
    OrderPaymentIsFailedEvent event = OrderPaymentIsFailedEventMapper.INSTANCE.mapToEvent((OrderPaymentIsFailedRecord) record);
    OrderReportService orderReportService = new OrderReportService(this.orderRepository , this.productService);
    orderReportService.handelOrderPaymentIsFailedEvent(event.getOrderId());
  }
  @KafkaListener(
          topics = "OrderPaymentIsSucceedEvent",
          groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderPaymentIsSucceedEvent(OrderPaymentIsSucceedRecord record) {
    log.info(String.format("Consumed OrderPaymentIsSucceedEvent -> %s", record));
    OrderPaymentIsSucceedEvent event = OrderPaymentIsSucceedEventMapper.INSTANCE.mapToEvent((OrderPaymentIsSucceedRecord) record);
    OrderReportService orderReportService = new OrderReportService(this.orderRepository , this.productService);
    orderReportService.handelOrderPaymentIsSucceedEvent(event.getOrderId());
  }


}