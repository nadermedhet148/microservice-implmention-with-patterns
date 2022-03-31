package com.inventory.service.Ports.Web.controllers;

import com.inventory.service.infrastructure.EventProducers.Producer;
import com.inventory.service.Ports.Web.controllers.requests.CreateOrderDto;
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
    Producer producer;




//    @PostMapping(value = "")
//    public Order createOrder(@RequestBody CreateOrderDto body){
//        OrderService orderService = new OrderService(this.OrderRepository , this.producer);
//        return orderService.createOrder(body);
//    }

}
