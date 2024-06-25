package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
     * @param flightNumber the number of the flight to retrieve seat numbers for
     * @return a list of UUIDs representing the seat numbers
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


    public Response<List<FlightInfoDTO>> getAllFlightsInfo() {

        String sql = "SELECT " +
                "flight.flight_id as flight_id, " +
                "flight.flight_number as flight_number, " +
                "flight.flight_model_name_key as flight_model_name_key, " +
                "flight.route_id as route_id, " +
                "route.origin_airport_code as origin_airport_code, " +
                "route.destination_airport_code as destination_airport_code, " +
                "model_seat.model_seat_id AS model_seat_id, " +
                "model_seat.seat_number AS seat_number, " +
                "model_seat.seat_class AS seat_class " +
                "FROM flight " +
                "JOIN route ON flight.route_id = route.route_id " + // Added space at the end
                "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key";

        Map<UUID, FlightInfoDTO> flightMap = new HashMap<>();

        RowMapper<FlightInfoDTO> mapper = new RowMapper<FlightInfoDTO>() {
            @Override
            public FlightInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UUID flightId = (UUID) rs.getObject("flight_id", UUID.class);
                FlightInfoDTO flightInfo = flightMap.get(flightId);
                if (flightInfo == null) {
                    flightInfo = new FlightInfoDTO();
                    flightInfo.setFlightId(flightId);
                    flightInfo.setFlightNumber(rs.getString("flight_number"));
                    flightInfo.setFlightModelNameKey(rs.getString("flight_model_name_key"));
                    flightInfo.setRouteId((UUID) rs.getObject("route_id", UUID.class));
                    flightInfo.setOriginAirportCode(rs.getString("origin_airport_code"));
                    flightInfo.setDestinationAirportCode(rs.getString("destination_airport_code"));
                    flightInfo.setSeats(new ArrayList<>());
                    flightMap.put(flightId, flightInfo);
                }

                ModelSeatModel seat = new ModelSeatModel();
                seat.setModelSeatId((UUID) rs.getObject("model_seat_id", UUID.class));
                seat.setSeatNumber(rs.getString("seat_number"));
                seat.setSeatClass(rs.getString("seat_class"));
                seat.setFlightModelNameKey(rs.getString("flight_model_name_key"));

                flightInfo.getSeats().add(seat);

                return flightInfo;
            }
        };

        Response<List<FlightInfoDTO>> response = new Response<>();

        try {
            List<FlightInfoDTO> flightsInfo = template.query(sql, mapper);
            response.setReturnCode(ReturnCode.SUCCESS);
            response.setData(new ArrayList<>(flightMap.values()));
            response.addMessage("Flights fetched successfully.");
        } catch (DataAccessException e) {
            response.setReturnCode(ReturnCode.ERROR);
            response.setData(null);
            response.addMessage("Failed to fetch flights: " + e.getMessage());
        }

        return response;
    }

}
