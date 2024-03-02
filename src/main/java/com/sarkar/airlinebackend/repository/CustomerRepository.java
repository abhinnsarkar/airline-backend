package com.sarkar.airlinebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.CustomerModel;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel, String> {

    List<CustomerModel> findByFirstName(String firstName);

    List<CustomerModel> findByLastName(String lastName);

    List<CustomerModel> findByEmail(String email);

    // You can add more query methods based on your requirements
}
