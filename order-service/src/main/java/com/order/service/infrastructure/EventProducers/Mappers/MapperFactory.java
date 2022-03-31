package com.order.service.infrastructure.EventProducers.Mappers;

import com.order.service.Domain.Events.DomainEvent;
import com.order.service.Domain.Events.OrderCheckingQuantityEvent;
import com.order.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.order.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import org.apache.avro.specific.SpecificRecordBase;

public class MapperFactory {
    public SpecificRecordBase getMappedRecord(DomainEvent event){
        if(event instanceof OrderCheckingQuantityEvent)
            return  OrderCreatedEventMapper.INSTANCE.mapToRecord((OrderCheckingQuantityEvent) event);
        if(event instanceof OrderQuantityIsAvailableEvent)
            return  OrderQuantityIsAvailableMapper.INSTANCE.mapToRecord((OrderQuantityIsAvailableEvent) event);
        if(event instanceof OrderQuantityIsNotAvailableEvent)
            return  OrderQuantityIsNotAvailableMapper.INSTANCE.mapToRecord((OrderQuantityIsNotAvailableEvent) event);
        return  null;

    }
}
