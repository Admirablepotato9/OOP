package exam2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            User sender = collectUserInfo(scanner, "Sender");

            User recipient = collectUserInfo(scanner, "Recipient");

            System.out.println("Are you sending a letter or a package? (Enter 'letter' or 'package')");
            String itemType = scanner.nextLine().trim().toLowerCase();

            Package mailItem;
            if (itemType.equals("letter")) {
                mailItem = new Letter(sender, recipient);
            } else if (itemType.equals("package")) {
                System.out.println("Enter the weight of the package (in kg):");
                double weight = Double.parseDouble(scanner.nextLine().trim());

                System.out.println("Enter the contents of the package:");
                String description = scanner.nextLine().trim();

                mailItem = new MailItem(sender, recipient, weight, description);
            } else {
                System.out.println("Invalid item type. Please start again.");
                return;
            }

            System.out.println("Enter the destination (OAX, QROO, MOR, QRO, SIN):");
            String destinationCode = scanner.nextLine().trim().toUpperCase();
            DistributionPoints destination = DistributionPoints.valueOf(destinationCode);

            LocalDateTime arrivalTime = mailItem.getEstimateArrival(destination.getArrivalTime());
            double price = mailItem.estimatePrice(destination, mailItem instanceof MailItem ? ((MailItem) mailItem).getWeight() : 1.0);

            System.out.println("Estimated arrival time: " + arrivalTime);
            System.out.println("Estimated cost: $" + price + " USD");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static User collectUserInfo(Scanner scanner, String userType) {
        while (true) {
            try {
                System.out.println("Enter " + userType + " Full Name:");
                String fullName = scanner.nextLine().trim();

                System.out.println("Enter " + userType + " Address:");
                String address = scanner.nextLine().trim();

                System.out.println("Enter " + userType + " Phone Number:");
                String phoneNumber = scanner.nextLine().trim();

                System.out.println("Enter " + userType + " Email:");
                String email = scanner.nextLine().trim();

                return new User(fullName, address, phoneNumber, email);
            } catch (UserException e) {
                System.out.println("Invalid input: " + e.getMessage());
                System.out.println("Please enter the " + userType + " information again.");
            }
        }
    }
}

