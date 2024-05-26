package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import com.sarkar.airlinebackend.handlers.FlightSchedule.GetFlightSchedulesHandler;
import com.sarkar.airlinebackend.handlers.FlightSchedule.PostMonthFlightScheduleHandler;
import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/flight-schedule")
@Tag(name = "flight schedule", description = "Operations related to flight schedule etc")
public class FlightScheduleController {

    @Autowired
    GetFlightSchedulesHandler getFlightSchedulesHandler;
    @Autowired
    PostMonthFlightScheduleHandler postMonthFlightScheduleHandler;

    @PostMapping(value = "/month")
    @Operation(summary = "add a flight schedule for every day of the month based on provided flight number and month")
    public List<FlightScheduleModel> addMonthlySchedule(@RequestParam String flightNumber, @RequestParam @Min(value = 1, message = "Minimum value is 1") @Max(value = 12, message = "Maximum value is 12") int month) {

        return postMonthFlightScheduleHandler.handle(flightNumber, "5");

    }
}
