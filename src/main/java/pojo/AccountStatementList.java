package pojo;

import java.util.ArrayList;

public class AccountStatementList {
    private ArrayList<AccountStatement> accountStatementArrayList = new ArrayList<>();

    public ArrayList<AccountStatement> getAccountStatementArrayList() {
        return accountStatementArrayList;
    }

    public void setAccountStatementArrayList(ArrayList<AccountStatement> accountStatementArrayList) {
        this.accountStatementArrayList = accountStatementArrayList;
    }

    public void addToAccountsTableResponses(AccountStatement accountStatement) {
        this.accountStatementArrayList.add(accountStatement);
    }
}
