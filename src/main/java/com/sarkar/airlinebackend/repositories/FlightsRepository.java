package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.FlightModel;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface FlightsRepository extends JpaRepository<FlightModel, String> {

    List<FlightModel> findByFlightNumber(String flightNumber);

    List<FlightModel> findByFlightId(UUID flightId);

    List<FlightModel> findByRouteId(UUID routeId);

    List<FlightModel> findByDepartureDate(Date departureDate);

    // You can add more query methods based on your requirements
}
