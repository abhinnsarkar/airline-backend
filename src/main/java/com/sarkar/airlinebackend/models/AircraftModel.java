package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircrafts")
public class AircraftModel {

    @Id
    @Column(name = "model")
    @Schema(description = "Aircraft Model", example = "Boeing 737")
    private String model;

    @Column(name = "aircraft_capacity")
    @Schema(description = "Aircraft Capacity", example = "150")
    private int aircraftCapacity;

    // Constructors, getters, and setters

    public AircraftModel() {
        // Default constructor
    }

    public AircraftModel(String model, int aircraftCapacity) {
        this.model = model;
        this.aircraftCapacity = aircraftCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAircraftCapacity() {
        return aircraftCapacity;
    }

    public void setAircraftCapacity(int aircraftCapacity) {
        this.aircraftCapacity = aircraftCapacity;
    }
}
