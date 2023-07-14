import java.util.ArrayList;
import java.util.Collection;

public class OnlineBanking {
    private ArrayList<Account> accounts;

    public OnlineBanking() {
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public Account getAccountByCard(long cardnumber) {
        for (Account account : this.accounts) {
            if (account.getCard().getCardNumber() == cardnumber) {
                return account;
            }
        }
        System.out.println("No Account Found with this Card Number");
        return null;
    }

    public void addBillToAccount(Bill bill, Account account){
        account.bills.add(bill);
    }


}