package com.order.service.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderQuantityIsAvailableRecord;
import com.order.service.Domain.Events.OrderQuantityIsAvailableEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderQuantityIsAvailableMapper {

    OrderQuantityIsAvailableMapper INSTANCE = Mappers.getMapper( OrderQuantityIsAvailableMapper.class );

    OrderQuantityIsAvailableRecord mapToRecord(OrderQuantityIsAvailableEvent event);
    OrderQuantityIsAvailableEvent mapToEvent(OrderQuantityIsAvailableRecord event);


}