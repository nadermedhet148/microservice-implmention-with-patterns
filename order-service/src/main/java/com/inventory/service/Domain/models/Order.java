package com.order.service.Domain.models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;


@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Integer orderId ;


    @Column(name = "productId")
    private Integer productId ;

    @Column(name = "productQuantity")
    private Integer productQuantity;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Float amount;



}
