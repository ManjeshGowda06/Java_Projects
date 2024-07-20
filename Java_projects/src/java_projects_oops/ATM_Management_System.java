package java_projects_oops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private int pin;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void displayMiniStatement() {
        System.out.println("Mini Statement for Account " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}

class ATM {
    private Map<String, BankAccount> accounts;

    public ATM() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Check Balance");
        System.out.println("3. Change PIN");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
    }

    public void processTransaction(String accountNumber, int pin, int option) {
        BankAccount account = accounts.get(accountNumber);

        if (account != null && account.verifyPin(pin)) {
            switch (option) {
                case 1:
                    double withdrawAmount = getWithdrawalAmount();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 3:
                    int newPin = getNewPin();
                    account.changePin(newPin);
                    break;
                case 4:
                    account.displayMiniStatement();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    private double getWithdrawalAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        return scanner.nextDouble();
    }

    private int getNewPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new PIN: ");
        return scanner.nextInt();
    }
}

public class ATM_Management_System {
    public static void main(String[] args) {
        ATM atm = new ATM();

        // Adding sample account
        BankAccount account = new BankAccount("123456", "John Doe", 1234, 1000);
        atm.addAccount(account);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.next();

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            atm.displayMenu();
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            atm.processTransaction(accountNumber, pin, option);
        }
    }
}