package banking;

import java.util.Scanner;

import banking.account.BusinessAccount;
import banking.account.PersonalAccount;
import banking.account.SavingsAccount;
import banking.account.Exceptions.AccountException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Account Creation System");

        // Prompt user for account details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();

        // Demonstrate the creation of each type of account
        try {
            System.out.println("\nCreating Personal Account...");
            PersonalAccount personalAccount = new PersonalAccount(generateAccountNumber(), name, email, phoneNumber, initialBalance);
            System.out.println("Personal Account created successfully!");
            System.out.println(personalAccount);
        } catch (AccountException e) {
            System.err.println("Failed to create Personal Account: " + e.getMessage());
        }

        try {
            System.out.println("\nCreating Savings Account...");
            SavingsAccount savingsAccount = new SavingsAccount(generateAccountNumber(), name, email, phoneNumber, initialBalance);
            System.out.println("Savings Account created successfully!");
            System.out.println(savingsAccount);
        } catch (AccountException e) {
            System.err.println("Failed to create Savings Account: " + e.getMessage());
        }

        try {
            System.out.println("\nCreating Business Account...");
            BusinessAccount businessAccount = new BusinessAccount(generateAccountNumber(), name, email, phoneNumber, initialBalance);
            System.out.println("Business Account created successfully!");
            System.out.println(businessAccount);
        } catch (AccountException e) {
            System.err.println("Failed to create Business Account: " + e.getMessage());
        }

        scanner.close();
    }

    private static String generateAccountNumber() {
        return String.format("%018d", (long) (Math.random() * 1e18));
    }
}
