package com.example.geektrust.services;

import com.example.geektrust.models.Bank;
import com.example.geektrust.models.EmiDetails;
import com.example.geektrust.models.Loan;

import java.util.HashMap;
import java.util.Map;

public class LoanServiceImpl implements LoanService {

    Map<String, Bank> banks;

    public LoanServiceImpl(){
        super();
        this.banks = new HashMap<String, Bank>();
    }

    @Override
    public void takeLoan(String bankName, String borrowerName, Double amount, Float interest, Integer time) {
        Bank bank = null;
        if(banks.get(bankName) == null){
            bank = new Bank(bankName);
            this.banks.put(bankName, bank);
        }
        else {
            bank = this.banks.get(bankName);
        }
        bank.addLoanToBank(borrowerName, amount, interest, time);
    }

    @Override
    public void loanPayment(String bankName, String borrowerName, Double amount, Integer emiNumber) {
        Bank bank = banks.get(bankName);
        Loan loan = bank.getLoan(borrowerName);
        EmiDetails emiDetails = loan.getEmiDetails();
        loan.updateLoan(amount, emiNumber);
    }

    @Override
    public void loanBalance(String bankName, String borrowerName, Integer noOfEmi) {
        Bank bank = this.banks.get(bankName);
        Loan loan = bank.getLoan(borrowerName);
        EmiDetails emiDetails = loan.getEmiDetails();
        Double totalEmiAmountPaid = emiDetails.getTotalEmiAmountPaid();
        Integer noOfEmiLeft = emiDetails.getNoOfEmiLeft();
        System.out.println(bankName + " " + borrowerName + " " + totalEmiAmountPaid + " " + noOfEmiLeft);
    }
}
