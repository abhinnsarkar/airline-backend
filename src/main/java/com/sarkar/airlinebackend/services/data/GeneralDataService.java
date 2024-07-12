package com.sarkar.airlinebackend.services.data;

import com.sarkar.airlinebackend.DTO.FlightInfoDTO;
import com.sarkar.airlinebackend.DTO.FlightScheduleDTO;
import com.sarkar.airlinebackend.DTO.FlightSchedulesAndSeatDTO;
import com.sarkar.airlinebackend.DTO.SeatBookingAllocationInfo;
import com.sarkar.airlinebackend.Responses.Response;
import com.sarkar.airlinebackend.Responses.ReturnCode;
import com.sarkar.airlinebackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class GeneralDataService {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    /**
     * Retrieves a list of UUIDs representing the seat numbers associated with a given flight number.
     *
     * @param flightNumber the number of the flight to retrieve seat numbers for
     * @return a list of UUIDs representing the seat numbers
     */
    public Response<List<UUID>> getSeatsByFlightNumber(String flightNumber) {
        try {
            String sql = "SELECT model_seat.model_seat_id as model_seat_id " +
                    "FROM flight " +
                    "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key " +
                    "WHERE flight.flight_number = ?";

            RowMapper<UUID> mapper = (rs, rowNum) -> (UUID) rs.getObject("model_seat_id", UUID.class);

            List<UUID> queryResults = template.query(sql, mapper, flightNumber);

            var response = new Response<List<UUID>>();
            response.setData(queryResults);
            response.setReturnCode(ReturnCode.SUCCESS);
            response.addMessage("Seats retrieved successfully.");

            return response;

        } catch (Exception e) {

            var response = new Response<List<UUID>>();
            response.setData(null);
            response.setReturnCode(ReturnCode.ERROR);
            response.addMessage("Failed to retrieve seats: " + e.getMessage());
            return response;
        }
    }


    public Response<List<FlightInfoDTO>> getAllFlightsInfo() {

        String sql = "SELECT " +
                "flight.flight_id as flight_id, " +
                "flight.flight_number as flight_number, " +
                "flight.flight_model_name_key as flight_model_name_key, " +
                "flight.route_id as route_id, " +
                "route.origin_airport_code as origin_airport_code, " +
                "route.destination_airport_code as destination_airport_code, " +
                "model_seat.model_seat_id AS model_seat_id, " +
                "model_seat.seat_number AS seat_number, " +
                "model_seat.seat_class AS seat_class " +
                "FROM flight " +
                "JOIN route ON flight.route_id = route.route_id " + // Added space at the end
                "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key";

        Map<UUID, FlightInfoDTO> flightMap = new HashMap<>();

        RowMapper<FlightInfoDTO> mapper = new RowMapper<FlightInfoDTO>() {
            @Override
            public FlightInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UUID flightId = (UUID) rs.getObject("flight_id", UUID.class);
                FlightInfoDTO flightInfo = flightMap.get(flightId);
                if (flightInfo == null) {
                    flightInfo = new FlightInfoDTO();
                    flightInfo.setFlightId(flightId);
                    flightInfo.setFlightNumber(rs.getString("flight_number"));
                    flightInfo.setFlightModelNameKey(rs.getString("flight_model_name_key"));
                    flightInfo.setRouteId((UUID) rs.getObject("route_id", UUID.class));
                    flightInfo.setOriginAirportCode(rs.getString("origin_airport_code"));
                    flightInfo.setDestinationAirportCode(rs.getString("destination_airport_code"));
                    flightInfo.setSeats(new ArrayList<>());
                    flightMap.put(flightId, flightInfo);
                }

                ModelSeatModel seat = new ModelSeatModel();
                seat.setModelSeatId((UUID) rs.getObject("model_seat_id", UUID.class));
                seat.setSeatNumber(rs.getString("seat_number"));
                seat.setSeatClass(rs.getString("seat_class"));
                seat.setFlightModelNameKey(rs.getString("flight_model_name_key"));

                flightInfo.getSeats().add(seat);

                return flightInfo;
            }
        };

        Response<List<FlightInfoDTO>> response = new Response<>();

        try {
            List<FlightInfoDTO> flightsInfo = template.query(sql, mapper);
            response.setReturnCode(ReturnCode.SUCCESS);
            response.setData(new ArrayList<>(flightMap.values()));
            response.addMessage("Flights fetched successfully.");
        } catch (DataAccessException e) {
            response.setReturnCode(ReturnCode.ERROR);
            response.setData(null);
            response.addMessage("Failed to fetch flights: " + e.getMessage());
        }

        return response;
    }




