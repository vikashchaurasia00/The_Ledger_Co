package com.example.geektrust.services;

public interface LoanService {

    void takeLoan(String bankName, String borrowerName, Double amount, Float interest, Integer time);

    void loanPayment(String bankName, String borrowerName, Double amount, Integer emiNumber);

    void loanBalance(String bankName, String borrowerName, Integer noOfEmiLeft);
}
