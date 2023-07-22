import java.util.ArrayList;

public class Slot {
    private ArrayList<Item> Items;
    private Item Product;

    public Slot(Item product){
        this.Items = new ArrayList<>();
    }

    public void setProduct(Item product){
        this.Product = product;
    }

    public void addItem(Item product){
        if(product.getName().equals(Product.getName())){
            this.Items.add(product);
        }
    }

    public int getQuantity(){
        return Items.size();
    }

    public Item getItem(String name){
        for(Item i : Items){
            if(i.getName().equals(name))
                return i;
        }
        return null;
    }

    public void sellItem(String name){
        Item i = this.getItem(name);

        if(i!=null)
            i=null;
    }

    public Item getProduct(){
        return this.Product;
    }

    public void clearSlot(){
        this.Items.clear();
    }
}
