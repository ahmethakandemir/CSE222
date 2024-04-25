
import java.util.Scanner;

public class maintree {
    public static void main(String[] args) {
        try {
            // Create a Scanner object to read from a file containing the binary tree data
            // Scanner scanner = new Scanner(new File("input.txt")); // Change "input.txt" to your file path
            
            // // Call the readBinaryTree method to read the binary tree from the Scanner
            // Tree<String> binaryTree = Tree.readBinaryTree(scanner);
            // // Close the Scanner
            // scanner.close();
            
            // Print the binary tree using the toString method
            // System.out.println("Binary Tree:");
            // System.out.println(binaryTree);
            Tree<Integer> intree = new Tree<>();

            // @SuppressWarnings("resource")
            // Scanner scan = new Scanner(System.in);
            
            // System.out.print("enter new value: ");

            intree.add(5);
            intree.add(3);
            intree.add(7);
            intree.add(2);
            intree.add(4);
            intree.add(6);
            intree.add(8);
            intree.add(9);
            intree.add(1);
            intree.remove(2);
            intree.remove(3);

            System.out.println("\n\n\n");
            System.out.println(intree);

        
        } catch (Exception e) {
            // Handle file not found exception
            e.printStackTrace();
        }
    }
}