package com.orders.report.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Product {
    private Integer productId ;
    private Integer availableQuantity;
    private String name;
    private Float price;



}
