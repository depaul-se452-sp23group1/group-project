package edu.depaul.cdm.se452.transaction.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @Column(name="shp_id")
    private long shpId;
    @Column(name="shp_method")
    private String shpMethod;
    @Column(name="shp_status")
    private String shpStatus;
    @Column(name="address_1")
    private String address1;
    @Column(name="address_2")
    private String address2;
    private String city;
    private String zip;
    private String state;
    // @JoinColumn(name="tr_id", referencedColumnName = "tr_id")
    //  private Transactions transaction;
    @Column(name="tr_id")
    private long trId;
}

