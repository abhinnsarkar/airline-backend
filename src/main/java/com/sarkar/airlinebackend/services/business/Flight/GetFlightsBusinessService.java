package com.sarkar.airlinebackend.services.business.Flight;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.DTO.FlightInfoDTO;
import com.sarkar.airlinebackend.services.data.FlightDataService;
import com.sarkar.airlinebackend.services.data.GeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
