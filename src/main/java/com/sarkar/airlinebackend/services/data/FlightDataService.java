package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.FlightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class FlightDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<FlightModel> getFlightByNumber(String flightNumber) {

        String sql = "SELECT * FROM flight WHERE flight_number = ?";

        RowMapper<FlightModel> mapper = new RowMapper<FlightModel>(){

            @Override
            public FlightModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                FlightModel flight = new FlightModel();

                flight.setFlightId((UUID) rs.getObject("flight_id", UUID.class));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setRouteId((UUID) rs.getObject("route_id", UUID.class));
                flight.setFlightModelNameKey(rs.getString("flight_model_name_key"));

                return flight;
            }

        };

        return template.query(sql, mapper, flightNumber);

    }

    public String getModelNameKeyFromFlightId(UUID flightId) {

        String sql = "SELECT flight_model_name_key FROM flight WHERE flight_id = ?";

        RowMapper<FlightModel> mapper = new RowMapper<FlightModel>(){

            @Override
            public FlightModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                FlightModel flight = new FlightModel();

                flight.setFlightId((UUID) rs.getObject("flight_id", UUID.class));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setRouteId((UUID) rs.getObject("route_id", UUID.class));
                flight.setFlightModelNameKey(rs.getString("flight_model_name_key"));

                return flight;
            }

        };

        var flight = template.query(sql, mapper);

        return flight.getFirst().getFlightModelNameKey();
    }
}
