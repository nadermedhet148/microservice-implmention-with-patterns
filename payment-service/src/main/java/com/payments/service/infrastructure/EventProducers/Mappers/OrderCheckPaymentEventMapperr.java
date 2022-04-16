package com.payments.service.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderCheckPaymentRecord;
import com.payments.service.Domain.Events.OrderCheckPaymentEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderCheckPaymentEventMapperr {

    OrderCheckPaymentEventMapperr INSTANCE = Mappers.getMapper( OrderCheckPaymentEventMapperr.class );

    OrderCheckPaymentRecord mapToRecord(OrderCheckPaymentEvent event);
    OrderCheckPaymentEvent mapToEvent(OrderCheckPaymentRecord event);


}