package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.AirportModel;
import com.sarkar.airlinebackend.repositories.AirportsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airports")
@Tag(name = "airports", description = "Operations related to airports")
public class AirportsEndpoint {

    @Autowired
    AirportsRepository airportsRepository;

    @GetMapping()
    @Operation(summary = "Get all airports", description = "Get a list of all airports.")
    public List<AirportModel> getAirports(){
        return airportsRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new airport", description = "Create a new airport.")
    public ResponseEntity<AirportModel> postAirport(@RequestBody AirportModel airport) {
        AirportModel savedAirport = airportsRepository.save(airport);

        if (savedAirport != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAirport);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
