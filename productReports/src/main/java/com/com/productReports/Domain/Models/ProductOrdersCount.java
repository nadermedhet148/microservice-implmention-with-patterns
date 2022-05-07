package com.com.productReports.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "ProductOrdersCount")
@NoArgsConstructor
public class ProductOrdersCount {

    @Id
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "count")
    private Integer count = 0;
}
