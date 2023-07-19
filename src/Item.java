public class Item {
    private final double PRICE;
    private final String NAME;

    public Item(double price, String name){
        this.NAME = name;
        this.PRICE = price;
    }

    public double getPrice(){
        return this.PRICE;
    }

    public String getName(){
        return this.NAME;
    }
}
