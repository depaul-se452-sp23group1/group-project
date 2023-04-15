package edu.depaul.cdm.se452.transaction.controller;

import edu.depaul.cdm.se452.transaction.model.Shipping;
import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    ShippingService shippingService;

 //   @GetMapping(value="/id/{id}", produces = "application/json")
  //  public Shipping getShippingbyTransactionId(@PathVariable long tr_id) {
   //     return shippingService.findById??(tr_id);
   // }

    @GetMapping(value="/id/{id}", produces = "application/json")
    public Shipping getShippingbyId(@PathVariable long id) {
        return shippingService.findById(id);
    }

    @PostMapping
    public Shipping addShipping(@RequestBody Shipping newShipping) {
        return shippingService.addShipping(newShipping);
    }

    @GetMapping("/")
    public List<Shipping> getAllShipping() {
        List<Shipping> shippings = shippingService.findAll();
        return shippings;
    }
}
