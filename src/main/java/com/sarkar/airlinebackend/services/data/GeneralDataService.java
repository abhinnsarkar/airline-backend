package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.SeatAllocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class GeneralDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }










    /**
     * Retrieves a list of UUIDs representing the seat numbers associated with a given flight number.
     *
     * @param  flightNumber  the number of the flight to retrieve seat numbers for
     * @return               a list of UUIDs representing the seat numbers
     */
    public Response<List<UUID>> getSeatsByFlightNumber(String flightNumber) {
        try {
            String sql = "SELECT model_seat.model_seat_id as model_seat_id " +
                    "FROM flight " +
                    "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key " +
                    "WHERE flight.flight_number = ?";

            RowMapper<UUID> mapper = (rs, rowNum) -> (UUID) rs.getObject("model_seat_id", UUID.class);

            List<UUID> queryResults = template.query(sql, mapper, flightNumber);

            var response = new Response<List<UUID>>();
            response.setData(queryResults);
            response.setReturnCode(ReturnCode.SUCCESS);
            response.addMessage("Seats retrieved successfully.");

            return response;

        } catch (Exception e) {

            var response = new Response<List<UUID>>();
            response.setData(null);
            response.setReturnCode(ReturnCode.ERROR);
            response.addMessage("Failed to retrieve seats: " + e.getMessage());
            return response;
        }
    }


}
