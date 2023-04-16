package edu.depaul.cdm.se452.transaction.service;
import edu.depaul.cdm.se452.transaction.model.Shipping;
import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.repository.ShippingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2

public class ShippingService {

    private ShippingRepository shippingRepository;
    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {

        this.shippingRepository = shippingRepository;
    }

    public Shipping findById(long id) {
        log.info("Looking up transaction by id: {} ", id);
        Shipping shipping = shippingRepository.findById(id);
        return shipping;
    }

    public Shipping addShipping(Shipping shipping) {
        log.info("Adding a new shipping record - transaction: {}",shipping);
        return shippingRepository.save(shipping);
    }

    public List<Shipping> findAll(){
        log.info("Retrieving all the Shipping of existing transactions {} ");
        List<Shipping> shipping = shippingRepository.findAll();
        return shipping;
    }

    public Shipping updateShipping(Shipping shipping) {
        log.info("Updating a Shipping record:{}",shipping);
        return shippingRepository.save(shipping);
    }
}
