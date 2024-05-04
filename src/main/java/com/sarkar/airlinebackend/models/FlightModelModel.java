package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "flight_model")
public class FlightModelModel {
    @Id
    @Column(name = "Flight Model")
    @Schema(description = "Flight Model Name", example = "Boeing 737")
    private String flightModelNameKey;;

    @Column(name = "Manufacturer Name")
    @Schema(description = "Manufacturer", example = "Boeing")
    private String manufacturer_name;;

    public FlightModelModel() {
    }
    public FlightModelModel(String flightModelNameKey, String manufacturer_name) {
        this.flightModelNameKey = flightModelNameKey;
        this.manufacturer_name = manufacturer_name;
    }

    public String getFlightModelNameKey() {
        return flightModelNameKey;
    }

    public void setFlightModelNameKey(String flightModelNameKey) {
        this.flightModelNameKey = flightModelNameKey;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }
}
