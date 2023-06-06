package edu.depaul.cdm.se452.accounts.controller;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/email/{email}", produces = "application/json")
    @Operation(summary = "Get Customer details by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer record found"),
    })
    public Customer getCustomer(@PathVariable String email) {
        return customerService.findByEmail(email);}

    @GetMapping(value = "/id/{id}", produces = "application/json")
    @Operation(summary = "Get Customer details by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer record found"),
    })
    public Customer getCustomer(@PathVariable long id) {
        return customerService.findById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Adds a new Customer record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer record created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid URL")
    })
    public Customer addCustomer(@RequestBody Customer newCustomer) {return customerService.addCustomer(newCustomer);}

    @PutMapping
    @Operation(summary = "Update Customer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully updated Customer details"),
            @ApiResponse(responseCode = "500",description = "Customer details record not found")
    })
    public Customer updateCustomer(@RequestBody Customer customer) { return  customerService.updateCustomer(customer);}

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete Customer record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Deleted customer record"),
            @ApiResponse(responseCode = "500",description = " Customer record not found")
    })
    public Customer deleteCustomer(@PathVariable long id) {
        Customer cust = new Customer();
        cust = customerService.findById(id);
        if (cust == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND).getBody();
        }
        customerService.deleteCustomer(id);
        return new ResponseEntity<Customer>(HttpStatus.OK).getBody();
    }
}
