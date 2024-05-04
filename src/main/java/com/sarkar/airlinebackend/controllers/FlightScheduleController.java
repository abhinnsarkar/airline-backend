package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import com.sarkar.airlinebackend.handlers.FlightSchedule.GetFlightSchedulesHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flight-schdule")
@Tag(name = "flight schedule", description = "Operations related to flight schedule etc")
public class FlightScheduleController {

    @Autowired
    GetFlightSchedulesHandler getFlightSchedulesHandler;
}
