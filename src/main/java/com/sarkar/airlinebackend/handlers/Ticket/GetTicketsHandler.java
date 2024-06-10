package com.sarkar.airlinebackend.handlers.Ticket;

import com.sarkar.airlinebackend.models.TicketModel;
import com.sarkar.airlinebackend.services.business.Ticket.GetTicketsBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTicketsHandler {

    @Autowired
    private GetTicketsBusinessService getTicketsBusinessService;
    public List<TicketModel> handle() {
        return getTicketsBusinessService.getTickets();
    }
}
