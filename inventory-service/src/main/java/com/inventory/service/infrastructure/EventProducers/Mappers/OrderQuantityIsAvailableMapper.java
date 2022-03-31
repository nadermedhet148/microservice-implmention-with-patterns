package com.inventory.service.infrastructure.EventProducers.Mappers;

import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.OrderQuantityIsAvailableRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderQuantityIsAvailableMapper {

    OrderQuantityIsAvailableMapper INSTANCE = Mappers.getMapper( OrderQuantityIsAvailableMapper.class );

    OrderQuantityIsAvailableRecord mapToRecord(OrderQuantityIsAvailableEvent event);
    OrderQuantityIsAvailableEvent mapToEvent( OrderQuantityIsAvailableRecord event);


}