package edu.depaul.cdm.se452.Transactions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.cdm.se452.transaction.model.Shipping;
import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.repository.ShippingRepository;
import edu.depaul.cdm.se452.transaction.repository.TransactionsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ShippingTest {

    @Autowired
    private ShippingRepository repository;

    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
       Shipping shipping = new Shipping();
       shipping.setShpId(1);
       shipping.setShpMethod("Express");
       shipping.setShpStatus("Success");
       shipping.setAddress1("555 W Qwerty St");
       shipping.setAddress2("Apt 1808");
       shipping.setCity("Chicago");
       shipping.setState("IL");
       shipping.setZip("60661");

        String expectedOutput = "Shipping(shpId=1, shpMethod=Express, shpStatus=Success, address1=555 W Qwerty St, address2=Apt 1808, city=Chicago, zip=60661, state=IL, trId=0)";
       assertEquals(expectedOutput, shipping.toString());
    }

    @Test
    public void testAddShipping(){
        Shipping shipping = new Shipping();
        shipping.setShpId(2);
        shipping.setShpMethod("Express");
        shipping.setShpStatus("Success");
        shipping.setAddress1("555 W Qwerty St");
        shipping.setAddress2("Apt 1808");
        shipping.setCity("Chicago");
        shipping.setState("IL");
        shipping.setZip("60661");

        var b4Add = repository.count();
        repository.save(shipping);
        var afterAdd = repository.count();

        assertEquals(b4Add + 1, afterAdd);
    }
    @Test
    public void testFindByID(){
        Shipping shipping = repository.findById(1);
        assertEquals(shipping.getCity(), "Chicago");
    }

    @Test
    public void testFindAll(){
        List<Shipping> shippings = repository.findAll();
        var totalCount = repository.count();
        assertEquals(shippings.size(), totalCount);
    }
    }
