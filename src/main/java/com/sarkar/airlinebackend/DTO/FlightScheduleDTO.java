package com.sarkar.airlinebackend.DTO;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class FlightScheduleDTO {

    private UUID flightScheduleId;
    private UUID flightId;
    private java.sql.Date departureDate;
    private String flightNumber;
    private String flightModelNameKey;
    private UUID routeId;
    private String originAirportCode;
    private String departureLocation;
    private String destinationAirportCode;
    private String destinationLocation;
    private List<SeatBookingAllocationInfo> seats;

    public FlightScheduleDTO() {
    }

    public FlightScheduleDTO(UUID flightScheduleId, UUID flightId, Date departureDate, String flightNumber, String flightModelNameKey, UUID routeId, String originAirportCode, String departureLocation, String destinationAirportCode, String destinationLocation, List<SeatBookingAllocationInfo> seats) {
        this.flightScheduleId = flightScheduleId;
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.flightNumber = flightNumber;
        this.flightModelNameKey = flightModelNameKey;
        this.routeId = routeId;
        this.originAirportCode = originAirportCode;
        this.departureLocation = departureLocation;
        this.destinationAirportCode = destinationAirportCode;
        this.destinationLocation = destinationLocation;
        this.seats = seats;
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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public List<SeatBookingAllocationInfo> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatBookingAllocationInfo> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "FlightScheduleDTO{" +
                "flightScheduleId=" + flightScheduleId +
                ", flightId=" + flightId +
                ", departureDate=" + departureDate +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightModelNameKey='" + flightModelNameKey + '\'' +
                ", routeId=" + routeId +
                ", originAirportCode='" + originAirportCode + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", seats=" + seats +
                '}';
    }
}
