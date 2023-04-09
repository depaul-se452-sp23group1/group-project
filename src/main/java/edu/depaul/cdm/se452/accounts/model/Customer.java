package edu.depaul.cdm.se452.accounts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String zip;
    private String state;
    private String phoneNumber;

}
