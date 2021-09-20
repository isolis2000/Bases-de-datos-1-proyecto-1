package pojo;

import java.util.ArrayList;

public class BeneficiaryList {
    private ArrayList<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

    public ArrayList<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(ArrayList<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void addToBeneficiaries(Beneficiary beneficiary) {
        this.beneficiaries.add(beneficiary);
    }
}
