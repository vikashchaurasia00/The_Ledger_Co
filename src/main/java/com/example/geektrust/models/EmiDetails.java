package com.example.geektrust.models;

public class EmiDetails {
    private Double totalEmiAmountLeft;
    private Double totalEmiAmountPaid;
    private Double monthlyEmiAmount;
    private Integer noOfEmiLeft;

    public EmiDetails(Double totalEmiAmountLeft, Double monthlyEmiAmount, Integer noOfEmiLeft){
        this.totalEmiAmountLeft = totalEmiAmountLeft;
        this.totalEmiAmountPaid = 0.0;
        this.monthlyEmiAmount = monthlyEmiAmount;
        this.noOfEmiLeft = noOfEmiLeft ;
    }

    private Double getTotalEmiAmountLeft(){
        return this.totalEmiAmountLeft;
    }

    public Double getTotalEmiAmountPaid(){
        return this.totalEmiAmountPaid;
    }
    private Double getMonthlyEmiAmount(){
        return this.monthlyEmiAmount;
    }

    public Integer getNoOfEmiLeft(){
        return this.noOfEmiLeft;
    }

    public void updateEmi(Double amount, Integer emiNumber){
        if(amount > monthlyEmiAmount){
            this.totalEmiAmountLeft = this.totalEmiAmountLeft - amount;
            this.totalEmiAmountPaid = this.totalEmiAmountPaid + amount;
            this.noOfEmiLeft--;
            monthlyEmiAmount = totalEmiAmountLeft / noOfEmiLeft;
        }
        else {
            this.noOfEmiLeft--;
            this.totalEmiAmountLeft = this.totalEmiAmountLeft - amount;
            this.totalEmiAmountPaid = this.totalEmiAmountPaid + amount;
        }
    }
}
