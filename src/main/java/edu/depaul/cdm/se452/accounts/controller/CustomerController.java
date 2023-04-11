package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.model.User;
import edu.depaul.cdm.se452.accounts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/email/{email}", produces = "application/json")
    public Customer getCustomer(@PathVariable String email) {
        return customerService.findByEmail(email);}

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer newCustomer) {return customerService.addCustomer(newCustomer);}

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) { return  customerService.updateCustomer(customer);}

    @DeleteMapping
    public Customer deleteCustomer(@RequestBody long id) {return  customerService.deleteCustomer(id);}
}
