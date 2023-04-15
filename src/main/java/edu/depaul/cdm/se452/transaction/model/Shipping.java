package edu.depaul.cdm.se452.transaction.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Shipping {

    private long shpId;
    private String shpMethod;
    private String shpStatus;
    @Column(name="address_1")
    private String address1;
    @Column(name="address_2")
    private String address2;
    private String city;
    private String zip;
    private String state;
    @JoinColumn(name="tr_id", referencedColumnName = "tr_id")
    private Transactions transaction;
}
