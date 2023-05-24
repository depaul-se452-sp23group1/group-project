package edu.depaul.cdm.se452.transaction;

import edu.depaul.cdm.se452.products.model.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Table(name = "transactions")
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
    private long trId;

  // @Column(name = "tr_date")
   // private Date trDate;

  //  @JoinColumn(name="order_id", referencedColumnName = "order_id") //check
    //private Order order;

    @Column(name="tr_amt")
    private double trAmt;

    @Column(name="cc_number")
    private long ccNumber;
    @Column(name="cc_exp_date")
    private Date ccExpDate;
    @Column(name="cc_name")
    private String ccName;
    private String status;
}
