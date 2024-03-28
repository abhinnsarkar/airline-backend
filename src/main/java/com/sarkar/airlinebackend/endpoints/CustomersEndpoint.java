package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.CustomerModel;

import com.sarkar.airlinebackend.repositories.CustomersRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
@Tag(name = "customers", description = "Operations related to customers")
public class CustomersEndpoint {

    @Autowired
    CustomersRepository customersRepository;

    @GetMapping()
    @Operation(summary = "Get all customers", description = "Get a list of all customers.")
    public List<CustomerModel> getCustomers(){
        return customersRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer.")
    public ResponseEntity<CustomerModel> postCustomer(@RequestBody CustomerModel customer) {

        customer.setCustomerId(UUID.randomUUID());

        CustomerModel savedCustomer = customersRepository.save(customer);

        if (savedCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