//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByLocationsAndDate(String departureAirportCode, String destinationAirportCode, String departureDate) {
//        String sql = "SELECT " +
//                "flight_schedule.flight_schedule_id as flight_schedule_id, " +
//                "flight.flight_id as flight_id, " +
//                "flight_schedule.departure_date as departure_date, " +
//                "flight.flight_number as flight_number, " +
//                "flight.flight_model_name_key as flight_model_name_key, " +
//                "flight.route_id as route_id, " +
//                "route.origin_airport_code as origin_airport_code, " +
//                "origin_airport.city_name as departure_location, " +
//                "destination_airport.city_name as destination_location, " +
//                "model_seat.model_seat_id AS model_seat_id, " +
//                "model_seat.seat_number AS seat_number, " +
//                "model_seat.seat_class AS seat_class, " +
//                "seat_allocation.seat_allocation_id AS seat_allocation_id, " +
//                "seat_allocation.available AS seat_available " +
//                "FROM flight_schedule " +
//                "JOIN flight ON flight_schedule.flight_id = flight.flight_id " +
//                "JOIN route ON flight.route_id = route.route_id " +
//                "JOIN airport AS origin_airport ON route.origin_airport_code = ? " +
//                "JOIN airport AS destination_airport ON route.destination_airport_code = ? " +
//                "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key " +
//                "JOIN seat_allocation ON flight_schedule.flight_schedule_id = seat_allocation.flight_schedule_id " +
//                "WHERE flight_schedule.departure_date = ?";
//
//
//
//        Map<UUID, FlightScheduleDTO> flightMap = new HashMap<>();
//
//        RowMapper<FlightScheduleDTO> mapper = new RowMapper<FlightScheduleDTO>() {
//            @Override
//            public FlightScheduleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//                UUID flightScheduleId = (UUID) rs.getObject("flight_schedule_id");
//                FlightScheduleDTO flightSchedule = flightMap.get(flightScheduleId);
//                if (flightSchedule == null) {
//                    flightSchedule = new FlightScheduleDTO();
//                    flightSchedule.setFlightScheduleId(flightScheduleId);
//                    flightSchedule.setFlightId((UUID) rs.getObject("flight_id"));
//                    flightSchedule.setDepartureDate(java.sql.Date.valueOf(rs.getDate("departure_date").toLocalDate()));
//                    flightSchedule.setFlightNumber(rs.getString("flight_number"));
//                    flightSchedule.setFlightModelNameKey(rs.getString("flight_model_name_key"));
//                    flightSchedule.setRouteId((UUID) rs.getObject("route_id"));
//                    flightSchedule.setOriginAirportCode(rs.getString("origin_airport_code"));
//                    flightSchedule.setDepartureLocation(rs.getString("departure_location"));
//                    flightSchedule.setDestinationAirportCode(rs.getString("destination_airport_code"));
//                    flightSchedule.setDestinationLocation(rs.getString("destination_location"));
//                    flightSchedule.setSeats(new ArrayList<>());
//                    flightMap.put(flightScheduleId, flightSchedule);
//                }
//
//                SeatBookingAllocationInfo seatAllocation = new SeatBookingAllocationInfo();
//                seatAllocation.setSeatAllocationId((UUID) rs.getObject("seat_allocation_id"));
//                seatAllocation.setModelSeatId((UUID) rs.getObject("model_seat_id"));
//                seatAllocation.setSeatNumber(rs.getString("seat_number"));
//                seatAllocation.setSeatClass(rs.getString("seat_class"));
//                seatAllocation.setAvailable(rs.getBoolean("seat_available"));
//
//                flightSchedule.getSeats().add(seatAllocation);
//
//                return flightSchedule;
//            }
//        };
//
//        Response<List<FlightScheduleDTO>> response = new Response<>();
//
//        try {
//            List<FlightScheduleDTO> flightSchedules = template.query(sql, mapper, departureAirportCode, destinationAirportCode, departureDate);
//            response.setReturnCode(ReturnCode.SUCCESS);
//            response.setData(new ArrayList<>(flightMap.values()));
//            response.addMessage("Flights Schedules fetched successfully.");
//        } catch (DataAccessException e) {
//            response.setReturnCode(ReturnCode.ERROR);
//            response.setData(null);
//            response.addMessage("Failed to fetch flights schedules: " + e.getMessage());
//        }
//
//        return response;
//    }
































































    public Response<List<FlightScheduleDTO>> getFlightSchedulesByLocationsAndDate(String departureAirportCode, String destinationAirportCode, String departureDate) {

        System.out.println("in the data service");

        String sql = "SELECT " +
                "flight_schedule.flight_schedule_id as flight_schedule_id, " +
                "flight.flight_id as flight_id, " +
                "flight_schedule.departure_date as departure_date, " +
                "flight.flight_number as flight_number, " +
                "flight.flight_model_name_key as flight_model_name_key, " +
                "flight.route_id as route_id, " +
                "route.origin_airport_code as origin_airport_code, " +
                "origin_airport.city_name as departure_location, " +
                "route.destination_airport_code as destination_airport_code, " +
                "destination_airport.city_name as destination_location, " +
                "model_seat.model_seat_id AS model_seat_id, " +
                "model_seat.seat_number AS seat_number, " +
                "model_seat.seat_class AS seat_class, " +
                "seat_allocation.seat_allocation_id AS seat_allocation_id, " +
                "seat_allocation.available AS seat_available " +
                "FROM flight_schedule " +
                "JOIN flight ON flight_schedule.flight_id = flight.flight_id " +
                "JOIN route ON flight.route_id = route.route_id " +
                "JOIN airport AS origin_airport ON route.origin_airport_code = origin_airport.airport_code " +
                "JOIN airport AS destination_airport ON route.destination_airport_code = destination_airport.airport_code " +
                "JOIN model_seat ON flight.flight_model_name_key = model_seat.flight_model_name_key " +
                "JOIN seat_allocation ON flight_schedule.flight_schedule_id = seat_allocation.flight_schedule_id " +
                "WHERE flight_schedule.departure_date = ? " +
                "AND origin_airport.airport_code = ? " +
                "AND destination_airport.airport_code = ?";
//                "WHERE flight_schedule.departure_date = '2024-07-21' " +
//                "AND origin_airport.airport_code = 'YVR' " +
//                "AND destination_airport.airport_code = 'YYZ'"
//        ;



        RowMapper<FlightSchedulesAndSeatDTO> mapper = new RowMapper<FlightSchedulesAndSeatDTO>() {
            @Override
            public FlightSchedulesAndSeatDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

                 FlightSchedulesAndSeatDTO flightSchedule = new FlightSchedulesAndSeatDTO();

                flightSchedule.setFlightScheduleId((UUID) rs.getObject("flight_schedule_id", UUID.class));
                flightSchedule.setFlightId((UUID) rs.getObject("flight_id", UUID.class));
                flightSchedule.setDepartureDate(rs.getDate("departure_date"));
                flightSchedule.setFlightNumber(rs.getString("flight_number"));
                flightSchedule.setFlightModelNameKey(rs.getString("flight_model_name_key"));
                flightSchedule.setRouteId((UUID) rs.getObject("route_id", UUID.class));
                flightSchedule.setOriginAirportCode(rs.getString("origin_airport_code"));
                flightSchedule.setDepartureLocation(rs.getString("departure_location"));
                flightSchedule.setDestinationAirportCode(rs.getString("destination_airport_code"));
                flightSchedule.setDestinationLocation(rs.getString("destination_location"));


                flightSchedule.setModelSeatId((UUID) rs.getObject("model_seat_id", UUID.class));
                flightSchedule.setSeatNumber(rs.getString("seat_number"));
                flightSchedule.setSeatClass(rs.getString("seat_class"));
                flightSchedule.setSeatAllocationId((UUID) rs.getObject("seat_allocation_id", UUID.class));
                flightSchedule.setSeatAvailable(rs.getBoolean("seat_available"));

                return flightSchedule;
            }
        };

        Response<List<FlightScheduleDTO>> response = new Response<>();

        try {
            System.out.println("in the try");
            System.out.println("departure date final " + departureDate);
            System.out.println(departureAirportCode);
            System.out.println(destinationAirportCode);

//            String tempDepartureAirportCode = this.getAirportCodeForLocation(departureAirportCode).getData().getFirst();
//            String tempDestinationAirportCode = this.getAirportCodeForLocation(destinationAirportCode).getData().getFirst();

            List<FlightSchedulesAndSeatDTO> flightSchedulesAndSeats = template.query(sql, mapper, departureDate, departureAirportCode, destinationAirportCode);

//            List<FlightSchedulesAndSeatDTO> flightSchedulesAndSeats = template.query(sql, mapper);
            System.out.println("sql: " + sql);

            System.out.println("flightSchedulesAndSeats " + flightSchedulesAndSeats);
            System.out.println(" LENGTH flightSchedulesAndSeats " + flightSchedulesAndSeats.toArray().length);
            System.out.println("got the data after the query executed");

            
            HashMap<UUID, FlightScheduleDTO> flightSchedulesMap = new HashMap<UUID, FlightScheduleDTO>();


            FlightScheduleDTO flightSchedule = new FlightScheduleDTO();

            for (FlightSchedulesAndSeatDTO schedule : flightSchedulesAndSeats) {
                if (flightSchedulesMap.containsKey(schedule.getFlightScheduleId())){

                    FlightScheduleDTO currentSchedule = flightSchedulesMap.get(schedule.getFlightScheduleId());

                    SeatBookingAllocationInfo seat = new SeatBookingAllocationInfo();
                    seat.setModelSeatId(schedule.getModelSeatId());
                    seat.setSeatNumber(schedule.getSeatNumber());
                    seat.setSeatClass(schedule.getSeatClass());
                    seat.setAvailable(schedule.getSeatAvailable());

                    currentSchedule.getSeats().add(seat);
                }
                else{

                    FlightScheduleDTO currentSchedule = new FlightScheduleDTO();

                    System.out.println("________________________________________________________________________________________________________________________________");

                    currentSchedule.setFlightScheduleId(schedule.getFlightScheduleId());
                    System.out.println("flightScheduleId " + schedule.getFlightScheduleId());

                    currentSchedule.setFlightId(schedule.getFlightId());
                    System.out.println("flightId " + schedule.getFlightId());

                    currentSchedule.setDepartureDate(schedule.getDepartureDate());
                    System.out.println("departure date " + schedule.getDepartureDate());

                    currentSchedule.setFlightNumber(schedule.getFlightNumber());
                    System.out.println("flight number " + schedule.getFlightNumber());

                    currentSchedule.setFlightModelNameKey(schedule.getFlightModelNameKey());
                    System.out.println("flight model name key " + schedule.getFlightModelNameKey());

                    currentSchedule.setRouteId(schedule.getRouteId());
                    System.out.println("route id " + schedule.getRouteId());

                    currentSchedule.setOriginAirportCode(schedule.getOriginAirportCode());
                    System.out.println("origin airport code " + schedule.getOriginAirportCode());

                    currentSchedule.setDepartureLocation(schedule.getDepartureLocation());
                    System.out.println("departure location " + schedule.getDepartureLocation());

                    currentSchedule.setDestinationAirportCode(schedule.getDestinationAirportCode());
                    System.out.println("destination airport code " + schedule.getDestinationAirportCode());

                    currentSchedule.setDestinationLocation(schedule.getDestinationLocation());
                    System.out.println("destination location " + schedule.getDestinationLocation());

                    SeatBookingAllocationInfo seat = new SeatBookingAllocationInfo();

                    seat.setSeatAllocationId(schedule.getSeatAllocationId());
                    System.out.println("seat allocation id " + schedule.getSeatAllocationId());

                    seat.setFlightScheduleId(schedule.getFlightScheduleId());
                    System.out.println("flight schedule id " + schedule.getFlightScheduleId());

                    seat.setModelSeatId(schedule.getModelSeatId());
                    System.out.println("model seat id " + schedule.getModelSeatId());

                    seat.setSeatNumber(schedule.getSeatNumber());
                    System.out.println("seat number " + schedule.getSeatNumber());

                    seat.setSeatClass(schedule.getSeatClass());
                    System.out.println("seat class " + schedule.getSeatClass());

                    seat.setAvailable(schedule.getSeatAvailable());
                    System.out.println("seat available " + schedule.getSeatAvailable());

                    seat.setFlightModelNameKey(schedule.getFlightModelNameKey());
                    System.out.println("flight model name key " + schedule.getFlightModelNameKey());

                    System.out.println("________________________________________________________________________________________________________________________________");

                    List<SeatBookingAllocationInfo> seats = new ArrayList<SeatBookingAllocationInfo>();
                    seats.add(seat);
                    currentSchedule.setSeats(seats);

                    flightSchedulesMap.put(currentSchedule.getFlightScheduleId(), currentSchedule);
                }

            }

            response.setReturnCode(ReturnCode.SUCCESS);
            response.setData(new ArrayList<>(flightSchedulesMap.values()));
            System.out.println("flightSchedulesMap: " + flightSchedulesMap.keySet());
            for (FlightScheduleDTO flightScheduleDTO : flightSchedulesMap.values()) {
                System.out.println(flightScheduleDTO.toString());
            }
//            var toReturn = new ArrayList<FlightScheduleDTO>();
//            toReturn.add(new FlightScheduleDTO());
//            response.setData(toReturn);
            response.addMessage("Flights Schedules fetched successfully.");
        } catch (DataAccessException e) {
            response.setReturnCode(ReturnCode.ERROR);
            response.setData(null);
            response.addMessage("Failed to fetch flights schedules: " + e.getMessage());
        }


        return response;
    }































































    public Response<List<String>> getAirportCodeForLocation(String location) {
        System.out.println("getAirportCodeForLocation: " + location);
        try {
            String sql = "SELECT airport.airport_code as airport_code " +
                    "FROM airport " +
                    "WHERE airport.city_name = ?";

            RowMapper<String> mapper = (rs, rowNum) -> (String) rs.getString("airport_code");

            List<String> queryResults = template.query(sql, mapper, location);

            var response = new Response<List<String>>();
            response.setData(queryResults);

            if (queryResults.size() != 1) {
                response.setReturnCode(ReturnCode.ERROR);
                response.addMessage("Incorrect airport code(s) found for location: " + location);
                return response;
            }

            response.setReturnCode(ReturnCode.SUCCESS);
            response.getData().add(queryResults.getFirst());
            response.addMessage("Airport Code retrieved successfully.");

            return response;

        } catch (Exception e) {

            var response = new Response<List<String>>();
            response.setData(null);
            response.setReturnCode(ReturnCode.ERROR);
            response.addMessage("Failed to retrieve airport code: " + e.getMessage());
            return response;
        }
    }

//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByDestinationAirportCode(String destinationAirportCode) {
//    }
//
//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByDepartureDate(String departureDate) {
//    }
//
//    public Response<List<FlightScheduleDTO>> getFlightSchedulesByLocationAndDate() {
//    }
}
