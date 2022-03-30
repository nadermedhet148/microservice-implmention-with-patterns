package com.payment.demo.events.handelers;

import com.payment.demo.events.EventsConstants;
import com.payment.demo.events.handelers.EventHandler;
import com.payment.demo.models.Payment;
import com.payment.demo.repository.IPaymentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderHandler extends EventHandler {
    @Autowired
    IPaymentRepository paymentRepository;

    public CreateOrderHandler(IPaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
        this.setEventName(EventsConstants.CREATE_PAYMENT);
    }
    @Override
    public void handle(int key , JSONObject payload) {
        Payment payment = new Payment();
        payment.setStatus("PENDING");
        payment.setAmount(((Integer) payload.get("amount")).floatValue());
        payment.setOrderId((Integer) payload.get("id"));
        paymentRepository.save(payment);
        System.out.println(payment.toJson());
    }
}
