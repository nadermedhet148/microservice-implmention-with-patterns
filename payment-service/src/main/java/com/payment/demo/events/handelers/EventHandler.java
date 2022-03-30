package com.payment.demo.events.handelers;

import com.payment.demo.events.kafka.consumer.ConsumerCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.clients.consumer.Consumer;
import org.json.JSONObject;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class EventHandler {

    private  String eventName;

    public Consumer getConsumer(){
        return ConsumerCreator.createConsumer(this.eventName);
    }

    public abstract void handle(int key , JSONObject payload);

}
