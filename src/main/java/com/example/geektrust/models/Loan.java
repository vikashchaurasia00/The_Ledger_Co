package com.example.geektrust.models;

public class Loan {
    private Double principalAmount;
    private Float interestRate;
    private Integer timePeriod;
    private Double compoundAmount;
    private EmiDetails emiDetails = null;

    public Loan(Double principalAmount, Float interestRate, Integer timePeriod){
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.timePeriod = timePeriod;
    }

    private Double calculateInterestAmount(){
        return (this.principalAmount * this.interestRate * this.timePeriod) / 100.0 ;
    }

    private void setCompoundAmount(){
        this.compoundAmount = this.principalAmount + this.calculateInterestAmount();
    }

    public void calculateEmi(){
        setCompoundAmount();
        Double totalEmiAmount = this.compoundAmount;
        Double monthlyEmiAmount = totalEmiAmount / ( this.timePeriod * 12);
        Integer noOfEmiLeft = (int) (totalEmiAmount / monthlyEmiAmount);
        this.emiDetails = new EmiDetails(totalEmiAmount, monthlyEmiAmount, noOfEmiLeft);
    }

    public void updateLoan(Double amount, Integer emiNumber){
        this.emiDetails.updateEmi(amount, emiNumber);
    }
    public EmiDetails getEmiDetails(){
        return this.emiDetails;
    }
}
