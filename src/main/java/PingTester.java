import java.util.InputMismatchException;
import java.util.Scanner;

public class PingTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner here
        int choice = -1; // Initialize with an invalid value

        while (choice != 0) {
            try {
                MenuHandler.displayMenu();
                choice = scanner.nextInt(); // Use the initialized scanner
                MenuHandler.handleMainMenuChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close(); // Close the scanner when done
    }
}
