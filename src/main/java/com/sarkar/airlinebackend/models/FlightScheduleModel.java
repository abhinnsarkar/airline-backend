// ADJUSTED FOR DDL2
package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "Flight Schedule")
public class FlightScheduleModel {

    @Id
    @Column(name = "flight_schedule_id")
    @Schema(description = "Flight Schedule ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightScheduleId;

    @Column(name = "flight_id")
    @Schema(description = "Flight Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightId;

    @Column(name = "departure_date")
    @Schema(description = "Departure Date", example = "2005-03-15")
    private java.sql.Date departureDate;

    @Column(name = "departure_time")
    @Schema(description = "Departure Time", example = "15:30:00")
    private java.sql.Time departureTime;

    public FlightScheduleModel() {
    }

    public FlightScheduleModel(UUID flightScheduleId, UUID flightId, Date departureDate, Time departureTime) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public UUID getFlightScheduleId() {
        return flightScheduleId;
    }

    public void setFlightScheduleId(UUID flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
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
