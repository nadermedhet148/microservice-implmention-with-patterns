package com.payments.service.Domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transactionId")
    private Integer transactionId ;


    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name="user_payment_account_id", nullable=false)
    private UserPaymentAccount userPaymentAccount;




}
