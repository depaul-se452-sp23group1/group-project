package edu.depaul.cdm.se452.accounts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    private long id;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="address_1")
    private String streetAddress1;
    @Column(name="address_2")
    private String streetAddress2;
    private String city;
    private String zip;
    private String state;
    private String phoneNumber;

}
