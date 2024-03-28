package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.RouteModel;
import com.sarkar.airlinebackend.repositories.RoutesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/routes")
@Tag(name = "routes", description = "Operations related to routes")
public class RoutesEndpoint {

    @Autowired
    RoutesRepository routesRepository;

    @GetMapping()
    @Operation(summary = "Get all routes", description = "Get a list of all routes.")
    public List<RouteModel> getRoutes(){
        return routesRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new route", description = "Create a new route.")
    public ResponseEntity<RouteModel> postRoute(@RequestBody RouteModel route) {
        route.setRouteId(UUID.randomUUID());

        RouteModel savedRoute = routesRepository.save(route);

        if (savedRoute != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRoute);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
