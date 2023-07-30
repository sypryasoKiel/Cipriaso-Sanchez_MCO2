public class Item {
    private final double PRICE;
    private final String NAME;
    private final double CALORIES;

    public Item(double price, String name, double calories){
        this.NAME = name;
        this.PRICE = price;
        this.CALORIES = calories;
    }

    public double getPrice(){
        return this.PRICE;
    }

    public String getName(){
        return this.NAME;
    }

    public double getCalories(){
        return this.CALORIES;
    }
    
    public double setPrice(double price){
        final double PRICE = price;
        return PRICE;
    }
}
