package com.payments.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaymentIsFailedEvent extends DomainEvent {
    public final String eventName = "OrderPaymentIsFailedEvent";
    private Integer orderId ;

}
