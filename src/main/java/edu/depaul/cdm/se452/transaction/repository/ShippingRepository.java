package edu.depaul.cdm.se452.transaction.repository;
import edu.depaul.cdm.se452.transaction.model.Shipping;
import edu.depaul.cdm.se452.transaction.model.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ShippingRepository extends CrudRepository<Shipping, Long> {

    Shipping findById(long id);

    List<Shipping> findAll();
}

