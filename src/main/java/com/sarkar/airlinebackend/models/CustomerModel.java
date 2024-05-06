// ADJUSTED FOR DDL2
package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @Column(name = "customer_id")
    @Schema(description = "Customer ID", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID customerId;

    @Column(name = "customer_name")
    @Schema(description = "Customer Name", example = "John Doe")
    private String customerName;

    @Column(name = "dob")
    @Schema(description = "Date of Birth", example = "2015-03-15")
    private Date dob;

    public CustomerModel() {
    }

    public CustomerModel(UUID customerId, String customerName, Date dob) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dob = dob;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
