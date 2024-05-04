package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.Flight.GetFlightsHandler;
import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flight")
@Tag(name = "flight", description = "Operations related to flight info")
public class FlightController {

    @Autowired
    GetFlightsHandler getFlightsHandler;
}
