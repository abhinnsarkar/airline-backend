package com.sarkar.airlinebackend.repositories;

import com.sarkar.airlinebackend.models.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.AircraftModel;

import java.util.List;

public interface AircraftsRepository extends JpaRepository<AircraftModel, String> {
    List<AircraftModel> findByModel(String model);
}
