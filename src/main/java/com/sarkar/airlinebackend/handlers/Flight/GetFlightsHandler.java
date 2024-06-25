package com.sarkar.airlinebackend.handlers.Flight;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.models.FlightInfoDTO;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.services.business.Flight.GetFlightsBusinessService;
import com.sarkar.airlinebackend.services.business.FlightSchedule.AddFlightScheduleBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFlightsHandler {

    @Autowired
    GetFlightsBusinessService getFlightsBusinessService;

    public Response<List<FlightInfoDTO>> handle() {
        return getFlightsBusinessService.getAllFlights();
    }
}
