package com.inventory.service.infrastructure.EventProducers.Mappers;

import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import com.inventory.service.OrderQuantityIsAvailableRecord;
import com.inventory.service.OrderQuantityIsNotAvailableRecord;
import com.inventory.service.infrastructure.EventProducers.Mappers.OrderCreatedEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderQuantityIsNotAvailableMapper {

    OrderQuantityIsNotAvailableMapper INSTANCE = Mappers.getMapper( OrderQuantityIsNotAvailableMapper.class );

    OrderQuantityIsNotAvailableRecord mapToRecord(OrderQuantityIsNotAvailableEvent event);
    OrderQuantityIsNotAvailableEvent mapToEvent(OrderQuantityIsNotAvailableRecord event);


}