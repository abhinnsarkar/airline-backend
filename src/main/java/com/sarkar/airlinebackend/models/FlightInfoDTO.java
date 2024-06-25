package com.sarkar.airlinebackend.models;

import java.util.List;
import java.util.UUID;

public class FlightInfoDTO {

    private UUID flightId;
    private String flightNumber;
    private String flightModelNameKey;
    private UUID routeId;
    private String originAirportCode;
    private String destinationAirportCode;
    private List<ModelSeatModel> seats;

    public FlightInfoDTO() {
    }

    public FlightInfoDTO(UUID flightId, String flightNumber, String flightModelNameKey, UUID routeId, String originAirportCode, String destinationAirportCode, List<ModelSeatModel> seats) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightModelNameKey = flightModelNameKey;
        this.routeId = routeId;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.seats = seats;
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

    public String getFlightModelNameKey() {
        return flightModelNameKey;
    }

    public void setFlightModelNameKey(String flightModelNameKey) {
        this.flightModelNameKey = flightModelNameKey;
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

    public List<ModelSeatModel> getSeats() {
        return seats;
    }

    public void setSeats(List<ModelSeatModel> seats) {
        this.seats = seats;
    }
}
