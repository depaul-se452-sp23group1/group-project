package edu.depaul.cdm.se452.transaction.model;
import edu.depaul.cdm.se452.accounts.model.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tr_id")
    private long trId;
    @OneToOne(mappedBy = "transactions")
    private Shipping shipping;
    private Date trDate;
    @JoinColumn(name="", referencedColumnName = "order_id")
    private Order order;
    @JoinColumn(name="", referencedColumnName = "id")
    private User user;
    private long userId;
    private double trAmt;
    private long ccNumber;
    private Date ccExpDate;
    private String ccName;


}
