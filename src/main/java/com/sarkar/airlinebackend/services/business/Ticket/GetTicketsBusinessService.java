package com.sarkar.airlinebackend.services.business.Ticket;

import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.TicketModel;
import com.sarkar.airlinebackend.services.data.CustomerDataService;
import com.sarkar.airlinebackend.services.data.TicketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTicketsBusinessService {

    @Autowired
    private TicketDataService ticketDataService;

    public List<TicketModel> getTickets() {

        return ticketDataService.getAllTickets();
    }

}
