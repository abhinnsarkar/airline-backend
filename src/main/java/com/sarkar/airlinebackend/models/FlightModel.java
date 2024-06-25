package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "flight")
public class FlightModel {

    @Id
    @Column(name = "flight_id")
    @Schema(description = "Flight ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightId;

    @Column(name = "flight_number")
    @Schema(description = "Flight Number", example = "AS105")
    private String flightNumber;

    @Column(name = "route_id")
    @Schema(description = "Route ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID routeId;

    @Column(name = "flight_model_name_key")
    @Schema(description = "Flight Model Name", example = "Boeing 737")
    private String flightModelNameKey;

    public FlightModel() {
    }

    public FlightModel(UUID flightId, String flightNumber, UUID routeId, String flightModelNameKey) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.flightModelNameKey = flightModelNameKey;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public UUID getRouteId() {
        return routeId;
    }

    public void setRouteId(UUID routeId) {
        this.routeId = routeId;
    }

    public String getFlightModelNameKey() {
        return flightModelNameKey;
    }

    public void setFlightModelNameKey(String flightModelNameKey) {
        this.flightModelNameKey = flightModelNameKey;
    }
}
