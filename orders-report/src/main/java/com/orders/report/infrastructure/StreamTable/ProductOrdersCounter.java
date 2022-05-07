package com.orders.report.infrastructure.StreamTable;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanCustomizer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class ProductOrdersCounter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductOrdersCounter.class);

    private String bootstrapServers = "http://localhost:29092";


    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kafkaStreamsConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "simpleKafkaStream");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class.getName());
        return new KafkaStreamsConfiguration(props);
    }

//    @Bean
//    public StreamsBuilderFactoryBeanCustomizer customizer() {
//        return fb -> fb.setStateListener((newState, oldState) -> {
//            LOGGER.info("State transition from " + oldState + " to " + newState);
//        });
//    }

    @Bean
    public KStream<String, String> kafkaStream() {

        KStream<String, String> stream = new StreamsBuilder().stream("OrderCreated");

        //process messages (reverse order)
        stream.mapValues( messageValue -> {
            LOGGER.info("Stream:SimpleKafkaStream OrderCreated payloads='{}'", messageValue);
            return new StringBuilder(messageValue).reverse().toString();
        }).to("OrderCreated2");

        LOGGER.info("Stream started here...");
        return stream;
    }
}

