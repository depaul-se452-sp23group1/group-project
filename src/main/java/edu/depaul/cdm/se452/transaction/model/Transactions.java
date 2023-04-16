package edu.depaul.cdm.se452.transaction.model;
import edu.depaul.cdm.se452.accounts.model.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
    private long trId;
  //  @OneToOne(mappedBy = "transactions")
   // private Shipping shipping;
    //private Date trDate;
  //  @JoinColumn(name="order_id", referencedColumnName = "order_id") //check
    //private Order order;
    //@JoinColumn(name="", referencedColumnName = "id")
   // private User user;
    // should I add ?? private long userId;
    private double trAmt;
    private long ccNumber;
    private Date ccExpDate;
    private String ccName;
  //  private String status;
}
