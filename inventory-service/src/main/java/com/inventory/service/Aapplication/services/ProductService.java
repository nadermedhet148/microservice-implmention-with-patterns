package com.inventory.service.Aapplication.services;


import com.avroSchema.OrderPaymentIsFailedRecord;
import com.inventory.service.Domain.Events.OrderCheckingQuantityEvent;
import com.inventory.service.Aapplication.interfaces.IEventProducer;
import com.inventory.service.Domain.Events.OrderPaymentIsFailedEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsAvailableEvent;
import com.inventory.service.Domain.Events.OrderQuantityIsNotAvailableEvent;
import com.inventory.service.Domain.models.DuctedQuantity;
import com.inventory.service.Domain.models.Product;
import com.inventory.service.infrastructure.Cache.ProductCacheManager;
import com.inventory.service.infrastructure.repositories.IDuctedQuantityRepository;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class ProductService {

    private  IEventProducer eventProducer;

    private IProductRepository productRepository;

    private IDuctedQuantityRepository ductedQuantityRepository;

    private ProductCacheManager productCache;




    @Transactional
    public Product checkOrderProductQuantityAvailability(OrderCheckingQuantityEvent event){

        Product product = this.productRepository.getOne(event.getProductId());

        if (product.getAvailableQuantity() >= event.getProductQuantity()){
            product.setAvailableQuantity(product.getAvailableQuantity() - event.getProductQuantity());
            this.productRepository.save(product);
            this.ductedQuantityRepository.save(new DuctedQuantity(event.getProductId() , event.getOrderId() , event.getProductQuantity()));
            productCache.put(event.getProductId() , product);
            this.eventProducer.sendMessage(new OrderQuantityIsAvailableEvent(event.getProductQuantity() * product.getPrice() , event.getOrderId()));
        }else {
            this.eventProducer.sendMessage(new OrderQuantityIsNotAvailableEvent(event.getOrderId()));
        }

        return product;

    }

    @Transactional
    public Product revertDuctedQuantity(OrderPaymentIsFailedEvent event){

        Optional<DuctedQuantity> order = this.ductedQuantityRepository.findOneByOrderId(event.getOrderId());
        Product product = this.productRepository.getOne(order.get().getProductId());
        product.setAvailableQuantity(product.getAvailableQuantity() + order.get().getQuantity());
        this.productRepository.save(product);
        productCache.put(product.getProductId() , product);

        return  product;


    }


}
