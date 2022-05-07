package com.inventory.service.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderPaymentIsFailedRecord;
import com.inventory.service.Domain.Events.OrderPaymentIsFailedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderPaymentIsFailedEventMapper {

    OrderPaymentIsFailedEventMapper INSTANCE = Mappers.getMapper( OrderPaymentIsFailedEventMapper.class );

    OrderPaymentIsFailedRecord mapToRecord(OrderPaymentIsFailedEvent event);
    OrderPaymentIsFailedEvent mapToEvent(OrderPaymentIsFailedRecord event);


}