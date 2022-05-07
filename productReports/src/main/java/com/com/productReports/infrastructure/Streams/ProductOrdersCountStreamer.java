package com.com.productReports.infrastructure.Streams;

import com.avroSchema.OrderCheckingQuantityRecord;
import com.com.productReports.Domain.Models.ProductOrdersCount;
import com.com.productReports.infrastructure.repositories.IProductOrdersCountRepository;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;




@Component
public class ProductOrdersCountStreamer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductOrdersCountStreamer.class);

    @Autowired
    IProductOrdersCountRepository productOrdersCountRepository;

    @Bean
    public KStream<String, ProductOrdersCount> kafkaStream(StreamsBuilder kStreamBuilder) {



        final Serde<OrderCheckingQuantityRecord> valueSpecificAvroSerde = new SerdeConfigBuilder<OrderCheckingQuantityRecord>().build();

        KTable<Integer, Integer> table = kStreamBuilder.stream("OrderCreated",
                        Consumed.with(Serdes.String(), valueSpecificAvroSerde)
                )
                .map((key, v) -> new KeyValue<>(v.getProductId(), 1))
                .groupByKey(Serialized.with(Serdes.Integer(), Serdes.Integer()))
                .reduce((cu , v)-> cu + v ,
                        Materialized.<Integer, Integer, KeyValueStore<Bytes, byte[]>>as("ProductOrdersCount")
                                .withValueSerde(Serdes.Integer())
                        );

        table.toStream().mapValues((v , k)->new ProductOrdersCount(v , k)).peek((k , v) -> {
            System.out.println(v);
            productOrdersCountRepository.save(v);
        });



        LOGGER.info("Stream started here...");
        return null;
    }
}
