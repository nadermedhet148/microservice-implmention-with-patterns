package com.order.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuantityIsNotAvailableEvent extends DomainEvent {
    public final String eventName = "OrderQuantityIsNotAvailableEvent";
    private Integer orderId ;

}
