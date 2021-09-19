package pojo;

import java.util.*;

public class AccountsTableResponseList {
    private ArrayList<AccountsTableResponse> accountsTableResponses = new ArrayList<>();

    public ArrayList<AccountsTableResponse> getAccountsTableResponses() {
        return accountsTableResponses;
    }

    public void setAccountsTableResponses(ArrayList<AccountsTableResponse> accountsTableResponses) {
        this.accountsTableResponses = accountsTableResponses;
    }

    public void addToAccountsTableResponses(AccountsTableResponse accountsTableResponse) {
        this.accountsTableResponses.add(accountsTableResponse);
    }
}
