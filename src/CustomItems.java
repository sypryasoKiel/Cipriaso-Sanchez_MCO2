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
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public double getCalories(){
        return this.calories;
    }


    
}