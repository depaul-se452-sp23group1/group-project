package edu.depaul.cdm.se452.transaction.model;
import edu.depaul.cdm.se452.accounts.model.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name = "transactions")
@Entity
public class Transactions {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
    private long trId;
  //  @OneToOne(mappedBy = "transactions")
   // private Shipping shipping;
  @Column(name = "tr_date")
    private Date trDate;
  //  @JoinColumn(name="order_id", referencedColumnName = "order_id") //check
    //private Order order;
    //@JoinColumn(name="", referencedColumnName = "id")
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
