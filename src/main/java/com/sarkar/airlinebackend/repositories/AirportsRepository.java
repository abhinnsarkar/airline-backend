package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.AirportModel;

import java.util.List;

public interface AirportsRepository extends JpaRepository<AirportModel, String> {

    List<AirportModel> findByCityName(String cityName);

    List<AirportModel> findByCountryName(String countryName);

    // You can add more query methods based on your requirements
}
