package edu.depaul.cdm.se452.Customer;

import edu.depaul.cdm.se452.accounts.model.Customer;
import edu.depaul.cdm.se452.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testingCustomerById(){
        Customer customer =customerRepository.findCustomerById(4);
        assertEquals(customer.getFirstName(),"Karthik");
    }
    @Test
    public void testingCustomerByEmail(){
        Customer customer =customerRepository.findCustomerByEmail("kchandr3@depaul.edu");
        assertEquals(customer.getFirstName(),"Karthik");
    }
    @Test
    public void testingAddCustomer(){
        Customer c1 = new Customer();
        c1.setId(5);
        c1.setFirstName("Testing");
        c1.setLastName("AddMethod");
        c1.setStreetAddress1("123 N Street");
        c1.setStreetAddress2("Apt 1");
        c1.setCity("Chicago");
        c1.setZip("60613");
        c1.setState("IL");
        c1.setPhoneNumber("1234567890");
        c1.setEmail("testadd@gmail.com");
        c1.setPassword("abc@123");


        String expected = "Customer(id=5, firstName=Testing, lastName=AddMethod, streetAddress1=123 N Street, streetAddress2=Apt 1, city=Chicago, zip=60613, state=IL, phoneNumber=1234567890, email=testadd@gmail.com, password=abc@123)";
        assertEquals(c1.toString(),expected);
    }

    @Test
    public void testUpdateCustomer(){
        Customer c2 =new Customer();
        c2.setId(5);
        c2.setFirstName("Testing");
        c2.setLastName("AddMethod");
        c2.setStreetAddress1("123 N Street");
        c2.setStreetAddress2("Apt 1");
        c2.setCity("Chicago");
        c2.setZip("60613");
        c2.setState("IL");
        c2.setPhoneNumber("1234567890");
        c2.setEmail("testadd@gmail.com");
        c2.setPassword("QWERTY@123");

        customerRepository.save(c2);

        Customer cust1 = customerRepository.findCustomerById(5);
        assertEquals(cust1.getPassword(),"QWERTY@123");

    }

    @Test
    public void testDeleteCustomer(){
        Customer custom2;
        custom2 = customerRepository.findCustomerById(5);
        var before = customerRepository.count();

        customerRepository.deleteById(custom2.getId());
        var after=customerRepository.count();

        assertEquals(before, after+1);
    }

}
