/**
 * Slot class that represents a slot in the vending machine
 */
import java.util.ArrayList;

public class Slot {
    private ArrayList<Item> Items;
    private Item Product;
    private int MaxQty;

    public Slot(int max){ //constructor, requires maximum capacity
        this.Items = new ArrayList<>();
        this.MaxQty = max;
    }

    /**
     * sets the product of the slot
     * @param product the product to be set
     */
    public void setProduct(Item product){ //sets the product of the slot
        this.Product = product;
        this.clearSlot();
    }

    /**
     * adds items to the slot
     * 
     * @return true if the slot has not reached maximum capacity, false otherwise
     */
    public boolean addItem(){ //increments 1 item to the slot given the slot has not reached maximum capacity
        if(this.Items.size()==MaxQty) {
            Items.add(Product);
            return true;
        }
        else
            return false;
    }

    /**
     * gets the quantity of items in the slot
     * @return Size the quantity of items in the slot
     */
    public int getQuantity(){ //gets the quantity of items in this slot
        return this.Items.size();
    }

    /**
     * sells an item from the slot
     * 
     * @return
     */
    public boolean sellItem(){ //decrements 1 and returns true if quantity in the slot is greater than 0, else it returns false
        if(this.getQuantity()-1>=0) {
            this.Items.remove(getQuantity() - 1);
            return true;
        }
        return false;
    }

    /**
     * gets the product inside the slot
     * @return Product the product inside the slot
     */
    public Item getProduct(){ //gets what product is inside the slot
        return this.Product;
    }

    /**
     * clears the slot of items
     */
    public void clearSlot(){ //clears the slot of items,
        this.Items.clear();
    }
}
