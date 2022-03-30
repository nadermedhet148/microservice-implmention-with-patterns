package com.order.service.Ports.Web.controllers;

import com.order.service.Aapplication.services.OrderService;
import com.order.service.Domain.Events.OrderCreatedEvent;
import com.order.service.infrastructure.EventProducers.Producer;
import com.order.service.Ports.Web.controllers.requests.CreateOrderDto;
import com.order.service.Domain.models.Order;
import com.order.service.infrastructure.repositories.IOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor(onConstructor = @__(
        @Inject))
public class OrderController {

    @Autowired
    IOrderRepository OrderRepository;

    @Autowired
    Producer producer;




    @PostMapping(value = "")
    public Order createOrder(@RequestBody CreateOrderDto body){
        OrderService orderService = new OrderService(this.OrderRepository , this.producer);
        return orderService.createOrder(body);
    }

}
