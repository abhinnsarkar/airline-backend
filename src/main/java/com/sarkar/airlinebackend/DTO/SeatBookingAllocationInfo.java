package com.sarkar.airlinebackend.DTO;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public class SeatBookingAllocationInfo {

//    @Schema(description = "Seat Allocation ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID seatAllocationId;

//    @Schema(description = "Flight Schedule ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightScheduleId;

//    @Schema(description = "Model Seat ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID modelSeatId;

//    @Schema(description = "Available Seat", example = "true")
    private boolean available;

//    @Schema(description = "Seat Number", example = "A1")
    private String seatNumber;

//    @Schema(description = "Seat Class", example = "Economy")
    private String seatClass;

//    @Schema(description = "Flight Model Name", example = "Boeing 737")
    private String flightModelNameKey;

    public SeatBookingAllocationInfo() {
    }

    // Getters and setters
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getFlightModelNameKey() {
        return flightModelNameKey;
    }

    public void setFlightModelNameKey(String flightModelNameKey) {
        this.flightModelNameKey = flightModelNameKey;
    }
}

