package com.payments.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCheckPaymentEvent extends DomainEvent {
    public final String eventName = "OrderCheckPaymentEvent";
    private Integer orderId ;
    private Integer userId ;
    private Float amount ;

}
