package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Route")
public class RouteModel {

    @Id
    @Column(name = "route_id")
    @Schema(description = "Route ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID routeId;

    @Column(name = "origin_airport_code")
    @Schema(description = "Origin Airport Code", example = "YVR")
    private String originAirportCode;

    @Column(name = "destination_airport_code")
    @Schema(description = "Destination Airport Code", example = "LAX")
    private String destinationAirportCode;

    // Constructors, getters, and setters

    public RouteModel() {
        // Default constructor
    }

    public RouteModel(UUID routeId, String originAirportCode, String destinationAirportCode) {
        this.routeId = routeId;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    public UUID getRouteId() {
        return routeId;
    }

    public void setRouteId(UUID routeId) {
        this.routeId = routeId;
    }

    public String getOriginAirportCode() {
        return originAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }
}
