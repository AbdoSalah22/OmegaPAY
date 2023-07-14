import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    @DisplayName("Test Transaction Getters")
    public void testTransactionGetters() {
        double amount = 100.0;
        Date date = new Date();
        String type = "deposit";
        Transaction transaction = new Transaction(amount, date, type);
        assertEquals(amount, transaction.getAmount(), 0.01);
        assertEquals(date, transaction.getDate());
        assertEquals(type, transaction.getType());
    }
}