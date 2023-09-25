package com.example.geektrust;
import com.example.geektrust.services.LoanService;
import com.example.geektrust.services.LoanServiceImpl;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LoanService loanService = new LoanServiceImpl();
        // Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream("sample_input/input1.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String line = sc.nextLine();
                String[] commandArgs = line.split(" ");
                String bankName = commandArgs[1];
                String borrowerName = commandArgs[2];
                if(commandArgs[0].equals("LOAN")){
                    Double amount = Double.parseDouble(commandArgs[3]);
                    Float interest = Float.parseFloat(commandArgs[4]);
                    Integer time = Integer.parseInt(commandArgs[5]);
                    loanService.takeLoan(bankName, borrowerName, amount, interest, time);
                }
                else if(commandArgs[0].equals("BALANCE")){
                    Integer noOfEmi = Integer.parseInt(commandArgs[3]);
                    loanService.loanBalance(bankName, borrowerName, noOfEmi);
                }
                else if(commandArgs[0].equals("PAYMENT")){
                    Double amount = Double.parseDouble(commandArgs[3]);
                    Integer emiNumber = Integer.parseInt(commandArgs[4]);
                    loanService.loanPayment(bankName, borrowerName, amount, emiNumber);
                }
                else{
                    System.out.println("Invalid command ... ");
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println("Failure... ");
        }

    }
}
