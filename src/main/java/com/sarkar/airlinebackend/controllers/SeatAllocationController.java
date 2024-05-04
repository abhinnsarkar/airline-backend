package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.FlightModel.GetFlightModelsHandler;
import com.sarkar.airlinebackend.handlers.ModelSeat.GetModelSeatsHandler;
import com.sarkar.airlinebackend.handlers.SeatAllocation.GetSeatAllocationsHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seat-allocation")
@Tag(name = "model seat", description = "Operations related to seat allocations")
public class SeatAllocationController {

    @Autowired
    GetSeatAllocationsHandler getSeatAllocationsHandler;
}
