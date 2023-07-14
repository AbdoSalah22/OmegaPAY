import java.util.Date;

public class Transaction{
    private double amount;
    private Date date;
    private String type;

    public Transaction(double amount, Date date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }
}