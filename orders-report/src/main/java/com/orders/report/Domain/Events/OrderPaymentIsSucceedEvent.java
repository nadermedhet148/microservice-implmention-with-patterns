package com.orders.report.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaymentIsSucceedEvent extends DomainEvent {
    public final String eventName = "OrderCheckPaymentEvent";
    private Integer orderId ;

}
