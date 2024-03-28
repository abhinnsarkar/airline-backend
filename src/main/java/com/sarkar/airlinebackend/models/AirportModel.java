package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class AirportModel {

    @Id
    @Schema(description = "Airport Code", example = "YYZ")
    private String airportCode;

    @Schema(description = "City Name", example = "Toronto")
    private String cityName;

    @Schema(description = "State/Province Name", example = "Ontario")
    private String stateProvinceName;

    @Schema(description = "Country Name", example = "Canada")
    private String countryName;

    // Constructors, getters, and setters

    public AirportModel() {
        // Default constructor
    }

    public AirportModel(String airportCode, String cityName, String stateProvinceName, String countryName) {
        this.airportCode = airportCode;
        this.cityName = cityName;
        this.stateProvinceName = stateProvinceName;
        this.countryName = countryName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateProvinceName() {
        return stateProvinceName;
    }

    public void setStateProvinceName(String stateProvinceName) {
        this.stateProvinceName = stateProvinceName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
