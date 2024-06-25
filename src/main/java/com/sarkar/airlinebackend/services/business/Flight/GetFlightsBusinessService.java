package com.sarkar.airlinebackend.services.business.Flight;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.FlightInfoDTO;
import com.sarkar.airlinebackend.models.FlightModel;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.services.data.FlightDataService;
import com.sarkar.airlinebackend.services.data.GeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetFlightsBusinessService {

    @Autowired
    private FlightDataService flightDataService;

    @Autowired
    private GeneralDataService generalDataService;

    public Response<List<FlightInfoDTO>> getAllFlights() {

        var allFlights = this.generalDataService.getAllFlightsInfo();

        return allFlights;
    }
}
