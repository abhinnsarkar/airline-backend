package com.sarkar.airlinebackend;

import com.sarkar.airlinebackend.models.CustomerModel;

import com.sarkar.airlinebackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> postCustomer(@RequestBody CustomerModel customer){
        return ResponseEntity.ok("User created successfully");
    }
    
}
