import java.util.Scanner;
/**
 * Main class for the file system.
 */
public class Main {
    /**
     * Main method for the file system.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\n\nFile System Menu:");
            System.out.println("1. Create File or Directory");
            System.out.println("2. Change Directory");
            System.out.println("3. Remove File or Directory");
            System.out.println("4. Move File or Directory");
            System.out.println("5. Print Path to Current Directory");
            System.out.println("6. Search for File or Directory");
            System.out.println("7. Print Directory Tree");
            System.out.println("8. List Directory Contents");
            System.out.println("9. Sort Directory Contents by Time");
            System.out.println("0. Exit");

            int choice;
            try{
                // Get user choice
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // ignore the newline character
            }
            catch(Exception e){
                System.out.println("Invalid choice. Please enter a number between 0 and 9.");
                scanner.nextLine(); // ignore the newline character
                continue;
            }

            //switch case for user choice
            switch (choice) {
                case 1:
                    System.out.println("Create file or directory (f/d):");
                    String type = scanner.nextLine();
                    if (!type.equals("f") && !type.equals("d")) {
                        System.out.println("Invalid choice. Please enter 'f' or 'd'.");
                        break;
                    }
                    if(type.equals("f")){
                        System.out.print("Enter name for new file: ");
                        String fileName = scanner.nextLine();
                        fs.createFile(fileName);
                        break;
                    }
                    else{
                        System.out.print("Enter name for new directory: ");
                        String dirName = scanner.nextLine();
                        fs.createDirectory(dirName);
                        break;
                    }
                case 2:
                    System.out.print("Current directory: ");
                    fs.printPath();
                    System.out.println();
                    System.out.print("Enter new directory path: ");
                    String dirName = scanner.nextLine();
                    fs.cd(dirName);
                    break;
                case 3:
                    System.out.print("Enter name of file or directory to remove: ");
                    String nameToRemove = scanner.nextLine();
                    fs.remove(nameToRemove);
                    
                    break;
                case 4:
                    System.out.print("Enter name of file or directory to move: ");
                    String nameToMove = scanner.nextLine();
                    System.out.print("Enter new directory path: ");
                    String newPath = scanner.nextLine();
                    fs.moveItem(nameToMove, newPath);
                    break;
                case 5:
                    fs.printPath();
                    break;
                case 6:
                    System.out.print("Enter search query: ");
                    String searchQuery = scanner.nextLine();
                    fs.search(searchQuery);
                    break;
                case 7:
                    System.out.println("Path to current directory from root: ");
                    fs.printDirectoryTree();
                    break;
                case 8:
                    System.out.print("Listing contents of: ");
                    fs.printPath();
                    System.out.println();
                    fs.ls();
                    break;
                case 9:
                    fs.sortByTime();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
            }
        }
    }
}
