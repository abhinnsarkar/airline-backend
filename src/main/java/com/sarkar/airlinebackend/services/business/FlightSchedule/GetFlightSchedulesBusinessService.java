package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.DTO.FlightScheduleDTO;
import com.sarkar.airlinebackend.DTO.FlightSchedulesAndSeatDTO;
import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.services.data.GeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFlightSchedulesBusinessService {

    @Autowired
    private GeneralDataService generalDataService;

    public Response<List<String>> getAirportCodeForLocation(String location) {

        return generalDataService.getAirportCodeForLocation(location);
    }


    public Response<List<FlightScheduleDTO>> getFlightSchedulesByLocationsAndDate(String departureLocation, String destinationLocation, String departureDate) {

        System.out.println("in the business service");

        String departureAirportCode = this.getAirportCodeForLocation(departureLocation).getData().get(0);
        String destinationAirportCode = this.getAirportCodeForLocation(destinationLocation).getData().get(0);

        var allFlights = this.generalDataService.getFlightSchedulesByLocationsAndDate(departureAirportCode, destinationAirportCode, departureDate);

        return allFlights;
    }

//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByDestinationLocation() {
//
//        var allFlights = this.generalDataService.getFlightSchedulesByDestinationAirportCode();
//
//        return allFlights;
//    }
//
//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByDepartureDate() {
//
//        var allFlights = this.generalDataService.getFlightSchedulesByDepartureDate();
//
//        return allFlights;
//    }
//
//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByLocationDate() {
//
//        var allFlights = this.generalDataService.getFlightSchedulesByLocationAndDate();
//
//        return allFlights;
//    }

}
