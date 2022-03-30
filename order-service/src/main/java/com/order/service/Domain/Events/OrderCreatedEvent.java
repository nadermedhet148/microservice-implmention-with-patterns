package com.order.service.Domain.Events;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent extends  DomainEvent {
    public final String eventName = "OrderCreated";
    private Integer id ;
    private Float amount;


}
