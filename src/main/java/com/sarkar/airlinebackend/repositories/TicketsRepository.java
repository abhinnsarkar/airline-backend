package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.TicketModel;

import java.util.List;
import java.util.UUID;

public interface TicketsRepository extends JpaRepository<TicketModel, UUID> {

    List<TicketModel> findByTicketNumber(String ticketNumber);

    List<TicketModel> findByCustomerId(UUID customerId);

    List<TicketModel> findByFlightId(UUID flightId);

    // You can add more query methods based on your requirements
}
