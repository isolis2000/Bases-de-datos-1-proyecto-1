package pojo;

import java.util.ArrayList;

public class SavingsAccountList {
    private ArrayList<SavingsAccountView> savingsAccountViews = new ArrayList<>();

    public ArrayList<SavingsAccountView> getIndividualStatements() {
        return savingsAccountViews;
    }

    public void setIndividualStatements(ArrayList<SavingsAccountView> savingsAccountViews) {
        this.savingsAccountViews = savingsAccountViews;
    }

    public void addToIndividualStatements(SavingsAccountView savingsAccountView) {
        this.savingsAccountViews.add(savingsAccountView);
    }
}
