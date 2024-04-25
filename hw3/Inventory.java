import java.util.Scanner;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Inventory class to manage the inventory of Devices
 */
class Inventory {

    LinkedList<ArrayList<?>> inventory = new LinkedList<ArrayList<?>>(); // LinkedList to store the inventory as a list of ArrayLists

    // ArrayLists to store the devices of each category
    ArrayList <Tv> tvlist = new ArrayList<Tv>();
    ArrayList <Laptop> laptoplist = new ArrayList<Laptop>();
    ArrayList <Headphone> headphonelist = new ArrayList<Headphone>();
    ArrayList <Keyboard> keyboardlist = new ArrayList<Keyboard>();
    ArrayList <Mouse> mouselist = new ArrayList<Mouse>();

    /**
     * Constructor to initialize the inventory
     * Adds the ArrayLists to the inventory LinkedList
     */
    public Inventory() {
        inventory.add(tvlist);
        inventory.add(laptoplist);
        inventory.add(headphonelist);
        inventory.add(keyboardlist);
        inventory.add(mouselist);
    }
    /**
     * Method to add a new device to the inventory
     * Time complexity: O(n) because I checked if the item already exists
     */
    public void add(){
        
        System.out.println("Enter category name: ");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in); // Scanner object to take user input
        String category = input.nextLine();// Variable to store the category name
        String tempCategory = category.toLowerCase().replace(" ", "");  // Convert the category name to lowercase and remove spaces to make it easier for comparison and validation
        // Check if the category name is valid
        if(tempCategory.equals("tv") || tempCategory.equals("laptop") || tempCategory.equals("headphones") || tempCategory.equals("headphone") || tempCategory.equals("keyboard") || tempCategory.equals("mouse")){
            // continue
        }
        else{
            System.out.println("Invalid category name");
            return;
        }
        System.out.println("Enter device name: "); // Prompt the user to enter the device name
        String name = input.nextLine();// Variable to store the device name
        System.out.println("Enter price: ");// Prompt the user to enter the price
        double price;// Variable to store the price
        try{
            price = input.nextDouble();
        }
        catch(Exception e){
            System.out.println("Invalid price");
            return;
        }
        System.out.println("Enter quantity: ");
        int quantity;
        try{
            quantity = input.nextInt();
        }
        catch(Exception e){
            System.out.println("Invalid quantity");
            return;
        }
        
