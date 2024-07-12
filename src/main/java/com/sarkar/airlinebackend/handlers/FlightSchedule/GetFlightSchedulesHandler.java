package com.sarkar.airlinebackend.handlers.FlightSchedule;

import com.sarkar.airlinebackend.DTO.FlightScheduleDTO;
import com.sarkar.airlinebackend.DTO.FlightSchedulesAndSeatDTO;
import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.services.business.FlightSchedule.GetFlightSchedulesBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFlightSchedulesHandler {

    @Autowired
    GetFlightSchedulesBusinessService getFlightSchedulesBusinessService;

    public Response<List<FlightScheduleDTO>> handle(String departureLocation, String destinationLocation, String departureDate) {

        System.out.println("in the handle");


        if (departureLocation == null || destinationLocation == null) {
            // If either location is null, fetch all schedules from departure date onwards
//            departure date will never be null since one is being created if it isnt given






//            return getFlightSchedulesBusinessService.getAllFlightSchedulesAfterDepartureDate(departureDate);


        } else { //meaning both lcoations are provided
            // Call business service with specific location and date parameters
//            System.out.println("getFlightSchedulesBusinessService has both locations");
//            System.out.println(departureLocation);
//            System.out.println(destinationLocation);
//            System.out.println(departureDate);
            return getFlightSchedulesBusinessService.getFlightSchedulesByLocationsAndDate(departureLocation, destinationLocation, departureDate);
        }




        return null;




////        if(departureLocation != null) {
//            return getFlightSchedulesBusinessService.getFlightSchedulesByDepartureLocation(departureLocation);
////        }





    }

}
