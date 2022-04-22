package com.orders.report.Domain.Models;

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
    @Column(name = "orderId")
    private Integer orderId ;


    @Column(name = "productId")
    private Integer productId ;

    @Column(name = "userId")
    private Integer userId ;

    @Column(name = "productQuantity")
    private Integer productQuantity;

    @Column(name = "productName")
    private String productName;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Float amount;

}