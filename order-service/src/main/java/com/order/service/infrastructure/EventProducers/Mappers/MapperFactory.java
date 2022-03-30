package com.order.service.infrastructure.EventProducers.Mappers;

import com.order.service.Domain.Events.DomainEvent;
import com.order.service.Domain.Events.OrderCreatedEvent;
import com.order.service.OrderCreatedRecord;
import org.apache.avro.specific.SpecificRecordBase;

public class MapperFactory {
    public SpecificRecordBase getMappedRecord(DomainEvent event){
        if(event instanceof OrderCreatedEvent)
            return  OrderCreatedEventMapper.INSTANCE.mapToRecord((OrderCreatedEvent) event);
        return  null;

    }
}
