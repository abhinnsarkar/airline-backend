package com.sarkar.airlinebackend;

import com.sarkar.airlinebackend.models.CustomerModel;

import com.sarkar.airlinebackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerEndpoint {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    public List<CustomerModel> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public String postCustomer(){
        return "customer added";
    }
    
}
