import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;

//Run full class for integration testing between classes: Account, Bill, Transaction
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountTransactionTest {

    private Account account1;
    private Account account2;
    private Bill bill1;
    private Bill bill2;
    private Bill bill3;
    private Bill bill4;

    @BeforeAll
    public void setUp() {
        System.out.println("Welcome User!");
        account1 = new Account(100.0);
        account2 = new Account(0.0);
        bill1 = new Bill("Electricity", 50.0);
        bill2 = new Bill("Water", 25.0);
        bill3 = new Bill("Gas", 10.0);
        bill4 = new Bill("Tax", 5.0);

        account1.bills.add(bill1);
        account1.bills.add(bill2);
        account1.bills.add(bill3);
        account1.bills.add(bill4);

    }

    @Test
    @Order(1)
    public void testDeposit() {
        account1.deposit(50.0);
        assertEquals(150.0, account1.getBalance(), 0.01);
        assertEquals(1, account1.getListOfTransactions().size());
        assertEquals("Deposit", account1.getListOfTransactions().get(0).getType());
    }

    @Test
    @Order(2)
    public void testWithdraw() {
        account1.withdraw(50.0);
        assertEquals(100.0, account1.getBalance(), 0.01);
        assertEquals(2, account1.getListOfTransactions().size());
        assertEquals("Withdrawal", account1.getListOfTransactions().get(1).getType());
    }

    @Test
    @Order(3)
    public void testWithdrawWithInsufficientBalance() {
        account1.withdraw(200.0);
        assertEquals(100.0, account1.getBalance(), 0.01);
        assertEquals(2, account1.getListOfTransactions().size());
    }

    @Test
    @Order(4)
    public void testTransfer() {
        account1.transfer(50.0, account2);
        assertEquals(50.0, account1.getBalance(), 0.01);
        assertEquals(50.0, account2.getBalance(), 0.01);
        assertEquals(3, account1.getListOfTransactions().size());
        assertEquals("Transfer", account1.getListOfTransactions().get(2).getType());
        assertEquals(1, account2.getListOfTransactions().size());
        assertEquals("Deposit", account2.getListOfTransactions().get(0).getType());
    }

    @Test
    @Order(5)
    public void testTransferWithInsufficientBalance() {
        account1.transfer(200.0, account2);
        assertEquals(50.0, account1.getBalance(), 0.01);
        assertEquals(50.0, account2.getBalance(), 0.01);
        assertEquals(3, account1.getListOfTransactions().size());
        assertEquals(1, account2.getListOfTransactions().size());
    }

    @Test
    @Order(6)
    public void testPayBill() {
        assertEquals(50.0, bill1.getAmount(), 0.01);
        account1.payBill(bill1);
        assertEquals(0.0, account1.getBalance(), 0.01);
        assertEquals(3, account1.getListOfBills().size());
    }

    @Test
    @Order(7)
    public void testPayBillWithInsufficientBalance() {
        assertEquals(25.0, bill2.getAmount(), 0.01);
        account1.payBill(bill1);
        assertEquals(0.0, account1.getBalance(), 0.01);
        assertEquals(3, account1.getListOfBills().size());
    }

    @Test
    @Order(8)
    public void testBigDeposit() {
        account1.deposit(2000.0);
        assertEquals(2000.0, account1.getBalance(), 0.01);
        assertEquals(4, account1.getListOfTransactions().size());
        assertEquals("Deposit", account1.getListOfTransactions().get(0).getType());
    }

    @Test
    @Order(9)
    public void testPayAllBills() {
        account1.payAllBills();
        assertEquals(1960.0, account1.getBalance(), 0.01);
        assertEquals(0, account1.bills.size());
    }

    @Test
    @Order(10)
    public void testPayAllBillsWithInsufficientBalance() {
        account1.bills.add(new Bill("Internet", 3000.0));
        account1.payAllBills();
        assertEquals(1960.0, account1.getBalance(), 0.01);
        assertEquals(1, account1.bills.size());
    }
}