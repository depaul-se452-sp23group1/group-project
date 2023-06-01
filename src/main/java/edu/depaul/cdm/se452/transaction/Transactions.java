package edu.depaul.cdm.se452.transaction;

import edu.depaul.cdm.se452.products.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
@Table(name = "transactions")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
    private long trId;

  //  @JoinColumn(name="order_id", referencedColumnName = "order_id") //check
    //private Order order;
    @NonNull
    @Column(name="tr_amt")
    private double trAmt;

    @NonNull
    @Column(name="cc_number")
    private long ccNumber;

    @NonNull
    @Column(name="cc_exp_date")
    private Date ccExpDate;

    @NonNull
    @Column(name="cc_name")
    private String ccName;

    private String status;
}
