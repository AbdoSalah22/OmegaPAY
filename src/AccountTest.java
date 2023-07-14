import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTest {

    private Account account = new Account("Alice", "alice@example.com", "password", 100.0);

    @Test
    public void testSetName() {
        account.setName("Bob");
        assertEquals("Bob", account.getName());
    }

    @Test
    public void testSetEmail() {
        account.setEmail("bob@example.com");
        assertEquals("bob@example.com", account.getEmail());
    }

    @Test
    public void testSetPassword() {
        account.setPassword("newpassword");
        assertEquals("newpassword", account.getPassword());
    }

    @Test
    public void testGetName() {
        assertEquals("Alice", account.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("alice@example.com", account.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", account.getPassword());
    }

    @Test
    @Order(1)
    public void testGetBalance() {
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testGetListOfTransactions() {
        assertNotNull(account.getListOfTransactions());
    }

    @Test
    public void testGetListOfBills() {
        assertNull(account.getListOfBills());
    }

}