import org.junit.jupiter.api.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CardTest {
    private Card card;

    @BeforeEach
    public void setUp() {
        card = new Card(1234567890123456L, 123, new Date());
    }

    @Test
    public void testGetCardNumber() {
        assertEquals(1234567890123456L, card.getCardNumber());
    }

    @Test
    public void testSetCardNumber() {
        card.setCardNumber(9876543210987654L);
        assertEquals(9876543210987654L, card.getCardNumber());
    }

    @Test
    public void testGetCvv() {
        assertEquals(123, card.getCvv());
    }

    @Test
    public void testSetCvv() {
        card.setCvv(456);
        assertEquals(456, card.getCvv());
    }

    @Test
    public void testGetExpirationDate() {
        assertNotNull(card.getExpirationDate());
    }

    @Test
    public void testSetExpirationDate() {
        Date newDate = new Date();
        card.setExpirationDate(newDate);
        assertEquals(newDate, card.getExpirationDate());
    }

    @Test
    @Order(4)
    @DisplayName("Check Number of digits")
    public void testHas16Digits() {
        assertTrue(card.has16Digits(1234567890123456L));
        assertFalse(card.has16Digits(123456789012345L));
        assertFalse(card.has16Digits(12345678901234567L));
    }

    @Test
    @Order(1)
    @DisplayName("Check Visa")
    public void testGetCardType1() {
        assertNotEquals("Visa", card.getCardType(1234567890123456L));
    }

    @Test
    @Order(2)
    @DisplayName("Check MasterCard")
    public void testGetCardType2() {
        assertEquals("MasterCard", card.getCardType(5234567890123456L));
    }

    @Test
    @Order(3)
    @DisplayName("Check Invalid")
    public void testGetCardType3() throws InterruptedException {
        assertEquals("Invalid", card.getCardType(123456789012345L));
    }
}