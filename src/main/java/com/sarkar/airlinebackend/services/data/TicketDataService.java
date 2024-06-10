package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.TicketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class TicketDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<TicketModel> getAllTickets() {
        String sql = "SELECT * FROM public.ticket";

        RowMapper<TicketModel> mapper = new RowMapper<TicketModel>() {
            @Override
            public TicketModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                TicketModel ticketModel = new TicketModel();
                ticketModel.setTicketId((UUID) rs.getObject("ticket_id", UUID.class));
                ticketModel.setCustomerId((UUID) rs.getObject("customer_id", UUID.class));
                ticketModel.setFlightScheduleId((UUID) rs.getObject("flight_schedule_id", UUID.class));
                ticketModel.setSeatAllocationId((UUID) rs.getObject("seat_allocation_id", UUID.class));
                return ticketModel;
            }
        };

        return template.query(sql, mapper);
    }
}
