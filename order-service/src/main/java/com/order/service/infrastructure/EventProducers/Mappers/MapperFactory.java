package com.order.service.infrastructure.EventProducers.Mappers;

import com.order.service.Domain.Events.DomainEvent;
import com.order.service.Domain.Events.OrderCheckingQuantityEvent;
import org.apache.avro.specific.SpecificRecordBase;

public class MapperFactory {
    public SpecificRecordBase getMappedRecord(DomainEvent event){
        if(event instanceof OrderCheckingQuantityEvent)
            return  OrderCreatedEventMapper.INSTANCE.mapToRecord((OrderCheckingQuantityEvent) event);
        return  null;

    }
}
