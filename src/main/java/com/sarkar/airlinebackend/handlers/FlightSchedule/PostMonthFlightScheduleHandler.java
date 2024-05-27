package com.sarkar.airlinebackend.handlers.FlightSchedule;

import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.services.business.FlightSchedule.AddFlightScheduleBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostMonthFlightScheduleHandler {

    @Autowired
    AddFlightScheduleBusinessService addFlightScheduleBusinessService;


    public List<FlightScheduleModel> handle(String flightNumber, Integer month, Integer year) {
        return addFlightScheduleBusinessService.addFlightSchedule(flightNumber, month, year);


    }

}
