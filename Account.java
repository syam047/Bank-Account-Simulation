import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount + " | New Balance: " + balance);
            System.out.println("Withdrawn " + amount + " successfully.");
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayAccountDetails() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
    }
}
