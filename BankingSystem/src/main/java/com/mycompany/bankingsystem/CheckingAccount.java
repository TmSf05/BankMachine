/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    private double overdraftFee;

    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit, double overdraftFee) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            if (balance < 0) {
                balance -= overdraftFee;
                System.out.println("Overdraft fee charged: " + overdraftFee);
            }
            transactionHistory.add("Withdrew: " + amount + " (Overdraft used)");
        } else {
            throw new InsufficientFundsException("Insufficient funds, even with overdraft.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Checking Account - Account Number: " + accountNumber + ", Balance: " + balance + ", Overdraft Limit: " + overdraftLimit + ", Overdraft Fee: " + overdraftFee);
    }
}
