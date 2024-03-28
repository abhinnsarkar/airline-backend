package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class TicketModel {

    @Id
    @Column(name = "ticket_id")
    @Schema(description = "Ticket ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID ticketId;

    @Column(name = "ticket_number")
    @Schema(description = "Ticket Number", example = "T12345")
    private String ticketNumber;

    @Column(name = "seat_number")
    @Schema(description = "Seat Number", example = "A1")
    private String seatNumber;

    @Column(name = "seat_class")
    @Schema(description = "Seat Class", example = "Economy")
    private String seatClass;

    @Column(name = "customer_id")
    @Schema(description = "Customer ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID customerId;

    @Column(name = "customer_name")
    @Schema(description = "Customer Name", example = "John Doe")
    private String customerName;

    @Column(name = "booking_date_time")
    @Schema(description = "Booking Date Time", example = "2024-03-01")
    private Date bookingDateTime;

    @Column(name = "end_date_time")
    @Schema(description = "End Date Time", example = "2024-03-02")
    private Date endDateTime;

    @Column(name = "flight_id")
    @Schema(description = "Flight ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightId;

    // Constructors, getters, and setters

    public TicketModel() {
        // Default constructor
    }

    public TicketModel(UUID ticketId, String ticketNumber, String seatNumber, String seatClass, UUID customerId, String customerName, Date bookingDateTime, Date endDateTime, UUID flightId) {
        this.ticketId = ticketId;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.customerId = customerId;
        this.customerName = customerName;
        this.bookingDateTime = bookingDateTime;
        this.endDateTime = endDateTime;
        this.flightId = flightId;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(Date bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public UUID getFlightId() {
        return flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }
}
