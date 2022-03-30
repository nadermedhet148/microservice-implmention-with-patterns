package com.payment.demo.events;

import com.payment.demo.events.handelers.CreateOrderHandler;
import com.payment.demo.events.handelers.EventHandler;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventsController {
    @Autowired
    CreateOrderHandler createOrderHandler;

    public EventsController(CreateOrderHandler createOrderHandler){
        this.createOrderHandler = createOrderHandler;
    }


    public void consumeEvents(){
        List<EventHandler> eventsHandlers = Arrays.asList(createOrderHandler);

        eventsHandlers.forEach(eventHandler -> {
            Consumer consumer = eventHandler.getConsumer();
            while (true) {
                final ConsumerRecords<Integer, String> consumerRecords = consumer.poll(1000);
                consumerRecords.forEach(record -> {
                    System.out.println("Record Key " + record.key());
                    JSONObject json = new JSONObject(record.value());
                    eventHandler.handle(record.key() , json);
                });
                consumer.commitAsync();
            }
        });
    }
}
