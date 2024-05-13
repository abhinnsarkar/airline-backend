package com.sarkar.airlinebackend.services.business.FlightSchedule;

import com.sarkar.airlinebackend.models.FlightScheduleModel;
import com.sarkar.airlinebackend.models.ModelSeatModel;
import com.sarkar.airlinebackend.services.data.FlightDataService;
import com.sarkar.airlinebackend.services.data.FlightScheduleDataService;
import com.sarkar.airlinebackend.services.data.ModelSeatDataService;
import com.sarkar.airlinebackend.services.data.SeatAllocationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Year;
import java.util.List;
import java.time.YearMonth;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;


import static java.lang.Integer.parseInt;

@Service
public class AddFlightScheduleBusinessService {

//    TODO: Add a flight schedule
//


    @Autowired
    private FlightDataService flightDataService;

    @Autowired
    private FlightScheduleDataService flightScheduleDataService;

    @Autowired
    private ModelSeatDataService modelSeatDataService;

    @Autowired
    private SeatAllocationDataService seatAllocationDataService;






    public List<FlightScheduleModel> addFlightSchedule(String flightNumber, String month) {

//        TODO create new data service to join flight, flight_model, model_seat
//        TODO get flight_id from provided flightNumber


        List<FlightScheduleModel> flightSchedules = this.MakeNewScheduleForFlightNumber(flightNumber, month);

        if (flightSchedules.size() != 1) {
            throw new IllegalArgumentException("Flight Schedule Error");
        }

        Boolean seatAllocationSuccess = this.AllocateSeatsAsAvailable(flightSchedules.getFirst().getFlightScheduleId());

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
    private Boolean AllocateSeatsAsAvailable(UUID flightScheduleId) {
//    get flight id from flightScheduleId
//    from flight_id go to flight table and get model name key
//    go through model seat table and get all seats for that model name key
//    for the if of every retrieved model seat, set available to true

        UUID flightId = flightScheduleDataService.getFlightIdFromFlightScheduleId(flightScheduleId);
        String flightModelNameKey = flightDataService.getModelNameKeyFromFlightId(flightId);
        List<ModelSeatModel> modelSeats = modelSeatDataService.getAllSeatsByModelNameKey(flightModelNameKey);

        for (ModelSeatModel modelSeat : modelSeats) {

            seatAllocationDataService.setSeatToAvailable(flightScheduleId, modelSeat.getModelSeatId());
        }

    return true;
    }

    /**
     * Generates a new schedule for a given flight number and month.
     *
     * @param  flightNumber  the flight number for which to generate a schedule
     * @param  month         the month for which to generate a schedule
     * @return               a list of FlightScheduleModel objects representing the new schedule
     */
    private List<FlightScheduleModel> MakeNewScheduleForFlightNumber(String flightNumber, String monthNum) {

//      go through flight table and find the flight with given number
//      get its id and model name
//      make a new schedule for that id and month and store model name for seat allocation

        var flightModels = flightDataService.getFlightByNumber(flightNumber);

        if (flightModels.size() != 1) {
            throw new IllegalArgumentException("Flight Error");
        }


        var defaultDepartureTime = new Time(12, 0, 0);


        int month = Integer.parseInt(monthNum);
        int currentYear = Year.now().getValue();


        YearMonth yearMonthObject = YearMonth.of(currentYear, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();


        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate localDate = LocalDate.of(currentYear, month, day);
            Date departureDate = Date.valueOf(localDate);

            flightScheduleDataService.addFlightSchedule(flightModels.getFirst().getFlightId(), departureDate, defaultDepartureTime);
        }

        return null;
    }
}
