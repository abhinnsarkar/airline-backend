package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.FlightModel;

import java.util.List;

public interface FlightsRepository extends JpaRepository<FlightModel, String> {

    List<FlightModel> findByFlightNumber(String flightNumber);

    List<FlightModel> findByFlightId(String flightId);

    List<FlightModel> findByRouteId(String routeId);

    List<FlightModel> findByDepartureDate(String departureDate);

    // You can add more query methods based on your requirements
}
