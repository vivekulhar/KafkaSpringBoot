package dev.vivek.springbootapachekafka.rest;

import dev.vivek.springbootapachekafka.bindings.Customer;

import dev.vivek.springbootapachekafka.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/getAll",produces = "application/json")
    public List<Customer> getAll(){
        Customer c1 = new Customer("Vivek", "vivek.kulhar23@gmail.com", 1);
        Customer c2 = new Customer("kulhar", "agsdg@gmail.com", 2);
        Customer c3 = new Customer("vivek kulhar", "vgsdagkulhar23@gmail.com", 3);

        List<Customer> customers = List.of(c1, c2, c3);
        return customers;
    }

    @PostMapping(value="/addCustomer",
                    consumes = {"application/json"} )
    public String addCustomer(@RequestBody List<Customer> customers) {
        return customerService.add(customers);
    }

}
