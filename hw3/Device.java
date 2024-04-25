interface Device {

    /** getter for Device category 
     * complexity: O(1)
    */
    public String getCategory();

    /**
     * setter for Device category
     * complexity: O(1)
     * @param aCat the new category
     */
    public void setCategory(String aCat);

    /** getter for Device name 
     * complexity: O(1)
    */
    public String getName();

    /**
     * setter for Device name
     * complexity: O(1)
     * @param aName the new name
     */
    public void setName(String aName);

    /** getter for Device price 
     * complexity: O(1)
    */
    public double getPrice();

    /**
     * setter for Device price
     * complexity: O(1)
     * @param aPrice the new price
     */
    public void setPrice(double aPrice);

    /** getter for Device quantity 
     * complexity: O(1)
    */
    public int getQuantity();

    /**
     * setter for Device quantity
     * complexity: O(1)
     * @param aQuantity the new quantity
     */
    public void setQuantity(int aQuantity);

}
