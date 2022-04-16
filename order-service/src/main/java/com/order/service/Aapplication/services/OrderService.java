package com.order.service.Aapplication.services;


import com.order.service.Aapplication.interfaces.IEventProducer;
import com.order.service.Domain.Events.*;
import com.order.service.Ports.Web.controllers.requests.CreateOrderDto;
import com.order.service.infrastructure.repositories.IOrderRepository;
import com.order.service.Domain.models.Order;

public class OrderService {
    private IOrderRepository orderRepo;
    private IEventProducer eventProducer;

    public OrderService(IOrderRepository orderRepo , IEventProducer eventProducer){
        this.orderRepo = orderRepo;
        this.eventProducer = eventProducer;
    }

    public Order createOrder(CreateOrderDto body){
        Order order = new Order();
        order.setUserId(body.getUserId());
        order.setProductId(body.getProductId());
        order.setProductQuantity(body.getProductQuantity());
        order.setStatus("CHECKING_QUANTITY");
        this.orderRepo.save(order);
        this.eventProducer.sendMessage(new OrderCheckingQuantityEvent(order.getProductId() , order.getOrderId(),order.getProductQuantity()));
        return order;
    }

    public  Order handelOrderQuantityIsAvailableEvent(OrderQuantityIsAvailableEvent event){
        Order order = this.orderRepo.getOne(event.getOrderId());
        order.setAmount(event.getAmount());
        order.setStatus("CHECKING_Payment");
        this.orderRepo.save(order);
        this.eventProducer.sendMessage(new OrderCheckPaymentEvent(order.getOrderId(), order.getUserId(), order.getAmount()));
        return order;
    }

    public  Order handelOrderQuantityIsNotAvailableEvent(OrderQuantityIsNotAvailableEvent event){
        Order order = this.orderRepo.getOne(event.getOrderId());
        order.setStatus("FAILED_QUANTITY_NOT_AVAILABLE");
        this.orderRepo.save(order);
        return order;
    }

    public  Order handelOrderPaymentIsFailedEvent(OrderPaymentIsFailedEvent event){
        Order order = this.orderRepo.getOne(event.getOrderId());
        order.setStatus("FAILED_BALANCE_NOT_ENOUGH");
        this.orderRepo.save(order);
        return order;
    }

    public  Order handelOrderPaymentIsSucceedEvent(OrderPaymentIsSucceedEvent event){
        Order order = this.orderRepo.getOne(event.getOrderId());
        order.setStatus("CONFIRMED");
        this.orderRepo.save(order);
        return order;
    }




}
