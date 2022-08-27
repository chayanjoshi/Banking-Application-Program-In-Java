package com.chayan.BankApplication;
// Checking Account
public class CheckingAccount extends Account {

    // Default Transaction Fee
    private static double FEE = 2.5;

    // default constructor
    public CheckingAccount() {
        super();
    }

    /*
     * Parameter constructor to initialize CheckingAccount
     * with a custom Account Number and a Customer Transaction
     * Fee. 
     */
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    /*
     * Function to deposit funds into the account as long as the amount parameter is > 0
     */
    public void deposit(double amount) {

        // First Check amount
        if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            // Apply Transaction Fee
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    public void viewBalance(int accountNumber) {
        System.out.println("Your Current Balance Is: " + balance);
    }

    /*
     * Function to withdraw funds from the Account as long as 1. Amount to withdraw
     * must be > 0 2. Amount to withdraw must be <= balance
     */
    public void withdraw(double amount) {

        // Same check
        if(amount > 0) {
            // Check sufficient balance
            if((amount+FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}