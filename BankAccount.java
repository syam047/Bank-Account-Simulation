import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to SYAM's BANK:");

        System.out.println("Enter Account Number:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a numeric value for account number:");
            scanner.next(); // clear invalid input
        }
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // clear newline

        // Enter Account Holder Name with validation
        System.out.println("Enter Account Holder Name:");
        String accountHolderName = scanner.nextLine();
        while (!accountHolderName.matches("[a-zA-Z ]+")) {
            System.out.println("Invalid input. Please enter alphabetic characters only for name:");
            accountHolderName = scanner.nextLine();
        }

        // Enter Initial Balance with validation
        System.out.println("Enter Initial Balance:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value for initial balance:");
            scanner.next(); // clear invalid input
        }
        double initialBalance = scanner.nextDouble();

        Account account = new Account(String.valueOf(accountNumber), accountHolderName, initialBalance);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Display Transaction History");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6:");
                scanner.next(); // clear invalid input
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a numeric value for deposit amount:");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a numeric value for withdraw amount:");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using the bank!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
