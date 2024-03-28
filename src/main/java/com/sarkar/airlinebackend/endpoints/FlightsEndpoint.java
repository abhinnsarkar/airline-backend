package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.repositories.FlightsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/flights")
@Tag(name = "flights", description = "Operations related to flights")
public class FlightsEndpoint {

    @Autowired
    FlightsRepository flightsRepository;

    @GetMapping()
    @Operation(summary = "Get all flights", description = "Get a list of all flights.")
    public List<FlightModel> getCustomers(){
        return flightsRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new flight", description = "Create a new flight.")
    public ResponseEntity<FlightModel> postCustomer(@RequestBody FlightModel flight) {
        flight.setFlightId(UUID.randomUUID());

        FlightModel savedFlight = flightsRepository.save(flight);

        if (savedFlight != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
