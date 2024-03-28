package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.AircraftModel;
import com.sarkar.airlinebackend.repositories.AircraftsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aircrafts")
@Tag(name = "aircrafts", description = "Operations related to aircrafts")
public class AircraftsEndpoint {

    @Autowired
    AircraftsRepository aircraftsRepository;

    @GetMapping()
    @Operation(summary = "Get all aircrafts", description = "Get a list of all aircrafts.")
    public List<AircraftModel> getAircrafts() {
        return aircraftsRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new aircraft", description = "Create a new aircraft.")
    public ResponseEntity<AircraftModel> postAircraft(@RequestBody AircraftModel aircraft) {
        AircraftModel savedAircraft = aircraftsRepository.save(aircraft);

        if (savedAircraft != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAircraft);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
