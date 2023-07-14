import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Card {
    private long cardNumber;
    private int cvv;
    private Date expirationDate;

    public Card() {
        Random random = new Random();
        StringBuilder cardNumberBuilder = new StringBuilder();

        // Generate first digit (4 or 5)
        int firstDigit = 4 + random.nextInt(2);
        cardNumberBuilder.append(firstDigit);

        // Generate remaining 15 digits
        for (int i = 0; i < 15; i++) {
            int digit = random.nextInt(10);
            cardNumberBuilder.append(digit);
        }

        // Set card number
        this.cardNumber = Long.parseLong(cardNumberBuilder.toString());
        this.cvv = 100 + random.nextInt(900); // Generate a random CVV between 100 and 999

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3); // Set expiration date to 3 years from now
        this.expirationDate = calendar.getTime();
    }

    public Card(long cardNumber, int cvv, Date exdate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = exdate;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean has16Digits(long number) {
        // Get the number of digits in the number
        int numDigits = String.valueOf(number).length();
        return numDigits == 16;
    }

    public String getCardType(long number) {
        // Loop through the digits of the number until the first non-zero digit is found
        while (number >= 10) {
            number /= 10;
        }
        if (number == 4) return "Visa";
        else if (number == 5) return "MasterCard";
        else return "Invalid";
    }
}
