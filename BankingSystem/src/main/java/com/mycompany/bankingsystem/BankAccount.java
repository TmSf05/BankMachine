/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolderName + ": ");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public abstract void displayAccountDetails();
}

