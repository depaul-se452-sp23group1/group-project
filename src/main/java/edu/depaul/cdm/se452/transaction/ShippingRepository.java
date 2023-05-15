package edu.depaul.cdm.se452.transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ShippingRepository extends CrudRepository<Shipping, Long> {

    Shipping findById(long id);

    List<Shipping> findAll();
}

