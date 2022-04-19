package com.inventory.service.infrastructure.EventProducers.Mappers;


import com.avroSchema.OrderCheckingQuantityRecord;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCreatedEventMapper {

    OrderCreatedEventMapper INSTANCE = Mappers.getMapper( OrderCreatedEventMapper.class );

    OrderCheckingQuantityRecord mapToRecord(OrderCheckingQuantityEvent event);
    OrderCheckingQuantityEvent mapToEvent( OrderCheckingQuantityRecord event);


}