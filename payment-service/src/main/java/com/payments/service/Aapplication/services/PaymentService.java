package com.payments.service.Aapplication.services;


import com.payments.service.Aapplication.interfaces.IEventProducer;
import com.payments.service.Domain.Events.OrderCheckPaymentEvent;
import com.payments.service.Domain.Events.OrderPaymentIsFailedEvent;
import com.payments.service.Domain.Events.OrderPaymentIsSucceedEvent;
import com.payments.service.Domain.models.Transaction;
import com.payments.service.Domain.models.UserPaymentAccount;
import com.payments.service.infrastructure.repositories.ITransactionRepository;
import com.payments.service.infrastructure.repositories.IUserPaymentAccountRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentService {

    IUserPaymentAccountRepository userPaymentAccountRepository;

    ITransactionRepository transactionRepository;

    IEventProducer eventProducer;

    public UserPaymentAccount checkOrderPayment(OrderCheckPaymentEvent event){
        UserPaymentAccount userPaymentAccount = this.userPaymentAccountRepository.getOne(event.getUserId());

        if(userPaymentAccount != null && userPaymentAccount.getAvailableBalance() > event.getAmount()){
            userPaymentAccount.setAvailableBalance(userPaymentAccount.getAvailableBalance() - event.getAmount());
            this.userPaymentAccountRepository.save(userPaymentAccount);
            this.transactionRepository.save(new Transaction(null , event.getAmount() , userPaymentAccount));
            this.eventProducer.sendMessage(new OrderPaymentIsSucceedEvent(event.getOrderId()));
        }else {
            this.eventProducer.sendMessage(new OrderPaymentIsFailedEvent(event.getOrderId()));
        }
        return  userPaymentAccount;

    }


}
