package com.com.productReports.Domain.Events;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCheckingQuantityEvent extends DomainEvent {
    public final String eventName = "OrderCreated";
    private Integer productId ;
    private Integer orderId ;
    private Integer productQuantity;

}
