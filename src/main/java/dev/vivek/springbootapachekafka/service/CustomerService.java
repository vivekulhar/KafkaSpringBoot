package dev.vivek.springbootapachekafka.service;

import dev.vivek.springbootapachekafka.KafkaConstraints;
import dev.vivek.springbootapachekafka.bindings.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {
    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    public String add(List<Customer> customers){
        if(!customers.isEmpty()){
            for (Customer customer : customers) {
                kafkaTemplate.send(KafkaConstraints.TOPIC, customer);
                System.out.println("**********Msg sent to kafka**********");
            }
        }
        return "Customers Record added to kafka Queue successfully";
    }

    @KafkaListener(topics = KafkaConstraints.TOPIC, groupId = KafkaConstraints.GROUP_ID)
    public Customer listener(Customer customer){
        System.out.println("**********Msg received from kafka**********");
        System.out.println(customer);
        return customer;
    }
}
