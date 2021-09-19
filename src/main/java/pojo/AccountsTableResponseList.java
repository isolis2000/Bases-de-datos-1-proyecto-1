package pojo;

import java.util.List;

public class AccountsTableResponseList {
    private List<AccountsTableResponse> accountsTableResponses;

    public List<AccountsTableResponse> getAccountsTableResponses() {
        return accountsTableResponses;
    }

    public void setAccountsTableResponses(List<AccountsTableResponse> accountsTableResponses) {
        this.accountsTableResponses = accountsTableResponses;
    }

    public void addToAccountsTableResponses(AccountsTableResponse accountsTableResponse) {
        this.accountsTableResponses.add(accountsTableResponse);
    }
}
