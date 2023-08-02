import java.util.ArrayList;

/**
 * Slot class that represents a slot in the vending machine
 */
public class Slot {
    private ArrayList<Item> Items;
    private Item Product;
    private int MaxQty;

    /**
     * constructor for the slot
     * @param max the maximum capacity of the slot
     */
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
     * @param qty the quantity of items to be added 
     * @return true if the slot has not reached maximum capacity, false otherwise
     */
    public boolean addItem(int qty){ //increments 1 item to the slot given the slot has not reached maximum capacity
        if(((qty+this.Items.size())<=MaxQty)&&qty>0){
            for(int i=0;i<qty;i++){
                Items.add(Product);
            }
            return true;
        }
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
     * gets the maximum quantity of items in the slot
     * @return MaxQty the maximum quantity of items in the slot
     */
    public int getMaxQty(){
        return this.MaxQty;
    }

    /**
     * sells an item from the slot
     * @return true if the quantity in the slot is greater than 0, false otherwise
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
