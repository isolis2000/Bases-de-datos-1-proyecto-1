package pojo;

import java.util.ArrayList;

public class AccountList {
    private ArrayList<Account> accounts = new ArrayList<>();

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addToAccounts(Account account) {
        this.accounts.add(account);
    }
}
