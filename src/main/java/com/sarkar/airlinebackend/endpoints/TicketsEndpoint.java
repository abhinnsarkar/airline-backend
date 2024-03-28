package com.sarkar.airlinebackend.endpoints;

import com.sarkar.airlinebackend.models.TicketModel;
import com.sarkar.airlinebackend.repositories.TicketsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tickets")
@Tag(name = "tickets", description = "Operations related to tickets")
public class TicketsEndpoint {

    @Autowired
    TicketsRepository ticketsRepository;

    @GetMapping()
    @Operation(summary = "Get all tickets", description = "Get a list of all tickets.")
    public List<TicketModel> getTickets(){
        return ticketsRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new ticket", description = "Create a new ticket.")
    public ResponseEntity<TicketModel> postTicket(@RequestBody TicketModel ticket) {
        ticket.setTicketId(UUID.randomUUID());

        TicketModel savedTicket = ticketsRepository.save(ticket);

        if (savedTicket != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
