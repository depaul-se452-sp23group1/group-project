package edu.depaul.cdm.se452.Transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.cdm.se452.transaction.model.Transactions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
        Transactions transactions = new Transactions();
        transactions.setTrId(1);
        transactions.setTrAmt(100);

        String expectedOutput= "Transactions=(trId=1, trAmt=100)";
        assertEquals(expectedOutput, transactions.toString());

    }
}
