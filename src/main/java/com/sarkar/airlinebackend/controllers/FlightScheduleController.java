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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @Validated
    @Operation(summary = "add a flight schedule for every day of the month based on provided flight number and month and year")
    public List<FlightScheduleModel> addMonthlySchedule
            (@RequestParam String flightNumber,
             @RequestParam
             @Min(value = 1, message = "Minimum month is 1")
             @Max(value = 12, message = "Maximum month is 12")
             int month,
             @RequestParam
             @Max(value = 9999, message = "Maximum year is 9999")
             int year
             ) {

        int currentYear = LocalDate.now().getYear();

        if (year < currentYear || year > 9999) {
            throw new IllegalArgumentException("Year must be between " + currentYear + " and 9999.");
        }

        return postMonthFlightScheduleHandler.handle(flightNumber, month, year);

    }
}
