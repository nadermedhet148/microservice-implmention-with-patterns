package com.payment.demo.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.util.List;

@Table(name = "Payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id ;

    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Float amount;


    public String toJson (){
        JSONObject payload = new JSONObject();
        payload.put("amount",this.getAmount());
        payload.put("orderId",this.orderId);
        payload.put("amount",this.status);
        payload.put("paymentId",this.getId());
        return payload.toString();
    }

}
