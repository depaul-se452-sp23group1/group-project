package edu.depaul.cdm.se452.transaction;

import edu.depaul.cdm.se452.products.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shp_id")
    private long shpId;

    @OneToOne
    //@Column(insertable = false, updatable = false)
    @PrimaryKeyJoinColumn(name = "tr_id")
    private Transactions transactions;

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

    @PrimaryKeyJoinColumn(name = "tr_id")
    @Column(name="tr_id")
    private long trId;
}

