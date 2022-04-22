package com.orders.report.Application;

import com.orders.report.Domain.Models.Order;
import com.orders.report.Domain.Models.Product;
import com.orders.report.Ports.WebServices.IProductService;
import com.orders.report.infrastructure.repositories.IOrderRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class OrderReportService {

    private IOrderRepository orderRepository;

    private IProductService productService;


    public Order createOrder( Integer productQuantity,Integer productId , Integer orderId ){
        Order order =new Order();
        order.setProductId(productId);
        order.setOrderId((orderId));
        order.setProductQuantity(productQuantity);
        Product product = this.productService.getProduct(productId);
        order.setProductName(product.getName());
        order.setAmount(product.getPrice() * productQuantity);
        this.orderRepository.save(order);
        return order;
    }


    public  Order handelOrderQuantityIsNotAvailableEvent(Integer orderId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        order.get().setStatus("FAILED_QUANTITY_NOT_AVAILABLE");
        this.orderRepository.save(order.get());
        return order.get();
    }

    public  Order handelOrderPaymentIsFailedEvent(Integer orderId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        order.get().setStatus("FAILED_BALANCE_NOT_ENOUGH");
        this.orderRepository.save(order.get());
        return order.get();
    }

    public  Order handelOrderPaymentIsSucceedEvent(Integer orderId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        order.get().setStatus("CONFIRMED");
        this.orderRepository.save(order.get());
        return order.get();
    }


}
