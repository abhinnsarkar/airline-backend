package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.CustomerModel;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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



//    public Boolean addFlightSchedule(FlightScheduleModel flightScheduleModel) {
//
//        String sql = "INSERT INTO flight_schedule (flight_schedule_id, flight_id, departure_date, departure_time) VALUES (?, ?, ?, ?)";
//
//        var result = template.update(sql,
//                flightScheduleModel.getFlightScheduleId(),
//                flightScheduleModel.getFlightId(),
//                flightScheduleModel.getDepartureDate(),
//                flightScheduleModel.getDepartureTime());
//
//        if (result > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }



    public Response<Boolean> addFlightSchedule(FlightScheduleModel flightScheduleModel) {
        String sql = "INSERT INTO flight_schedule (flight_schedule_id, flight_id, departure_date, departure_time) VALUES (?, ?, ?, ?)";

        try {
            var result = template.update(sql,
                    flightScheduleModel.getFlightScheduleId(),
                    flightScheduleModel.getFlightId(),
                    flightScheduleModel.getDepartureDate(),
                    flightScheduleModel.getDepartureTime());

            var response = new Response<Boolean>();

            if (result > 0){
                response.setReturnCode(ReturnCode.SUCCESS);
                response.setData(true);
                response.addMessage("Flight schedule added successfully.");
                return response;
            }
            else{
                response.setReturnCode(ReturnCode.ERROR);
                response.setData(false);
                response.addMessage("Failed to add flight schedule");
                return response;
            }


        } catch (DataIntegrityViolationException e) {
            // Check if it's a unique constraint violation
            if (e.getCause() != null && e.getCause().getMessage().contains("unique_flight_schedule_constraint")) {
                var response = new Response<Boolean>();
                response.setReturnCode(ReturnCode.ERROR);
                response.setData(false);
                response.addMessage("Flight schedule already exists.");
                return response;
            }
//            throw new RuntimeException("Failed to add flight schedule.", e); // Throw a custom exception if it's not a unique constraint violation
            var response = new Response<Boolean>();
            response.setReturnCode(ReturnCode.ERROR);
            response.setData(false);
            response.addMessage("Flight schedule failed to add due to some internal error." + e.getMessage());
            return response;
        }
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

        var flightSchedule = template.query(sql, mapper, flightScheduleId.toString());

        return flightSchedule.getFirst().getFlightId();

    }

}
