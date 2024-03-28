package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.RouteModel;

import java.util.List;
import java.util.UUID;

public interface RoutesRepository extends JpaRepository<RouteModel, UUID> {

    List<RouteModel> findByOriginAirportCode(String originAirportCode);

    List<RouteModel> findByDestinationAirportCode(String destinationAirportCode);

    // You can add more query methods based on your requirements
}
