//////package com.sarkar.airlinebackend.models;
//////
//////import jakarta.persistence.*;
//////
//////import io.swagger.v3.oas.annotations.media.Schema;
//////
//////@Entity
//////@Table(name = "customers")
//////public class CustomerModel {
//////
//////    @Id
//////    @Column(name = "customer_id")
//////    @Schema(description = "Customer ID", example = "12345")
//////    private String customerId;
//////
//////    @Column(name = "first_name")
//////    @Schema(description = "First Name", example = "John")
//////    private String firstName;
//////
//////    @Column(name = "middle_name")
//////    @Schema(description = "Middle Name", example = "James")
//////    private String middleName;
//////
//////    @Column(name = "last_name")
//////    @Schema(description = "Last Name", example = "Doe")
//////    private String lastName;
//////
//////    @Column(name = "johndoe@gmail.com")
//////    private String email;
//////
//////    @Column(name = "123-456-7890")
//////    private String phoneNumber;
//////
//////    @Column(name = "dob")
//////    private java.sql.Date dob;
//////
//////    // Constructors, getters, and setters
//////
//////    public CustomerModel() {
//////        // Default constructor
//////    }
//////
//////    public CustomerModel(String customerId, String firstName, String middleName, String lastName, String email, String phoneNumber, java.sql.Date dob) {
//////        this.customerId = customerId;
//////        this.firstName = firstName;
//////        this.middleName = middleName;
//////        this.lastName = lastName;
//////        this.email = email;
//////        this.phoneNumber = phoneNumber;
//////        this.dob = dob;
//////    }
//////
//////    // Getters and setters
//////
//////    public String getCustomerId() {
//////        return customerId;
//////    }
//////
//////    public void setCustomerId(String customerId) {
//////        this.customerId = customerId;
//////    }
//////
//////    public String getFirstName() {
//////        return firstName;
//////    }
//////
//////    public void setFirstName(String firstName) {
//////        this.firstName = firstName;
//////    }
//////
//////    public String getMiddleName() {
//////        return middleName;
//////    }
//////
//////    public void setMiddleName(String middleName) {
//////        this.middleName = middleName;
//////    }
//////
//////    public String getLastName() {
//////        return lastName;
//////    }
//////
//////    public void setLastName(String lastName) {
//////        this.lastName = lastName;
//////    }
//////
//////    public String getEmail() {
//////        return email;
//////    }
//////
//////    public void setEmail(String email) {
//////        this.email = email;
//////    }
//////
//////    public String getPhoneNumber() {
//////        return phoneNumber;
//////    }
//////
//////    public void setPhoneNumber(String phoneNumber) {
//////        this.phoneNumber = phoneNumber;
//////    }
//////
//////    public java.sql.Date getDob() {
//////        return dob;
//////    }
//////
//////    public void setDob(java.sql.Date dob) {
//////        this.dob = dob;
//////    }
//////}
////package com.sarkar.airlinebackend.models;
////
////import javax.persistence.*;
////import javax.persistence.Column;
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.GenerationType;
////import javax.persistence.Id;
////import javax.persistence.Table;
////
////
////import io.swagger.v3.oas.annotations.media.Schema;
////
////@Entity
////@Table(name = "customers")
////public class CustomerModel {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @Column(name = "customer_id")
////    @Schema(description = "Customer ID", example = "12345")
////    private Long customerId;
////
////    @Column(name = "first_name")
////    @Schema(description = "First Name", example = "John")
////    private String firstName;
////
////    @Column(name = "middle_name")
////    @Schema(description = "Middle Name", example = "James")
////    private String middleName;
////
////    @Column(name = "last_name")
////    @Schema(description = "Last Name", example = "Doe")
////    private String lastName;
////
////    @Column(name = "email")
////    private String email;
////
////    @Column(name = "phone_number")
////    private String phoneNumber;
////
////    @Column(name = "dob")
////    private java.sql.Date dob;
////
////    // Constructors, getters, and setters
////}
//
//
//
//package com.sarkar.airlinebackend.models;
//
//
//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "customers")
//public class CustomerModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
//    @Schema(description = "Customer ID", example = "12345")
//    private Long customerId;
//
//    @Column(name = "first_name")
//    @Schema(description = "First Name", example = "John")
//    private String firstName;
//
//    @Column(name = "middle_name")
//    @Schema(description = "Middle Name", example = "James")
//    private String middleName;
//
//    @Column(name = "last_name")
//    @Schema(description = "Last Name", example = "Doe")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column(name = "dob")
//    private java.sql.Date dob;
//
//    // Constructors, getters, and setters
//
//    public CustomerModel() {
//        // Default constructor
//    }
//
//    public CustomerModel(Long customerId, String firstName, String middleName, String lastName, String email, String phoneNumber, java.sql.Date dob) {
//        this.customerId = customerId;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.dob = dob;
//    }
//
//    public Long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Long customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public java.sql.Date getDob() {
//        return dob;
//    }
//
//    public void setDob(java.sql.Date dob) {
//        this.dob = dob;
//    }
//}

package com.sarkar.airlinebackend.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @Column(name = "customer_id")
    @Schema(description = "Customer ID", example = "12345")
    private String customerId;

    @Column(name = "first_name")
    @Schema(description = "First Name", example = "John")
    private String firstName;

    @Column(name = "middle_name")
    @Schema(description = "Middle Name", example = "James")
    private String middleName;

    @Column(name = "last_name")
    @Schema(description = "Last Name", example = "Doe")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "dob")
    private java.sql.Date dob;

    // Constructors, getters, and setters

    public CustomerModel() {
        // Default constructor
    }

    public CustomerModel(String customerId, String firstName, String middleName, String lastName, String email, String phoneNumber, java.sql.Date dob) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }
}
