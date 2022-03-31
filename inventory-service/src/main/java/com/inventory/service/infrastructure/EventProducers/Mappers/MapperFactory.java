package com.inventory.service.infrastructure.EventProducers.Mappers;

import com.inventory.service.Domain.Events.DomainEvent;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
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
