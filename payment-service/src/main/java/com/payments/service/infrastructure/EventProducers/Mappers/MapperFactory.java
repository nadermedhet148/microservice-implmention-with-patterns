package com.payments.service.infrastructure.EventProducers.Mappers;

import com.payments.service.Domain.Events.DomainEvent;
import com.payments.service.Domain.Events.OrderCheckPaymentEvent;
import com.payments.service.Domain.Events.OrderPaymentIsFailedEvent;
import com.payments.service.Domain.Events.OrderPaymentIsSucceedEvent;
import org.apache.avro.specific.SpecificRecordBase;

public class MapperFactory {
    public SpecificRecordBase getMappedRecord(DomainEvent event){
        if(event instanceof OrderCheckPaymentEvent)
            return  OrderCheckPaymentEventMapperr.INSTANCE.mapToRecord((OrderCheckPaymentEvent) event);
        if(event instanceof OrderPaymentIsFailedEvent)
            return  OrderPaymentIsFailedEventMapper.INSTANCE.mapToRecord((OrderPaymentIsFailedEvent) event);
        if(event instanceof OrderPaymentIsSucceedEvent)
            return  OrderPaymentIsSucceedEventMapper.INSTANCE.mapToRecord((OrderPaymentIsSucceedEvent) event);
        return  null;

    }
}
