package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class SeatAllocationDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }



    public SeatAllocationModel setSeatToAvailable(UUID flightScheduleId, UUID modelSeatId) {

        var seatAllocationId = UUID.randomUUID();

        String sql = "INSERT INTO seat_allocation (seat_allocation_id, flight_schedule_id, model_seat_id, available) VALUES (?, ?, ?, true)";

        template.update(sql, seatAllocationId.toString(), flightScheduleId.toString(), modelSeatId);
        return new SeatAllocationModel(seatAllocationId, flightScheduleId, modelSeatId, true);
    }


}
