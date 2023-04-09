package edu.depaul.cdm.se452.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Timestamp created;
}
