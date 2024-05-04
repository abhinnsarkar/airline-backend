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
    @Column(name = "Customer ID")
    @Schema(description = "Customer ID", example = "12345")
    private UUID customerId;

    @Column(name = "customer_name")
    @Schema(description = "Customer Name")
    private String customerName;

    @Column(name = "dob")
    @Schema(description = "Date of Birth")
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
