// ADJUSTED FOR DDL2
package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "seat_allocation")
public class SeatAllocationModel {

    @Id
    @Column(name = "seat_allocation_id")
    @Schema(description = "Seat Allocation Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID seatAllocationId;;

    @Column(name = "flight_schedule_id")
    @Schema(description = "Flight Schedule ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightScheduleId;

    @Column(name = "model_seat_id")
    @Schema(description = "Model Seat Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID modelSeatId;

    @Column(name = "available")
    @Schema(description = "Available Seat", example = "True")
    private boolean available;

    public SeatAllocationModel() {
    }

    public SeatAllocationModel(UUID seatAllocationId, UUID flightScheduleId, UUID modelSeatId, boolean available) {
        this.seatAllocationId = seatAllocationId;
        this.flightScheduleId = flightScheduleId;
        this.modelSeatId = modelSeatId;
        this.available = available;
    }

    public UUID getSeatAllocationId() {
        return seatAllocationId;
    }

    public void setSeatAllocationId(UUID seatAllocationId) {
        this.seatAllocationId = seatAllocationId;
    }

    public UUID getFlightScheduleId() {
        return flightScheduleId;
    }

    public void setFlightScheduleId(UUID flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    public UUID getModelSeatId() {
        return modelSeatId;
    }

    public void setModelSeatId(UUID modelSeatId) {
        this.modelSeatId = modelSeatId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
