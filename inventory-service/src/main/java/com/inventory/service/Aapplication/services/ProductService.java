package com.inventory.service.Aapplication.services;


import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.Aapplication.interfaces.IEventProducer;
import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import com.inventory.service.Domain.models.Product;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class ProductService {

    private  IEventProducer eventProducer;

    private IProductRepository productRepository;

    @Transactional
    public void checkOrderProductQuantityAvailability(OrderCheckingQuantityEvent event){

        Product product = this.productRepository.getOne(event.getProductId());

        if (product.getAvailableQuantity() >= event.getProductQuantity()){
            product.setAvailableQuantity(product.getAvailableQuantity() - event.getProductQuantity());
            this.eventProducer.sendMessage(new OrderQuantityIsAvailableEvent(event.getProductQuantity() * product.getPrice() , event.getOrderId()));
        }else {
            this.eventProducer.sendMessage(new OrderQuantityIsNotAvailableEvent(event.getOrderId()));
        }

    }


}
