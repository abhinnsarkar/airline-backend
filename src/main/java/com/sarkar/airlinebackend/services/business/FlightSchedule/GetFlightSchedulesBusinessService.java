package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.services.data.FlightDataService;
import com.sarkar.airlinebackend.services.data.FlightScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFlightSchedulesBusinessService {

    @Autowired
    private FlightScheduleDataService flightScheduleDataService;


//    public List<FlightScheduleModel> getFlightSchedulesByFlightNumberAndDate(String flightNumber) {
//        return flightScheduleDataService.;
//    }

}
