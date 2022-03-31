package com.order.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuantityIsAvailableEvent extends DomainEvent {
    public final String eventName = "OrderQuantityIsAvailableEvent";
    private Float amount ;
    private Integer orderId ;

}
