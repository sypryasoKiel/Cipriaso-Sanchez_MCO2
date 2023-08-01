public class Item {
    private double Price;
    private final String NAME;
    private final double CALORIES;

    public Item(double price, String name, double calories){
        this.NAME = name;
        this.Price = price;
        this.CALORIES = calories;
    }

    public void setPrice(double price){
        this.Price=price;
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
     * @return
     */
    public double getCalories(){
        return this.CALORIES;
    }
}
