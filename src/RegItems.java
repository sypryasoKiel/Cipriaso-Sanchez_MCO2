public class RegItems extends Item{

    private String itemName;
    private int itemPrice;
    private int itemCalories;

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
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemCalories(itemCalories);
    }

}