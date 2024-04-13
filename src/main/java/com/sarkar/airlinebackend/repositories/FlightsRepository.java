package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.FlightModel;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jdbc.repository.query.Query;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface FlightsRepository extends JpaRepository<FlightModel, String> {

    List<FlightModel> findByFlightNumber(String flightNumber);

    List<FlightModel> findByFlightId(UUID flightId);

    List<FlightModel> findByRouteId(UUID routeId);

    List<FlightModel> findByDepartureDate(Date departureDate);

    @Query("SELECT f FROM Flight f JOIN f.route r WHERE r.originAirportCode = :airportCode")
    List<FlightModel> findFlightsByOriginAirportCode(@Param("airportCode") String airportCode);
}
