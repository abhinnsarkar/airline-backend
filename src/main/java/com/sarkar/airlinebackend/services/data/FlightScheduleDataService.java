package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Repository
public class FlightScheduleDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }



    public FlightScheduleModel addFlightSchedule(UUID flightId, Date departureDate, Time departureTime) {

        var flightScheduleId = UUID.randomUUID();

        String sql = "INSERT INTO flight_schedule (flight_schedule_id, flight_id, departure_date, departure_time) VALUES (?, ?, ?, ?)";

        template.update(sql, flightScheduleId.toString(), flightId, departureDate, departureTime);
        return new FlightScheduleModel(flightScheduleId, flightId, departureDate, departureTime);
    }







    public UUID getFlightIdFromFlightScheduleId(UUID flightScheduleId) {

        String sql = "SELECT FROM flight_schedule WHERE flight_schedule_id = ?";

        RowMapper<FlightScheduleModel> mapper = new RowMapper<FlightScheduleModel>(){

            @Override
            public FlightScheduleModel mapRow(ResultSet rs, int rowNum) throws SQLException {

                FlightScheduleModel flightSchedule = new FlightScheduleModel();

                flightSchedule.setFlightScheduleId((UUID) rs.getObject("flight_schedule_id", UUID.class));
                flightSchedule.setFlightId((UUID) rs.getObject("flight_id", UUID.class));
                flightSchedule.setDepartureDate((Date) rs.getObject("departure_date", Date.class));
                flightSchedule.setDepartureTime((Time) rs.getObject("departure_time", Time.class));


                return flightSchedule;
            }

        };

        var flightSchedule = template.query(sql, mapper);

        return flightSchedule.getFirst().getFlightId();

    }

}
