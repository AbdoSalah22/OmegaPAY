import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OnlineBankingTest {
    private OnlineBanking onlineBanking;
    private Account account1;
    private Account account2;
    private Bill bill1;
    private Bill bill2;


    @BeforeEach
    public void setUp() {
        onlineBanking = new OnlineBanking();

        account1 = new Account("John Doe", "john.doe@example.com", "password", 1000.0);
        account2 = new Account("Jane Doe", "jane.doe@example.com", "password", 2000.0);
        bill1 = new Bill("Electricity", 500.0);
        bill2 = new Bill("Water", 750.0);
        onlineBanking.addAccount(account1);
        onlineBanking.addAccount(account2);
    }

    @Test
    public void testAddAccount() {
        Account account3 = new Account("Mary Smith", "mary.smith@example.com", "password", 500.0);
        onlineBanking.addAccount(account3);
        assertEquals(3, onlineBanking.getAccounts().size());
        assertTrue(onlineBanking.getAccounts().contains(account3));
    }

    @Test
    public void testRemoveAccount() {
        onlineBanking.removeAccount(account1);
        assertEquals(1, onlineBanking.getAccounts().size());
        assertFalse(onlineBanking.getAccounts().contains(account1));
    }

    @RepeatedTest(10)
    public void testGetAccountByCard() {
        System.out.println(account2.getCard().getCardNumber());
        Account result = onlineBanking.getAccountByCard(account2.getCard().getCardNumber());
        assertEquals(account2, result);
    }

    @Test
    public void testAddBillToAccount() {
        onlineBanking.addBillToAccount(bill1, account1);
        onlineBanking.addBillToAccount(bill2, account1);
        assertEquals(2, account1.getListOfBills().size());
        assertTrue(account1.getListOfBills().contains(bill1));
        assertTrue(account1.getListOfBills().contains(bill2));
        }
    }