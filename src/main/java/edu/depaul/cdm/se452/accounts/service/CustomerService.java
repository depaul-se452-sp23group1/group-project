package edu.depaul.cdm.se452.accounts.service;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByEmail(String email) {
        log.info("Looking up customer by email: {}", email);
        return customerRepository.findCustomerByEmail(email);
    }

    public Customer findById(long id){
        log.info("Looking up customer by id: {}", id);
        return customerRepository.findCustomerById(id);
    }
    public Customer addCustomer(Customer newCustomer) {
        log.info("Adding a customer: {}",newCustomer);
        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(Customer customer) {
        if(customerRepository.findCustomerById(customer.getId())!=null){
            log.info("Updating a Customer:{}",customer);
            return customerRepository.save(customer);
        }
        log.info("No such customer found so adding a new customer:{}",customer);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(long id) {
        log.info("Deleting the customer info:{}",id);
        customerRepository.deleteById(id);
    }
}
