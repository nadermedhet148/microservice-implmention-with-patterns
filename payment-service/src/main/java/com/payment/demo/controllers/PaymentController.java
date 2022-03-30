package com.payment.demo.controllers;

import com.payment.demo.controllers.requests.PayRequest;
import com.payment.demo.events.publishers.FailedOrderEvent;
import com.payment.demo.events.publishers.SuccessOrderEvent;
import com.payment.demo.models.Payment;
import com.payment.demo.repository.IPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;


@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor(onConstructor = @__(
        @Inject))
public class PaymentController {

    @Autowired
    IPaymentRepository
            PaymentRepository;





    @PostMapping(value = "")
    public Payment createOrder(@RequestBody PayRequest body){
        SuccessOrderEvent successOrder = new SuccessOrderEvent();
        FailedOrderEvent failedOrderEvent = new FailedOrderEvent();

        Optional<Payment> payment = PaymentRepository.findById(body.getPaymentId());
        if(!payment.isPresent()) {
            return null;
        }
        Payment presentPayment = payment.get();
        if(body.getSuccess()){
            presentPayment.setStatus("PAID");
            successOrder.publishSuccessOrder(presentPayment);
        }
        if(!body.getSuccess()){
            presentPayment.setStatus("FAILED");
            failedOrderEvent.publishFailedOrder(presentPayment);
        }

        return presentPayment;
    }

}
