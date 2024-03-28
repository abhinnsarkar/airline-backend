package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "flights")
public class FlightModel {

    @Id
    @Column(name = "flight_id")
    @Schema(description = "Flight ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightId;;

    @Column(name = "flight_number")
    @Schema(description = "Flight Number", example = "12345")
    private String flightNumber;

    @Column(name = "route_id")
    @Schema(description = "Route Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID routeId;;

    @Column(name = "flight_model")
    @Schema(description = "Flight Model", example = "Boeing")
    private String flightModel;

    @Column(name = "departure_date")
    @Schema(description = "Departure Date", example = "2005-03-15")
    private java.sql.Date departureDate;

    @Column(name = "departure_time")
    @Schema(description = "Departure Time", example = "15:30:00")
    private java.sql.Time departureTime;


    // Constructors, getters, and setters

    public FlightModel() {
        // Default constructor
    }

    public FlightModel(UUID flightId, String flightNumber, UUID routeId, String flightModel, Date departureDate, Time departureTime) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.flightModel = flightModel;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
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

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}
