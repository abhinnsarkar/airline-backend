package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.CustomerModel;
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

}
