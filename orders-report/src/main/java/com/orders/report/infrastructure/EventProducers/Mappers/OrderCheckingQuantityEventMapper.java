package com.orders.report.infrastructure.EventProducers.Mappers;


import com.avroSchema.OrderCheckingQuantityRecord;
import com.orders.report.Domain.Events.OrderCheckingQuantityEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCheckingQuantityEventMapper {

    OrderCheckingQuantityEventMapper INSTANCE = Mappers.getMapper( OrderCheckingQuantityEventMapper.class );

    OrderCheckingQuantityRecord mapToRecord(OrderCheckingQuantityEvent event);
    OrderCheckingQuantityEvent mapToEvent( OrderCheckingQuantityRecord event);


}