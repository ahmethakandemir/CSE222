/**
 * Laptop class that implements the Device interface
 */
class Laptop implements Device{
    private String category;
    private String name;
    private double price;
    private int quantity;
    /**
     * getter for category
     * @return the category
     */
    public String getCategory(){
        return category;
    }
    /**
     * getter for name
     * @return the name
     */
    public String getName(){
        return name;
    }
    /**
     * getter for price
     * @return the price
     */
    public double getPrice(){
        return price;
    }
    /**
     * getter for quantity
     * @return the quantity
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * setter for category
     * @param aCat the new category
     */
    public void setCategory(String aCat){
        this.category = aCat;
    }
    /**
     * setter for name
     * @param aName the new name
     */
    public void setName(String aName){
        this.name = aName;
    }
    /**
     * setter for price
     * @param aPrice the new price
     */
    public void setPrice(double aPrice){
        this.price = aPrice;
    }
    /**
     * setter for quantity
     * @param aQuantity the new quantity
     */
    public void setQuantity(int aQuantity){
        this.quantity = aQuantity;
    }
    /**
     * toString method to display the object
     * @return the object as a string
     */
    public String toString(){
        return "Category: " + category + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}
