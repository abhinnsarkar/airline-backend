package com.sarkar.airlinebackend.services.data;

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
    public Boolean insertSeatAllocations(List<SeatAllocationModel> seatAllocationModels) {


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

                if (result == 0) return false;

                insertCount++;
            }


            if (insertCount == shouldUpdateThisManyTimes) {
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {
            throw new RuntimeException("Failed to set seats to available for flight schedule", e);
        }
    }



}
