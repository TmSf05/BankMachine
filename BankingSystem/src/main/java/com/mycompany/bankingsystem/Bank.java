/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, BankAccount> accounts;
    private double totalBankBalance;

    public Bank() {
        accounts = new HashMap<>();
        totalBankBalance = 0;
    }

    public void enrollAccount(BankAccount account) {
        accounts.put(account.accountNumber, account);
        totalBankBalance += account.getBalance();
    }

    public void displayTotalFunds() {
        System.out.println("Total funds in the bank: " + totalBankBalance);
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts.values()) {
            account.displayAccountDetails();
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

