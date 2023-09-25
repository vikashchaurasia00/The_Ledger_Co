package com.example.geektrust.models;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private Map<String, Loan> loans = new HashMap<String, Loan>();

    public Bank(String name){
        this.name = name;
    }

    public boolean addLoanToBank(String borrowerName, Double loanAmount, Float rate, Integer period){
        Loan loan = new Loan(loanAmount, rate, period);
        loan.calculateEmi();
        loans.put(borrowerName, loan);
        return true;
    }

    public Loan getLoan(String borrowerName){
        return loans.get(borrowerName);
    }
}
