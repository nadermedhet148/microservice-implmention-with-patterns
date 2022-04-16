package com.order.service.infrastructure.EventProducers.Mappers;

import com.order.service.Domain.Events.*;
import org.apache.avro.specific.SpecificRecordBase;

public class MapperFactory {
    public SpecificRecordBase getMappedRecord(DomainEvent event){
        if(event instanceof OrderCheckingQuantityEvent)
            return  OrderCreatedEventMapper.INSTANCE.mapToRecord((OrderCheckingQuantityEvent) event);
        if(event instanceof OrderQuantityIsAvailableEvent)
            return  OrderQuantityIsAvailableMapper.INSTANCE.mapToRecord((OrderQuantityIsAvailableEvent) event);
        if(event instanceof OrderQuantityIsNotAvailableEvent)
            return  OrderQuantityIsNotAvailableMapper.INSTANCE.mapToRecord((OrderQuantityIsNotAvailableEvent) event);
        if(event instanceof OrderCheckPaymentEvent)
            return  OrderCheckPaymentEventMapper.INSTANCE.mapToRecord((OrderCheckPaymentEvent) event);
        return  null;

    }
}
