package com.sarkar.airlinebackend;

import com.sarkar.airlinebackend.models.CustomerModel;

import com.sarkar.airlinebackend.repository.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
@Tag(name = "customers", description = "Operations related to customers")
public class CustomerEndpoint {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    @Operation(summary = "Get all customers", description = "Get a list of all customers.")
    public List<CustomerModel> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer.")
    public ResponseEntity<String> postCustomer(@RequestBody CustomerModel customer){
        return ResponseEntity.ok("User created successfully");
    }

}
