public class RegItems extends Item{

    private String itemName;
    private int itemPrice;
    private int itemCalories;

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemCalories() {
        return itemCalories;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemCalories(int itemCalories) {
        this.itemCalories = itemCalories;
    }

    public RegItems(String itemName, int itemPrice, int itemCalories) {
        super(itemPrice, itemName, itemCalories);
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemCalories(itemCalories);
    }

}