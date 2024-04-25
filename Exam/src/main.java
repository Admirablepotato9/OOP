import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Sell all flight available at least 10 destinations");
            System.out.println("2. Buy a ticket to a given destination, by providing its personal details");
            System.out.println("3. Retrieve the flight information by providing the ticket-id");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                case 4
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }