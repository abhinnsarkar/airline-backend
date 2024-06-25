package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.handlers.Flight.GetFlightsHandler;
import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import com.sarkar.airlinebackend.models.FlightInfoDTO;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/flight")
@Tag(name = "flight", description = "Operations related to flight info")
public class FlightController {

    @Autowired
    GetFlightsHandler getFlightsHandler;

    @GetMapping(value = "")
    public ResponseEntity<Response<List<FlightInfoDTO>>> getAllFlights() {
        var result = getFlightsHandler.handle();

        HttpStatus httpStatus = result.getReturnCode() == ReturnCode.SUCCESS ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        Response<List<FlightInfoDTO>> response = new Response<>();
        response.setData(result.getData());
        response.setReturnCode(result.getReturnCode());
        response.setMessages(result.getMessages()); // Assuming only one message is set

        return ResponseEntity.status(httpStatus).body(response);
    }
}
