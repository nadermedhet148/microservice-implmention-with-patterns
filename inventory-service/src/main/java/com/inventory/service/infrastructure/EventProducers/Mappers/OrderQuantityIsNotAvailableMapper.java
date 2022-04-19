package com.inventory.service.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderQuantityIsNotAvailableRecord;
import com.inventory.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderQuantityIsNotAvailableMapper {

    OrderQuantityIsNotAvailableMapper INSTANCE = Mappers.getMapper( OrderQuantityIsNotAvailableMapper.class );

    OrderQuantityIsNotAvailableRecord mapToRecord(OrderQuantityIsNotAvailableEvent event);
    OrderQuantityIsNotAvailableEvent mapToEvent(OrderQuantityIsNotAvailableRecord event);


}