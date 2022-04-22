package com.orders.report.infrastructure.EventProducers.Mappers;

import com.avroSchema.OrderPaymentIsSucceedRecord;
import com.orders.report.Domain.Events.OrderPaymentIsSucceedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderPaymentIsSucceedEventMapper {

    OrderPaymentIsSucceedEventMapper INSTANCE = Mappers.getMapper( OrderPaymentIsSucceedEventMapper.class );

    OrderPaymentIsSucceedRecord mapToRecord(OrderPaymentIsSucceedEvent event);
    OrderPaymentIsSucceedEvent mapToEvent(OrderPaymentIsSucceedRecord event);


}