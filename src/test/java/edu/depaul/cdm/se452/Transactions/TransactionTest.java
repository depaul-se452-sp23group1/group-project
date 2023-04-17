package edu.depaul.cdm.se452.Transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.cdm.se452.transaction.model.Transactions;
import edu.depaul.cdm.se452.transaction.repository.TransactionsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TransactionTest {
    @Autowired
    private TransactionsRepository repository;
    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
        Transactions transactions = new Transactions();
        transactions.setTrId(1);
        transactions.setTrAmt(100);
        transactions.setCcNumber(123456789);
        transactions.setCcName("Bram");
        transactions.setStatus("Success");

        String expectedOutput= "Transactions(trId=1, trDate=null, trAmt=100.0, ccNumber=123456789, ccExpDate=null, ccName=Bram, status=Success)";
        assertEquals(expectedOutput, transactions.toString());
    }

    @Test
    public void testAddTransaction(){
        Transactions transactions = new Transactions();
        transactions.setTrId(7);
        transactions.setTrAmt(100);
        transactions.setCcNumber(123456789);
        transactions.setCcName("test");
        transactions.setStatus("Success");

        var b4Add = repository.count();
        repository.save(transactions);
        var afterAdd = repository.count();

        assertEquals(b4Add + 1, afterAdd);

    }

    @Test
    public void testFindByID(){
        Transactions transactions = repository.findById(1);
        assertEquals(transactions.getTrAmt(), 25);
    }

    @Test
    public void testFindAll(){
        List<Transactions> transactions = repository.findAll();
        var totalCount = repository.count();
        assertEquals(transactions.size(), totalCount);
    }

    @Test
    public void testUpdateTransaction() {
        Transactions transactions = new Transactions();
        transactions.setTrId(10);
        transactions.setTrAmt(9090);
        repository.save(transactions);

        Transactions transactions1 = repository.findById(10);
        //check update
        assertEquals(transactions1.getTrAmt(), 9090);

    }

    @Test
    public void testDeleteTransaction(){

        var b4Delete = repository.count();
        repository.deleteById(6);
        var afterDelete = repository.count();

        assertEquals(b4Delete, afterDelete+1);

    }
}
