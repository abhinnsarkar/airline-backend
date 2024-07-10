package com.sarkar.airlinebackend.DTO;

import java.sql.Date;
import java.util.UUID;

public class FlightSchedulesAndSeatDTO {

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
    private UUID modelSeatId;
    private String seatNumber;
    private String seatClass;
    private UUID seatAllocationId;
    private Boolean seatAvailable;

    public FlightSchedulesAndSeatDTO() {
    }

    public FlightSchedulesAndSeatDTO(UUID flightScheduleId, UUID flightId, Date departureDate, String flightNumber, String flightModelNameKey, UUID routeId, String originAirportCode, String departureLocation, String destinationAirportCode, String destinationLocation, UUID modelSeatId, String seatNumber, String seatClass, UUID seatAllocationId, Boolean seatAvailable) {
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
        this.modelSeatId = modelSeatId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatAllocationId = seatAllocationId;
        this.seatAvailable = seatAvailable;
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

    public UUID getSeatAllocationId() {
        return seatAllocationId;
    }

    public void setSeatAllocationId(UUID seatAllocationId) {
        this.seatAllocationId = seatAllocationId;
    }

    public Boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(Boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }
}
