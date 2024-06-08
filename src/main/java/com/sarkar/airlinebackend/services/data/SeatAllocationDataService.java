package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class SeatAllocationDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }



    @Transactional(rollbackFor = Exception.class)
    public Response<Boolean> insertSeatAllocations(List<SeatAllocationModel> seatAllocationModels) {

        Response<Boolean> response = new Response<>();
        var shouldUpdateThisManyTimes = seatAllocationModels.size();
        var insertCount = 0;

        try {
            for (SeatAllocationModel seatAllocationModel : seatAllocationModels) {

                String sql = "INSERT INTO seat_allocation (seat_allocation_id, flight_schedule_id, model_seat_id, available) VALUES (?, ?, ?, ?)";

                var result = template.update(sql,
                        seatAllocationModel.getSeatAllocationId(),
                        seatAllocationModel.getFlightScheduleId(),
                        seatAllocationModel.getModelSeatId(),
                        seatAllocationModel.isAvailable());

                if (result == 0) {

                    response.setData(false);
                    response.setReturnCode(ReturnCode.ERROR);
                    response.addMessage("Failed to insert seat allocation for one or more records.");
                    return response;
                }

                insertCount++;
            }


            if (insertCount == shouldUpdateThisManyTimes) {
                response.setData(true);
                response.setReturnCode(ReturnCode.SUCCESS);
                response.addMessage("All seat allocations inserted successfully.");
            } else {
                response.setData(false);
                response.setReturnCode(ReturnCode.WARNING);
                response.addMessage("Not all seat allocations were inserted successfully.");
            }

            return response;


        } catch (Exception e) {
            response.setData(false);
            response.setReturnCode(ReturnCode.ERROR);
            response.addMessage("Failed to set seats to available for flight schedule: " + e.getMessage());
            return response;
        }
    }



}