        if(tempCategory.equals("tv")){
            Tv tv = new Tv();
            tv.setCategory(category);
            tv.setName(name);
            tv.setPrice(price);
            tv.setQuantity(quantity);
            int flag = 1;
            for (int i = 0; i < tvlist.size(); i++) {
                if(tvlist.get(i).getName().equals(name)){
                    if(tvlist.get(i).getPrice() == price){
                        System.out.println("Item already exists. Quantity updated.");
                        tvlist.get(i).setQuantity(tvlist.get(i).getQuantity() + quantity);
                        flag = 0;
                    }
                    else{
                        System.out.println("Item already exists with different price");
                        return;
                    }
                }
            }
            if(flag == 1){
                tvlist.add(tv);
            }
        }
        else if(tempCategory.equals("laptop")){
            Laptop laptop = new Laptop();
            laptop.setCategory(category);
            laptop.setName(name);
            laptop.setPrice(price);
            laptop.setQuantity(quantity);
            int flag = 1;
            for (int i = 0; i < laptoplist.size(); i++) {
                if(laptoplist.get(i).getName().equals(name)){
                    if(laptoplist.get(i).getPrice() == price){
                        laptoplist.get(i).setQuantity(laptoplist.get(i).getQuantity() + quantity);
                        flag = 0;
                    }
                    else{
                        System.out.println("Item already exists with different price");
                        return;
                    }
                }
                
            }
            if(flag == 1){
                laptoplist.add(laptop);
              
            }
           
        }
        else if((tempCategory.equals("headphones")) || (tempCategory.equals("headphone"))){
            Headphone headphones = new Headphone();
            headphones.setCategory(category);
            headphones.setName(name);
            headphones.setPrice(price);
            headphones.setQuantity(quantity);
            
            //
            int flag = 1;
            for (int i = 0; i < headphonelist.size(); i++) {
                if(headphonelist.get(i).getName().equals(name)){
                    if(headphonelist.get(i).getPrice() == price){
                        headphonelist.get(i).setQuantity(headphonelist.get(i).getQuantity() + quantity);
                        flag = 0;
                    }
                    else{
                        System.out.println("Item already exists with different price");
                        return;
                    }
                }
            }
            if(flag == 1){
                headphonelist.add(headphones);
            
            }

        }
        else if(tempCategory.equals("keyboard")){
            Keyboard keyboard = new Keyboard();
            keyboard.setCategory(category);
            keyboard.setName(name);
            keyboard.setPrice(price);
            keyboard.setQuantity(quantity);
            
            int flag = 1;
            for (int i = 0; i < keyboardlist.size(); i++) {
                if(keyboardlist.get(i).getName().equals(name)){
                    if (keyboardlist.get(i).getPrice() == price) {
                        keyboardlist.get(i).setQuantity(keyboardlist.get(i).getQuantity() + quantity);
                        flag = 0;
                    }   
                    else{
                        System.out.println("Item already exists with different price");
                        return;
                    }
                }
            }
            if(flag == 1){
                keyboardlist.add(keyboard);
     
            }
        }
        else if(tempCategory.equals("mouse")){
            Mouse mouse = new Mouse();
            mouse.setCategory(category);
            mouse.setName(name);
            mouse.setPrice(price);
            mouse.setQuantity(quantity);
            
            int flag = 1;
            for (int i = 0; i < mouselist.size(); i++) {
                if(mouselist.get(i).getName().equals(name)){
                    if(mouselist.get(i).getPrice() == price){
                        mouselist.get(i).setQuantity(mouselist.get(i).getQuantity() + quantity);
                        flag = 0;
                    }
                    else{
                        System.out.println("Item already exists with different price");
                        return;
                    }
                }
            }
            if(flag == 1){
                mouselist.add(mouse);
          
            }

        }
        else{   
            System.out.println("Invalid category name");
        }
        System.out.println();
        // input.close();
        
    
    }   
    
    /**
     * Method to remove a device from the inventory
     * Time complexity: O(n) because I checked if the item exists and if it is, I removed it
     */
    public void remove(){
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item name to remove: ");
        String name = input.nextLine();
        for (var item : tvlist) {
            if(item.getName().equals(name)){
                tvlist.remove(item);
                return;
            }
        }
        for (var item : laptoplist) {
            if(item.getName().equals(name)){
                laptoplist.remove(item);
     
                return;
            }
        }
        for (var item : headphonelist) {
            if(item.getName().equals(name)){
                headphonelist.remove(item);
                
                return;
            }
        }
        for (var item : keyboardlist) {
            if(item.getName().equals(name)){
                keyboardlist.remove(item);
                
                return;
            }
        }
        for (var item : mouselist) {
            if(item.getName().equals(name)){
                mouselist.remove(item);
                
                return;
            }
        }
        System.out.println("Item not found");
    }
    
    /**
     * Method to update the details of a device in the inventory
     * Time complexity: O(n) because I checked if the item exists and if it is, I updated it
     */
    public void update(){   // (leave blank to keep current quantity)
        System.out.println("Enter item name to update: ");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        
        for (var item : tvlist) {
            
            if(item.getName().equals(name)){
                System.out.println("Enter new price: (leave blank to keep current price)");
                String price = input.nextLine();
                try{
                    if(price.equals("")) {
                        throw new Exception();
                    }
                    double dprice = Double.parseDouble(price);
                    item.setPrice(dprice);
                }
                catch(Exception e){
                    System.out.println("Price kept same!");
                }
                System.out.println("Enter new quantity: (leave blank to keep current quantity)");
                String quantity = input.nextLine();
                try{
                    if(quantity.equals("")) {
                        throw new Exception();
                    }
                    int dquantity = Integer.parseInt(quantity);
                    item.setQuantity(dquantity);
                }
                catch(Exception e){
                    System.out.println("Quantity kept same!");
                }
                return;
            }
        }
        for (var item : laptoplist) {
            
            if(item.getName().equals(name)){
                System.out.println("Enter new price: (leave blank to keep current price)");
                String price = input.nextLine();
                try{
                    if(price.equals("")) {
                        throw new Exception();
                    }
                    double dprice = Double.parseDouble(price);
                    item.setPrice(dprice);
                }
                catch(Exception e){
                    System.out.println("Price kept same!");
                }
                System.out.println("Enter new quantity: (leave blank to keep current quantity)");
                String quantity = input.nextLine();
                try{
                    if(quantity.equals("")) {
                        throw new Exception();
                    }
                    int dquantity = Integer.parseInt(quantity);
                    item.setQuantity(dquantity);
                }
                catch(Exception e){
                    System.out.println("Quantity kept same!");
                }
                return;
            }
        }
        for (var item : headphonelist) {
            
            if(item.getName().equals(name)){
                System.out.println("Enter new price: (leave blank to keep current price)");
                String price = input.nextLine();
                try{
                    if(price.equals("")) {
                        throw new Exception();
                    }
                    double dprice = Double.parseDouble(price);
                    item.setPrice(dprice);
                }
                catch(Exception e){
                    System.out.println("Price kept same!");
                }
                System.out.println("Enter new quantity: (leave blank to keep current quantity)");
                String quantity = input.nextLine();
                try{
                    if(quantity.equals("")) {
                        throw new Exception();
                    }
                    int dquantity = Integer.parseInt(quantity);
                    item.setQuantity(dquantity);
                }
                catch(Exception e){
                    System.out.println("Quantity kept same!");
                }
                return;
            }
        }
        for (var item : keyboardlist) {
            if(item.getName().equals(name)){
                System.out.println("Enter new price: (leave blank to keep current price)");
                String price = input.nextLine();
                try{
                    if(price.equals("")) {
                        throw new Exception();
                    }
                    double dprice = Double.parseDouble(price);
                    item.setPrice(dprice);
                }
                catch(Exception e){
                    System.out.println("Price kept same!");
                }
                System.out.println("Enter new quantity: (leave blank to keep current quantity)");
                String quantity = input.nextLine();
                try{
                    if(quantity.equals("")) {
                        throw new Exception();
                    }
                    int dquantity = Integer.parseInt(quantity);
                    item.setQuantity(dquantity);
                }
                catch(Exception e){
                    System.out.println("Quantity kept same!");
                }
                return;
            }
        }
        for (var item : mouselist) {
            if(item.getName().equals(name)){
                System.out.println("Enter new price: (leave blank to keep current price)");
                String price = input.nextLine();
                try{
                    if(price.equals("")) {
                        throw new Exception();
                    }
                    double dprice = Double.parseDouble(price);
                    item.setPrice(dprice);
                }
                catch(Exception e){
                    System.out.println("Price kept same!");
                }
                System.out.println("Enter new quantity: (leave blank to keep current quantity)");
                String quantity = input.nextLine();
                try{
                    if(quantity.equals("")) {
                        throw new Exception();
                    }
                    int dquantity = Integer.parseInt(quantity);
                    item.setQuantity(dquantity);
                }
                catch(Exception e){
                    System.out.println("Quantity kept same!");
                }
                return;
            }
        }
        System.out.println("Item not found");
    }
    
    /**
     * Method to list all the devices in the inventory
     * Time complexity: O(n) because I iterated through all the devices in the inventory to print them out
     */
    private void list(){
        int i = 1;
        for (var liste : inventory) {
            for (var item : liste) {
                System.out.println(i + ". " + item.toString());
                i++;
            }
        }
    }
    /**
     * Method to list all the devices in the inventory
     * Time complexity: O(n) because I called the list method
     */
    public void listAll(){
        list();
    }
    /**
     * Method to list all the devices in the inventory by category
     * Time complexity: O(n) because I iterated through all the devices in the inventory to find the cheapest one and print it
     */
    public void findCheapest(){
        double min = 9999999;
        ArrayList<Device> minitems = new ArrayList<Device>();
        for (var liste : inventory) {
            for(var item : liste){

                if(((Device) item).getPrice() < min){
                    min = ((Device) item).getPrice();
                    minitems.clear();
                    minitems.add((Device) item);
                }
                else if(((Device) item).getPrice() == min){
                    minitems.add((Device) item);
                }
            }
        }

        for (var item : minitems) {
            System.out.println(item.toString());
            
        }
    }
    /**
     * Method to list all the devices in the inventory by category
     * complexity: O(n^2) because I iterated through all the devices twice to compare them and sort them
     */
    public void sort(){
        double min;
        ArrayList <Device> sorted = new ArrayList<Device>();
        ArrayList <Device> all = new ArrayList<Device>();
        for (var liste : inventory) {   // complexity: O(n), n = number of devices.
            for(var item : liste){
                all.add((Device) item);
            }
        }
        
        for (int i = 0; i < all.size(); i++) { // complexity: O(n^2)
            min = 9999999.0;
            for (int j = 0; j < all.size(); j++) {
                if(all.get(j).getPrice() < min){
                    min = all.get(j).getPrice();
                }
            }
            for (int j = 0; j < all.size(); j++) {
                if(all.get(j).getPrice() == min){
                    sorted.add(all.get(j));
                    all.remove(j);
                    i--;
                    break;
                }
            }
        }
        int i = 0;
        for (var item : sorted) {   // complexity: O(n)
            System.out.println(i + ". " + item.toString());
            i++;
        }
        

    }
    /**
     * Method to calculate the total value of the inventory
     * Time complexity: O(n) because I iterated through all the devices in the inventory to calculate the total value and add them up
     */
    public void TotalValue(){
        double total = 0;
        for(var liste : inventory){
            for (var item : liste){
                total += ((Device) item).getPrice() * ((Device) item).getQuantity();
            }
        }
        System.out.println("Total value of inventory: " + total);
    }
    /**
     * A helper method to update the quantity of a device in the inventory
     * Time complexity: O(1) because I only updated the quantity of the device
     * @param item the device to update
     * @param input the Scanner object to take user input
     * @return the updated device
     */
    private Device quantitychange(Device item, Scanner input){
        System.out.println("Do you want to add or remove stock? (Add/Remove): ");
        String choice = input.nextLine();
        if(choice.toLowerCase().equals("add")){
            System.out.println("Enter the quantity to add: ");
            int quantity = input.nextInt();
            item.setQuantity(item.getQuantity() + quantity);
            System.out.println(item.getName() + " restocked. New quantity: " + item.getQuantity());
        }
        else if(choice.toLowerCase().equals("remove")){
            System.out.println("Enter the quantity to remove: ");
            int quantity = input.nextInt();
            item.setQuantity(item.getQuantity() - quantity);
            System.out.println(item.getName() + " restocked. New quantity: " + item.getQuantity());
        }
        else{
            System.out.println("Invalid choice");
        }
        return item;

    }
    /**
     * Method to update the quantity of a device in the inventory
     * Time complexity: O(n) because I iterated through all the devices in the inventory to find the device to update
     */
    public void updateQuantity(){
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the device to restock: ");
        String name = input.nextLine();
        for(var liste : inventory){
            for (var item : liste){
                Device tempitem = (Device) item;
                if(tempitem.getName().equals(name)){
                    quantitychange(tempitem, input);
                    return;
                }
            }
        }
    }
    
    /**
     * Method to export the inventory report to a file
     * Time complexity: O(n) because I iterated through all the devices in the inventory to write them to the file
     */
    public void exportReport(){
        try{
            FileWriter writer = new FileWriter("inventory.txt");
            writer.write("------------------------------------------------------------------------------");
            writer.write("\nElectronics Shop Inventory Report\n");
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu");
            writer.write("Generated on: " + date.format(formatter));
            writer.write("\n------------------------------------------------------------------------------\n");
            writer.write("\n| No. | Category | Name | Price | Quantity |\n");
            writer.write("------------------------------------------------------------------------------\n");
            int i = 1;
            
            
            for(var liste : inventory){
                for (var item : liste){
                    Device tempitem = (Device) item;
                    String tempcategory = String.format("%15s", tempitem.getCategory()); 
                    String tempname = String.format("%15s", tempitem.getName());
                    String tempprice = String.format("%15.2f", tempitem.getPrice()); 
                    String tempquantity = String.format("%15d", tempitem.getQuantity());
                    writer.write("| " + i + " | " + tempcategory + " | " + tempname + " | $" + tempprice + " | " + tempquantity + " |\n");
                    i++;
                }
            }
            
            
            writer.write("------------------------------------------------------------------------------\n");
            writer.write("Summary:\n");
            writer.write("- Total Number of Devices: " + (i-1) + "\n");
            double total = 0;
            for(var liste : inventory){
                for (var item : liste){
                    total += ((Device) item).getPrice() * ((Device) item).getQuantity();
                }
            }
            writer.write("- Total Inventory Value: $" + total + "\n");
            writer.write("\nEnd of Report");


            writer.close();
            System.out.println("Inventory report exported to inventory.txt");
        }
        catch(Exception e){
            System.out.println("Error writing to file");
        }
    }
}
