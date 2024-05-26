package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.Customer.GetCustomersHandler;
import com.sarkar.airlinebackend.models.CustomerModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Tag(name = "customer", description = "Operations related to customer")
public class CustomerController {

    @Autowired
    private GetCustomersHandler getCustomersHandler;

    @GetMapping(value = "")
    public List<CustomerModel> getCustomers() {
        return getCustomersHandler.handle();
    }
}


