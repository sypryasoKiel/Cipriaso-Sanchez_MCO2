import java.util.ArrayList;

public class Slot {
    private ArrayList<Item> Items;

    public Slot(){
        this.Items = new ArrayList<>();
    }

    public void addItem(String name, int quantity, double price){
        boolean flag = false;

        for(Item i : Items){
            if(i.getName().equals(name)){
                flag = true;
                break;
            }
        }

        if(!flag){
            for(Item i : Items){
                Items.add(new Item(price, name));
            }
        }
    }

    public int getQuantity(){
        return Items.size();
    }

    public Item getProduct(String name){
        for(Item i : Items){
            if(i.getName().equals(name))
                return i;
        }
        return null;
    }
}
