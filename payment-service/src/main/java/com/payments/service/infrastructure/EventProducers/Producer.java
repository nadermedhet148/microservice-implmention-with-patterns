package com.payments.service.infrastructure.EventProducers;

import com.payments.service.Aapplication.interfaces.IEventProducer;
import com.payments.service.Domain.Events.DomainEvent;
import com.payments.service.infrastructure.EventProducers.Mappers.MapperFactory;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
@RequiredArgsConstructor
public class Producer implements IEventProducer<DomainEvent> {


  private final KafkaTemplate<String, SpecificRecordBase> kafkaTemplate;



  @Override
  public void sendMessage(DomainEvent event) {
    SpecificRecordBase record =  new MapperFactory().getMappedRecord(event);
    this.kafkaTemplate.send(event.getEventName(), event.toString(), record  );
    log.info(String.format("Produced event -> %s  , %S",event.getEventName(), record ));

  }
}
