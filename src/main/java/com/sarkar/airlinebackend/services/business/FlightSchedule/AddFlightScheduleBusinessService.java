package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.services.data.FlightDataService;
import com.sarkar.airlinebackend.services.data.FlightScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class AddFlightScheduleBusinessService {

//    TODO: Add a flight schedule
//


    @Autowired
    private FlightDataService flightDataService;

    @Autowired
    private FlightScheduleDataService flightScheduleDataService;

    public List<FlightScheduleModel> addFlightSchedule(String flightNumber, String month) {


        List<FlightScheduleModel> flightSchedules = this.MakeNewScheduleForFlightNumber(flightNumber, month);

        Boolean seatAllocationSuccess = this.AllocateSeatsAsAvailable();

        if (seatAllocationSuccess) {
            return flightSchedules;
        }
        else {
            throw new IllegalStateException("Seat allocation failed");
        }

    }

    /**
     * Allocates seats as available.
     *
     * @return  true if the seats were successfully allocated, false otherwise
     */
    private Boolean AllocateSeatsAsAvailable() {
    return true;
    }

    /**
     * Generates a new schedule for a given flight number and month.
     *
     * @param  flightNumber  the flight number for which to generate a schedule
     * @param  month         the month for which to generate a schedule
     * @return               a list of FlightScheduleModel objects representing the new schedule
     */
    private List<FlightScheduleModel> MakeNewScheduleForFlightNumber(String flightNumber, String month) {
//      go through flight table and find the flight with given number
//      get its id and model name
//      make a new schedule for that id and month and store model name for seat allocation


        var flightModels = flightDataService.getFlightByNumber(flightNumber);

        if (flightModels.size() != 1) {
            throw new IllegalArgumentException("Flight Error");
        }

        var defaultDepartureTime = new Time(12,0,0);


//        flightScheduleDataService.addFlightSchedule(flightModels.getFirst().getFlightId(), departureDate, defaultDepartureTime);


        return null;
    }
}
