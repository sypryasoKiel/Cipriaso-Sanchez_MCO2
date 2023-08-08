/**
 * Item class that represents an item in the vending machine
 */
public class Item {
    private double Price;
    private final String NAME;
    private final double CALORIES;
    private double totalSales;

    /**
     * constructor for the item
     * @param price the price of the item
     * @param name the name of the item
     * @param calories the amount of calories of the item
     */
    public Item(double price, String name, double calories){
        this.NAME = name;
        this.Price = price;
        this.CALORIES = calories;
        this.totalSales = totalSales;
    }

    /**
     * sets the price of the item
     * @param price the price
     * @return true if the price is valid, false if not
     */
    public boolean setPrice(double price){
        if(price>0) {
            this.Price = price;
            return true;
        }
        return false;
    }

    /**
     * gets the price of the item
     * @return price the price
     */
    public double getPrice(){
        return this.Price;
    }

    /**
     * gets the name of the item
     * @return name the name
     */
    public String getName(){
        return this.NAME;
    }

    /**
     * gets the amount of calories of the item
     * @return calories the amount of calories
     */
    public double getCalories(){
        return this.CALORIES;
    }

    public double getTotalSales() {
        return totalSales;
    }

}
