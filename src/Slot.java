import java.util.ArrayList;

public class Slot {
    private ArrayList<Item> Items;
    private Item Product;
    private int MaxQty;

    public Slot(int max){ //constructor, requires maximum capacity
        this.Items = new ArrayList<>();
        this.MaxQty = max;
    }

    public void setProduct(Item product){ //sets the product of the slot
        this.Product = product;
        this.clearSlot();
    }

    public boolean addItem(){ //increments 1 item to the slot given the slot has not reached maximum capacity
        if(this.Items.size()==MaxQty) {
            Items.add(Product);
            return true;
        }
        else
            return false;
    }

    public int getQuantity(){ //gets the quantity of items in this slot
        return this.Items.size();
    }

    public boolean sellItem(){ //decrements 1 and returns true if quantity in the slot is greater than 0, else it returns false
        if(this.getQuantity()-1>=0) {
            this.Items.remove(getQuantity() - 1);
            return true;
        }
        return false;
    }

    public Item getProduct(){ //gets what product is inside the slot
        return this.Product;
    }

    public void clearSlot(){ //clears the slot of items,
        this.Items.clear();
    }
}
