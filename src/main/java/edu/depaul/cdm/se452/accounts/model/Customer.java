package edu.depaul.cdm.se452.accounts.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="address_1")
    private String streetAddress1;
    @Column(name="address_2")
    private String streetAddress2;
    @Column(name="city")
    private String city;
    @Column(name="zip")
    private String zip;
    @Column(name="state")
    private String state;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

}
