package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flight-model")
@Tag(name = "flight model", description = "Operations related to flight models etc")
public class FlightModelController {

    @Autowired
    GetFlightModelsHandler getFlightModelsHandler;
}
