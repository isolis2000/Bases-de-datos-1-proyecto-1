package pojo;

import java.util.ArrayList;

public class IndividualStatementList {
    private ArrayList<IndividualStatement> individualStatements = new ArrayList<>();

    public ArrayList<IndividualStatement> getIndividualStatements() {
        return individualStatements;
    }

    public void setIndividualStatements(ArrayList<IndividualStatement> individualStatements) {
        this.individualStatements = individualStatements;
    }

    public void addToIndividualStatements(IndividualStatement individualStatement) {
        this.individualStatements.add(individualStatement);
    }
}
