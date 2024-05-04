package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftsRepository extends JpaRepository<AircraftModel, String> {
    List<AircraftModel> findByModel(String model);
}
