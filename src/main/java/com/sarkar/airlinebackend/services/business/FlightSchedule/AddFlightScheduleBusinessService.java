package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.models.SeatAllocationModel;
import com.sarkar.airlinebackend.services.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
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






    public List<FlightScheduleModel> addFlightSchedule(String flightNumber, Integer month, Integer year) {



        List<FlightScheduleModel> flightSchedules = this.makeNewScheduleForFlightNumberMonthYear(flightNumber, month, year);



        List<UUID> emptySeatIds = this.generalDataService.getSeatsByFlightNumber(flightNumber);

        var allocatedSeats = this.createSeatAllocationsForFlightSchedules(flightSchedules, emptySeatIds);


        return flightSchedules;

    }


//
//    /**
//     * Allocates seats as available.
//     *
//     * @return  true if the seats were successfully allocated, false otherwise
//     */
//    private Boolean AllocateSeatsAsAvailable(UUID flightScheduleId) {
//////    get flight id from flightScheduleId
//////    from flight_id go to flight table and get model name key
//////    go through model seat table and get all seats for that model name key
//////    for the if of every retrieved model seat, set available to true
////
////        UUID flightId = flightScheduleDataService.getFlightIdFromFlightScheduleId(flightScheduleId);
////        String flightModelNameKey = flightDataService.getModelNameKeyFromFlightId(flightId);
////        List<ModelSeatModel> modelSeats = modelSeatDataService.getAllSeatsByModelNameKey(flightModelNameKey);
////
////        for (ModelSeatModel modelSeat : modelSeats) {
////
////            seatAllocationDataService.setSeatToAvailable(flightScheduleId, modelSeat.getModelSeatId());
////        }
////
//    return true;
//    }

    /**
     * Generates a new schedule for a given flight number and month.
     *
     * @param  flightNumber  the flight number for which to generate a schedule
     * @param  monthNum         the month for which to generate a schedule
     * @return               a list of FlightScheduleModel objects representing the new schedule
     */
    private List<FlightScheduleModel> makeNewScheduleForFlightNumberMonthYear(String flightNumber, Integer monthNum, Integer year) {

//      go through flight table and find the flight with given number
//      get its id and model name
//      make a new schedule for that id and month and store model name for seat allocation

        var flightModels = flightDataService.getFlightByNumber(flightNumber);

        if (flightModels.size() != 1) {
            throw new IllegalArgumentException("Flight Error");
        }

//        TODO Find some method to add time for departure
        var defaultDepartureTime = new Time(12, 0, 0);


//        int month = Integer.parseInt(monthNum);
        int selectedMonth = monthNum;
        int selectedYear = year;


        YearMonth yearMonthObject = YearMonth.of(selectedYear, selectedMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        List<FlightScheduleModel> flightSchedules = new ArrayList<>();

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate localDate = LocalDate.of(selectedYear, selectedMonth, day);
            Date departureDate = Date.valueOf(localDate);

            var flightSchedule = new FlightScheduleModel(UUID.randomUUID(), flightModels.getFirst().getFlightId(), departureDate, defaultDepartureTime);

            flightScheduleDataService.addFlightSchedule(flightSchedule);


            flightSchedules.add(flightSchedule);
        }

        return flightSchedules;
    }



    private Boolean createSeatAllocationsForFlightSchedules(List<FlightScheduleModel> flightSchedules, List<UUID> seatIds) {


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
