package edu.depaul.cdm.se452.Transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.cdm.se452.transaction.model.Transactions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TransactionTest {
    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
        Transactions transactions = new Transactions();
        transactions.setTrId(1);
        transactions.setTrAmt(100);
        transactions.setCcNumber(123456789);
        transactions.setCcName("Bram");
        transactions.setStatus("Success");

        String expectedOutput= "Transactions(trId=1, trAmt=100.0, ccNumber=123456789, ccExpDate=null, ccName=Bram, status=Success)";
        assertEquals(expectedOutput, transactions.toString());
    }
}
