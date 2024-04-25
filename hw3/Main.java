import java.util.Scanner;

/**
 * Main class to run the program
 */
public class Main {
    /**
     * Main method to run the program
     * @param args
     */
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        @SuppressWarnings("resource")
        // Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        // Variable to store user input
        int option = -1;
        while (option != 0) {
            // Display the menu
            System.out.println("---------------------------------");
            System.out.println("Welcome to the Electronics Inventory Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");
            System.out.println("0. Exit");
            try {
                // Take user input
                option = sc.nextInt();
            } catch (Exception e) {// Catch invalid input
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            System.out.println("---------------------------------");
            // Switch case to handle user input
            switch (option) {
                case 1:
                    inv.add();
                    break;
                case 2:
                    inv.remove();
                    break;
                case 3:
                    inv.update();
                    break;
                case 4:
                    inv.listAll();
                    break;
                case 5:
                    inv.findCheapest();
                    break;
                case 6:
                    inv.sort();
                    break;
                case 7:
                    inv.TotalValue();
                    break;
                case 8:
                    inv.updateQuantity();
                    break;
                case 9:
                    inv.exportReport();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
