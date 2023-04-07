package edu.depaul.cdm.se452.accounts.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private String password;
}
