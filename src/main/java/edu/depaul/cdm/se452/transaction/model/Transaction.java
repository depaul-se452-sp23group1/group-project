package edu.depaul.cdm.se452.transaction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Transaction {
    @Id
    private Long id;

}
