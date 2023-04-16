package edu.depaul.cdm.se452.accounts.repository;

import edu.depaul.cdm.se452.accounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(long id);
    Customer findCustomerByEmail(String email);
    Customer deleteById(long id);
}
