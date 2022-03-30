package com.order.service.infrastructure.EventProducers.Mappers;


import com.order.service.Domain.Events.OrderCreatedEvent;
import com.order.service.OrderCreatedRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCreatedEventMapper {

    OrderCreatedEventMapper INSTANCE = Mappers.getMapper( OrderCreatedEventMapper.class );

    OrderCreatedRecord mapToRecord(OrderCreatedEvent event);
    OrderCreatedEvent mapToEvent( OrderCreatedRecord event);


}