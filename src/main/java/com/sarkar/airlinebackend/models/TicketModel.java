package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "Ticket")
public class TicketModel {

    @Id
    @Column(name = "ticket_id")
    @Schema(description = "Ticket ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID ticketId;

    @Column(name = "customer_id")
    @Schema(description = "Customer ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID customerId;

    @Column(name = "flight_schedule_id")
    @Schema(description = "Flight Schedule Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID flightScheduleId;

    @Column(name = "seat_allocation_id")
    @Schema(description = "Seat Allocation Id", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID seatAllocationId;

    public TicketModel() {
    }

    public TicketModel(UUID ticketId, UUID customerId, UUID flightScheduleId, UUID seatAllocationId) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.flightScheduleId = flightScheduleId;
        this.seatAllocationId = seatAllocationId;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getFlightScheduleId() {
        return flightScheduleId;
    }

    public void setFlightScheduleId(UUID flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    public UUID getSeatAllocationId() {
        return seatAllocationId;
    }

    public void setSeatAllocationId(UUID seatAllocationId) {
        this.seatAllocationId = seatAllocationId;
    }
}
