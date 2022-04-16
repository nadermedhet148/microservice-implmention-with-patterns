package com.order.service.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderCheckPaymentRecord;
import com.order.service.Domain.Events.OrderCheckPaymentEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCheckPaymentEventMapper {

    OrderCheckPaymentEventMapper INSTANCE = Mappers.getMapper( OrderCheckPaymentEventMapper.class );

    OrderCheckPaymentRecord mapToRecord(OrderCheckPaymentEvent event);
    OrderCheckPaymentEvent mapToEvent(OrderCheckPaymentRecord event);


}