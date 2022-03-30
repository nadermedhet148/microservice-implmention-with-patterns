package com.order.service.Aapplication.services;


import com.order.service.Aapplication.interfaces.IEventProducer;
import com.order.service.Domain.Events.OrderCreatedEvent;
import com.order.service.Domain.models.Order;
import com.order.service.Ports.Web.controllers.requests.CreateOrderDto;
import com.order.service.infrastructure.repositories.IOrderRepository;

public class OrderService {
    private IOrderRepository orderRepo;
    private  IEventProducer eventProducer;

    public OrderService(IOrderRepository orderRepo , IEventProducer eventProducer){
        this.orderRepo = orderRepo;
        this.eventProducer = eventProducer;
    }

    public Order createOrder(CreateOrderDto body){
        Order order = new Order();
        order.setAmount(body.getAmount());
        order.setName(body.getName());
        order.setStatus("PENDING");
        this.orderRepo.save(order);
        this.eventProducer.sendMessage(new OrderCreatedEvent(order.getId(),order.getAmount()));
        return order;
    }

}
