package com.orders.report.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderQuantityIsNotAvailableRecord;
import com.orders.report.Domain.Events.OrderQuantityIsNotAvailableEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderQuantityIsNotAvailableMapper {

    OrderQuantityIsNotAvailableMapper INSTANCE = Mappers.getMapper( OrderQuantityIsNotAvailableMapper.class );

    OrderQuantityIsNotAvailableRecord mapToRecord(OrderQuantityIsNotAvailableEvent event);
    OrderQuantityIsNotAvailableEvent mapToEvent(OrderQuantityIsNotAvailableRecord event);


}