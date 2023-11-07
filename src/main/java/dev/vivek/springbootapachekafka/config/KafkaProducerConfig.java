package dev.vivek.springbootapachekafka.config;

import dev.vivek.springbootapachekafka.KafkaConstraints;
import dev.vivek.springbootapachekafka.bindings.Customer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    /*this method is used for kafka producer config
    * details*/
    @Bean
    public ProducerFactory<String, Customer> producerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstraints.HOST);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    /*this method is used to create Kafkatemplate bean object*/
    @Bean(name = "kafkaTemplate")
    public KafkaTemplate<String, Customer> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
