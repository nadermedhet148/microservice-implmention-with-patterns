package com.inventory.service.Ports.Web.controllers;

import com.inventory.service.Domain.models.Product;
import com.inventory.service.infrastructure.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
@AllArgsConstructor(onConstructor = @__(
        @Inject))
public class ProductController {


    @Autowired
    IProductRepository productRepository;




    @GetMapping(value = "{id}")
    @Transactional
    public Optional<Product> createOrder(@PathVariable Integer id){
        return this.productRepository.findOneByProductId(id);
    }

}
