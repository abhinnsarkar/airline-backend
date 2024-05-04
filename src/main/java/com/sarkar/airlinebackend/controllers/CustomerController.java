package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.Customer.GetCustomersHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping(value = "/customer")
@Tag(name = "customer", description = "Operations related to customer")
public class CustomerController {

    @Autowired
    private GetCustomersHandler getCustomersHandler;

}


