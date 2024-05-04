package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Model Seat")
public class ModelSeatModel {

    @Id
    @Column(name = "Model Seat Id")
    @Schema(description = "Model Seat ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID modelSeatId;

    @Column(name = "Seat Number")
    @Schema(description = "Seat Number", example = "A1")
    private String seatNumber;

    @Column(name = "Seat Class")
    @Schema(description = "Seat Class", example = "Economy")
    private String seatClass;

    @Column(name = "Flight Model")
    @Schema(description = "Flight Model Name", example = "Boeing 737")
    private String flightModelNameKey;;

    public ModelSeatModel(String model){

    }

    public ModelSeatModel(UUID modelSeatId, String seatNumber, String seatClass, String flightModelNameKey) {
        this.modelSeatId = modelSeatId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.flightModelNameKey = flightModelNameKey;
    }

    public UUID getModelSeatId() {
        return modelSeatId;
    }

    public void setModelSeatId(UUID modelSeatId) {
        this.modelSeatId = modelSeatId;
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
