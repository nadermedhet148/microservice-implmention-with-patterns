package com.payments.service.Domain.models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Table(name = "UserPaymentAccounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UserPaymentAccount {

    @Id
    @Column(name = "userId")
    private Integer userId ;


    @Column(name = "availableBalance")
    private Float availableBalance;

    @OneToMany(mappedBy="userPaymentAccount")
    private Set<Transaction> transactions;



}
