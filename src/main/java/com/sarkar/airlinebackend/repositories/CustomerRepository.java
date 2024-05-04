// ADJUSTED FOR DDL2
package com.sarkar.airlinebackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sarkar.airlinebackend.models.CustomerModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {

    List<CustomerModel> findById(UUID customerId);
    List<CustomerModel> findByName(String customerName);
}
