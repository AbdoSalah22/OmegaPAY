import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {

    private Bill bill;

    @BeforeEach
    public void setUp() {
        bill = new Bill("Electricity", 100.0);
    }

    @Test
    @Order(1)
    @DisplayName("Get Bill Name")
    public void testGetName() {
        assertEquals("Electricity", bill.getName());
    }

    @Test
    @Order(2)
    @DisplayName("Set Bill Name")
    public void testSetName() {
        bill.setName("Water");
        assertEquals("Water", bill.getName());
    }

    @Test
    @Order(3)
    @DisplayName("Get Bill Name After Set")
    public void testGetNameAfterSet() {
        bill.setName("Water");
        assertEquals("Water", bill.getName());
    }

    @Test
    @Order(4)
    @DisplayName("Get Bill Amount")
    public void testGetAmount() {
        assertEquals(100.0, bill.getAmount(), 0.01);
    }

    @Test
    @Order(5)
    @DisplayName("Set Bill Amount")
    public void testSetAmount() {
        bill.setAmount(200.0);
        assertEquals(200.0, bill.getAmount(), 0.01);
    }

    @Test
    @Order(6)
    @DisplayName("Get Bill Amount After Set")
    public void testGetAmountAfterSet() {
        bill.setAmount(50.0);
        assertEquals(50.0, bill.getAmount());
    }
}