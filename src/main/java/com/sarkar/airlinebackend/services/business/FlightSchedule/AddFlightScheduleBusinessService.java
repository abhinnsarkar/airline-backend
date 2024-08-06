package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.models.SeatAllocationModel;
import com.sarkar.airlinebackend.services.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;


import static java.lang.Integer.parseInt;

@Service
public class AddFlightScheduleBusinessService {

    @Autowired
    private FlightDataService flightDataService;

    @Autowired
    private FlightScheduleDataService flightScheduleDataService;

    @Autowired
    private ModelSeatDataService modelSeatDataService;

    @Autowired
    private SeatAllocationDataService seatAllocationDataService;

    @Autowired
    private GeneralDataService generalDataService;






    /**
     * Adds a new flight schedule based on the provided flight details.
     *
     * @param  flightNumber  the flight number for which to add a schedule
     * @param  month         the month of the schedule
     * @param  year          the year of the schedule
     * @param  hour          the hour of the schedule
     * @param  minute        the minute of the schedule
     * @return               a Response object containing the list of FlightScheduleModel objects
     */
    public Response<List<FlightScheduleModel>> addFlightSchedule(String flightNumber, Integer month, Integer year, Integer hour, Integer minute) {

        Response<List<FlightScheduleModel>> flightSchedulesResponse = this.makeNewScheduleForFlightNumberMonthYear(flightNumber, month, year, hour, minute);

        var response = new Response<List<FlightScheduleModel>>();

        if (flightSchedulesResponse.getReturnCode() != ReturnCode.SUCCESS) {

            response.setReturnCode(flightSchedulesResponse.getReturnCode());
//            response.setData(false));
            response.addMessage(flightSchedulesResponse.getMessages().getFirst());
            return response;
        }



        Response<List<UUID>> emptySeatIds = this.generalDataService.getSeatsByFlightNumber(flightNumber);

        var allocatedSeats = this.createSeatAllocationsForFlightSchedules(flightSchedulesResponse.getData(), emptySeatIds.getData());


        return flightSchedulesResponse;

    }


    /**
     * Generates a new schedule for a given flight number and month. but doesn't insert it into the database
     *
     * @param  flightNumber  the flight number for which to generate a schedule
     * @param  monthNum         the month for which to generate a schedule
     * @return               a list of FlightScheduleModel objects representing the new schedule
     */
    private Response<List<FlightScheduleModel>> makeNewScheduleForFlightNumberMonthYear(String flightNumber, Integer monthNum, Integer year, Integer hour, Integer minute) {

//      go through flight table and find the flight with given number
//      get its id and model name
//      make a new schedule for that id and month and store model name for seat allocation

        var flightModels = flightDataService.getFlightByNumber(flightNumber);

        if (flightModels.size() != 1) {
            throw new IllegalArgumentException("Flight Error");
        }

//        TODO Find some method to add time for departure
        LocalTime departureTime = LocalTime.of(hour, minute);
//        LocalTime time = LocalTime.of(hour, minute);


//        int month = Integer.parseInt(monthNum);
        int selectedMonth = monthNum;
        int selectedYear = year;


        YearMonth yearMonthObject = YearMonth.of(selectedYear, selectedMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        List<FlightScheduleModel> flightSchedules = new ArrayList<>();
        boolean hasError = false; // Flag to track if any error occurs

        var response = new Response<List<FlightScheduleModel>>();

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate localDate = LocalDate.of(selectedYear, selectedMonth, day);
            Date departureDate = Date.valueOf(localDate);

            var flightSchedule = new FlightScheduleModel(UUID.randomUUID(), flightModels.getFirst().getFlightId(), departureDate, departureTime);

            var result = flightScheduleDataService.addFlightSchedule(flightSchedule);


            // Check if the result has an error return code
            if (result.getReturnCode() == ReturnCode.ERROR) {
                hasError = true; // Set flag to true if error occurs
                response.addMessage(result.getMessages().getFirst());
            }

            flightSchedules.add(flightSchedule);
        }

//        var response = new Response<List<FlightScheduleModel>>();
        response.setData(flightSchedules);

        // Set return code based on the flag
        if (hasError) {
//            response.setReturnCode(ReturnCode.ERROR);
//            response.addMessage("Error occurred while adding flight schedules.");


            response.setReturnCode(ReturnCode.ERROR);
//            // Using the detailed error message from the data service
//            response.addMessage("Error occurred while adding flight schedules: " + response.getMessages().get(0));


        } else {
            response.setReturnCode(ReturnCode.SUCCESS);
            response.addMessage("Flight schedules added successfully.");
        }

        return response;
    }



    private Response<Boolean> createSeatAllocationsForFlightSchedules(List<FlightScheduleModel> flightSchedules, List<UUID> seatIds) {


        var seatAllocationModels = new ArrayList<SeatAllocationModel>();
        final Boolean SEAT_AVAILABLE = true;

        for(FlightScheduleModel flightScheduleModel : flightSchedules ) {

            // For each Flight Schedule Model, we will create a List of Seat Allocations

            for(UUID seatId : seatIds) {


                var seatAllocationModel = new SeatAllocationModel(UUID.randomUUID(), flightScheduleModel.getFlightScheduleId(), seatId, SEAT_AVAILABLE);

                seatAllocationModels.add(seatAllocationModel);

            }
        }
        return seatAllocationDataService.insertSeatAllocations(seatAllocationModels);
    }
}
