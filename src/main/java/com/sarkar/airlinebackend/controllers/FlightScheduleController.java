package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.DTO.FlightScheduleDTO;
import com.sarkar.airlinebackend.DTO.FlightSchedulesAndSeatDTO;
import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.handlers.FlightSchedule.GetFlightSchedulesHandler;
import com.sarkar.airlinebackend.handlers.FlightSchedule.PostMonthFlightScheduleHandler;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(value = "/flight-schedule")
@Tag(name = "flight schedule", description = "Operations related to flight schedule etc")
public class FlightScheduleController {

    @Autowired
    GetFlightSchedulesHandler getFlightSchedulesHandler;
    @Autowired
    PostMonthFlightScheduleHandler postMonthFlightScheduleHandler;









    @GetMapping()
    @Operation(summary = "fetches all the flight schedules")
    public ResponseEntity<Response<List<FlightScheduleDTO>>> getAllFlightSchedules
            (@RequestParam(required = false) String departureLocation,
             @RequestParam(required = false) String destinationLocation,
             @RequestParam(required = false) String departureMonth, //expecting to come in string format as a number ie: 5
             @RequestParam(required = false) String departureDay,
             @RequestParam(required = false) String departureYear) {





        if (departureMonth == null) {
            departureMonth = String.valueOf(new java.sql.Date(System.currentTimeMillis()).toLocalDate().getMonthValue());
        }
        if (departureDay == null) {
            departureDay = String.valueOf(new java.sql.Date(System.currentTimeMillis()).toLocalDate().getDayOfMonth());
        }
        if (departureYear == null) {
            departureYear = String.valueOf(new java.sql.Date(System.currentTimeMillis()).toLocalDate().getYear());
        }

        int currentYear = LocalDate.now().getYear();

        if (parseInt(departureYear) < currentYear || parseInt(departureYear) > 9999) {
            throw new IllegalArgumentException("Year must be between " + currentYear + " and 9999.");
        }

        String departureDate = java.sql.Date.valueOf(String.format("%s-%s-%s", departureYear, departureMonth, departureDay)).toString();







        var result = getFlightSchedulesHandler.handle(departureLocation, destinationLocation, departureDate);

        System.out.println(result.getMessages());

        HttpStatus httpStatus = result.getReturnCode() == ReturnCode.SUCCESS ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        System.out.println("Result from controller : " + result.getData());

        return ResponseEntity.status(httpStatus).body(result);

    }





















    @PostMapping(value = "/month")
    @Validated
    @Operation(summary = "add a flight schedule for every day of the month based on provided flight number and month and year")
    public ResponseEntity<Response<List<FlightScheduleModel>>> addMonthlySchedule
            (@RequestParam String flightNumber,
             @RequestParam
             @Min(value = 1, message = "Minimum month is 1")
             @Max(value = 12, message = "Maximum month is 12")
             int month,
             @RequestParam
             @Max(value = 9999, message = "Maximum year is 9999")
             int year,
             @RequestParam
             @Min(value = 0, message = "Minimum hour is 0")
             @Max(value = 23, message = "Maximum month is 23")
             int hour,
             @RequestParam
             @Min(value = 1, message = "Minimum minute is 1")
             @Max(value = 59, message = "Maximum minute is 59")
             int minute
             ) {

        int currentYear = LocalDate.now().getYear();

        if (year < currentYear || year > 9999) {
            throw new IllegalArgumentException("Year must be between " + currentYear + " and 9999.");
        }

        var result = postMonthFlightScheduleHandler.handle(flightNumber, month, year, hour, minute);

        HttpStatus httpStatus = result.getReturnCode() == ReturnCode.SUCCESS ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        Response<List<FlightScheduleModel>> response = new Response<>();
        response.setData(result.getData());
        response.setReturnCode(result.getReturnCode());
        response.setMessages(result.getMessages()); // Assuming only one message is set

        return ResponseEntity.status(httpStatus).body(response);

    }
}
