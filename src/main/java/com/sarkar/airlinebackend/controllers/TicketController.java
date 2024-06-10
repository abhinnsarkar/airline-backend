package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.Ticket.GetTicketsHandler;
import com.sarkar.airlinebackend.models.TicketModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ticket")
@Tag(name = "ticket", description = "Operations related to tickets")
public class TicketController {

    @Autowired
    private GetTicketsHandler getTicketsHandler;

    @GetMapping(value = "")
    public List<TicketModel> getTickets() {
        return getTicketsHandler.handle();
    }

//    TODO Add ticket booking
}


