/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Applied Interest: " + interest);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account - Account Number: " + accountNumber + ", Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }

    void withdraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

