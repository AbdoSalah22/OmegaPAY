import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String name;
    private String email;
    private String password;
    private Card card;
    private double balance;
    protected ArrayList<Transaction> transactions;
    protected ArrayList<Bill> bills;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public Account(double balance) {
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public Account(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.card = new Card();
        this.transactions = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return this.balance;
    }

    public Card getCard() {
        return card;
    }

    public void deposit(double amount) {
        this.balance += amount;
        Transaction depositTransaction = new Transaction(amount, new Date(), "Deposit");
        this.transactions.add(depositTransaction);
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            Transaction withdrawTransaction = new Transaction(amount, new Date(), "Withdrawal");
            this.transactions.add(withdrawTransaction);
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(double amount, Account toAccount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            Transaction transferTransaction = new Transaction(amount, new Date(), "Transfer");
            this.transactions.add(transferTransaction);
            toAccount.deposit(amount);
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }

    public void payBill(Bill bill) {
        if (bills == null) {
            System.out.println("No bills to pay.");
            return;
        }
        if (this.balance >= bill.getAmount()) {
            this.balance -= bill.getAmount();
            bills.remove(bill);
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }

    public void payAllBills() {
        if (bills == null) {
            System.out.println("No bills to pay.");
            return;
        }
        double sumBills = 0.0;
        for (int i = 0; i < bills.size(); i++) {
            sumBills += bills.get(i).getAmount();
            if (sumBills > this.balance) {
                System.out.println("Insufficient balance.");
                return;
            }
        }
        this.balance -= sumBills;
        bills.clear();
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return this.transactions;
    }

    public ArrayList<Bill> getListOfBills() {
        return this.bills;
    }

}
