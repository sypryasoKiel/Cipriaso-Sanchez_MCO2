import java.util.ArrayList;

public class CustomItems extends Item{
    private String name;
    private double price;
    private double calories;
    private ArrayList<Item> ingridients;

   
    public CustomItems(String name, double price, double calories){
        super(price, name, calories);
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.ingridients = new ArrayList<Item>();
    }
    /**
     * gets the name of the item
     * @return name the name
     */
    public String getName(){
        return this.name;
    }
    /**
     * gets the price of the item
     * @return price the price
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * gets the amount of calories of the item
     * @return calories the amount of calories
     */
    public double getCalories(){
        return this.calories;
    }


    
}