public class RegItems extends Item{

    private String itemName;
    private int itemPrice;
    private int itemCalories;

    /**
     * gets the name of the item
     * @return itemName the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * gets the price of the item
     * @return itemPrice the price of the item
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * gets the amount of calories of the item
     * @return itemCalories the amount of calories of the item
     */
    public int getItemCalories() {
        return itemCalories;
    }

    /**
     * sets the name of the item
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * sets the price of the item
     * @param itemPrice
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * sets the amount of calories of the item
     * @param itemCalories
     */
    public void setItemCalories(int itemCalories) {
        this.itemCalories = itemCalories;
    }

    /**
     * constructor for the RegItems class
     * @param itemName the name of the item
     * @param itemPrice the price of the item
     * @param itemCalories the amount of calories of the item
     */
    public RegItems(String itemName, int itemPrice, int itemCalories) {
        super(itemPrice, itemName, itemCalories);
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemCalories(itemCalories);
    }

}