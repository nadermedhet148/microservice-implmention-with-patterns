package com.payments.service.Ports.Messages;

import com.avroSchema.OrderCheckPaymentRecord;
import com.payments.service.Aapplication.services.PaymentService;
import com.payments.service.Domain.Events.OrderCheckPaymentEvent;
import com.payments.service.infrastructure.EventProducers.Mappers.OrderCheckPaymentEventMapperr;
import com.payments.service.infrastructure.EventProducers.Producer;
import com.payments.service.infrastructure.repositories.ITransactionRepository;
import com.payments.service.infrastructure.repositories.IUserPaymentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog(topic = "Consumer Logger")
public class OrderEventsConsumer {

  @Autowired
  IUserPaymentAccountRepository userPaymentAccountRepository;


  @Autowired
  ITransactionRepository transactionRepository;

  @Autowired
  Producer producer;

  @KafkaListener(
      topics = "OrderCheckPaymentEvent",
      groupId = "simple-consumer"
  )
  @Transactional
  public void consumeOrderCheckPaymentEvent(OrderCheckPaymentRecord record) {
    log.info(String.format("Consumed OrderQuantityIsAvailableEvent -> %s", record));
    OrderCheckPaymentEvent event = OrderCheckPaymentEventMapperr.INSTANCE.mapToEvent((OrderCheckPaymentRecord) record);
    PaymentService paymentService = new PaymentService(this.userPaymentAccountRepository  , this.transactionRepository , this.producer);
    paymentService.checkOrderPayment(event);
  }


}