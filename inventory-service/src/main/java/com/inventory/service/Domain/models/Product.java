package com.inventory.service.Domain.models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Integer productId ;

    @Column(name = "availableQuantity")
    private Integer availableQuantity;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;



}
