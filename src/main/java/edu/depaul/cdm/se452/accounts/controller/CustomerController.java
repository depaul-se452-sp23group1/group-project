package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
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

    @PostMapping(consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer newCustomer) {return customerService.addCustomer(newCustomer);}

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) { return  customerService.updateCustomer(customer);}

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id) {
        Customer cust = new Customer();
        cust = customerService.findById(id);
        if (cust == null){
            log.info("No customer found for:{}",id);
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(id);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
}
