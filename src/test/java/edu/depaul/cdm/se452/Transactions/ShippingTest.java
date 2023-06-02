package edu.depaul.cdm.se452.Transactions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.cdm.se452.transaction.Shipping;
import edu.depaul.cdm.se452.transaction.Transactions;
import edu.depaul.cdm.se452.transaction.ShippingRepository;
import edu.depaul.cdm.se452.transaction.TransactionsRepository;
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
       Transactions transactions = new Transactions();
       transactions.setTrId(50);
       shipping.setTrId(50);
       shipping.setTransactions(transactions);

       String expectedOutput = "Shipping(shpId=1, transactions=Transactions(trId=50, trAmt=0.0, ccNumber=0, ccExpDate=null, ccName=null, status=null), shpMethod=Express, shpStatus=Success, address1=555 W Qwerty St, address2=Apt 1808, city=Chicago, zip=60661, state=IL, trId=50)";
       assertEquals(expectedOutput, shipping.toString());
    }
/**
    @Test
    public void testAddShipping(){
        Shipping shipping = new Shipping();
        shipping.setShpId(3);
        shipping.setShpMethod("Express");
        shipping.setShpStatus("Success");
        shipping.setAddress1("555 W Qwerty St");
        shipping.setAddress2("Apt 1808");
        shipping.setCity("Chicago");
        shipping.setState("IL");
        shipping.setZip("60661");
        shipping.setTrId(3);

        var b4Add = repository.count();
        repository.save(shipping);
        var afterAdd = repository.count();

        assertEquals(b4Add + 1, afterAdd);
    }
    @Test
    public void testFindByID(){
        Shipping shipping = repository.findById(1);
        assertEquals(shipping.getCity(), "chicago");
    }

    @Test
    public void testFindAll(){
        List<Shipping> shippings = repository.findAll();
        var totalCount = repository.count();
        assertEquals(shippings.size(), totalCount);
    }**/

}
