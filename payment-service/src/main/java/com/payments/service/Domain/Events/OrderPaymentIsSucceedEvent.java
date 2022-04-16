package com.payments.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaymentIsSucceedEvent extends DomainEvent {
    public final String eventName = "OrderPaymentIsSucceedEvent";
    private Integer orderId ;

}
