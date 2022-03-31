package com.order.service.infrastructure.EventProducers.Mappers;


import com.order.service.Domain.Events.OrderCheckingQuantityEvent;
import com.order.service.OrderCheckingQuantityRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCreatedEventMapper {

    OrderCreatedEventMapper INSTANCE = Mappers.getMapper( OrderCreatedEventMapper.class );

    OrderCheckingQuantityRecord mapToRecord(OrderCheckingQuantityEvent event);
    OrderCheckingQuantityEvent mapToEvent( OrderCheckingQuantityRecord event);


}