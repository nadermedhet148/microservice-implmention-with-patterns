package com.payment.demo.events.publishers;

import com.payment.demo.events.EventsConstants;
import com.payment.demo.models.Payment;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class FailedOrderEvent {

    public void publishFailedOrder(Payment payment){

        Producer<Long, String> producer = com.order.service.events.kafka.producer.ProducerCreator.createProducer();


        ProducerRecord<Long, String> producerRecord = new ProducerRecord(EventsConstants.FAILED_ORDER, payment.getId() , payment.toJson());
        try {
            RecordMetadata metadata = producer.send(producerRecord).get();
            System.out.println("Record sent with key " + " to partition " + metadata.partition()
                    + " with offset " + metadata.offset());
        } catch (ExecutionException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        }
    }


}
