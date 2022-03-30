package com.order.service.Ports.Web.controllers;

import com.order.service.Ports.Messages.Producer;
import com.order.service.Ports.Web.controllers.requests.CreateOrderRequest;
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
    public Order createOrder(@RequestBody CreateOrderRequest body){
        Order order = new Order();
        order.setAmount(body.getAmount());
        order.setName(body.getName());
        order.setStatus("PENDING");
        this.OrderRepository.save(order);
        producer.sendMessage(order);
        return order;
    }

}
