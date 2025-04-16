/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        // Create Bank and BankSystem
        Bank bank = new Bank();
        BankSystem bankSystem = new BankSystem();
        
        // Add users (admin and customer)
        bankSystem.addUser("admin", "admin123", Role.ADMIN);
        bankSystem.addUser("john_doe", "password123", Role.CUSTOMER);

        // Authenticate admin
        if (bankSystem.authenticateUser("admin", "admin123")) {
            System.out.println("Admin authenticated.");
        }

        // Create bank accounts
        SavingsAccount savingsAccount = new SavingsAccount("SA001", "John Doe", 1000.0, 5.0);
        CheckingAccount checkingAccount = new CheckingAccount("CA001", "Jane Smith", 2000.0, 5000.0, 30.0);
        
        bank.enrollAccount(savingsAccount);
        bank.enrollAccount(checkingAccount);

        // Admin displays all accounts
        bank.displayAllAccounts();

        // Customer checks their balance and transaction history
        savingsAccount.deposit(200);
        savingsAccount.withdraw(100);
        savingsAccount.printTransactionHistory();
    }
}
