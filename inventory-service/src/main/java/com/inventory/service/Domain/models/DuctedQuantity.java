package com.inventory.service.Domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "DuctedQuantity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DuctedQuantity {

    @Id
    @Column(name = "productId")
    private Integer productId ;

    @Column(name = "orderId")
    private Integer orderId ;

    @Column(name = "quantity")
    private Integer quantity ;
}
