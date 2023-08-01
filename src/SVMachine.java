import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SVMachine extends VendingMachine {
    
    public SVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }
    /**
     * gets the item list 
     * @param recipe the recipe of the item
     * @return itemList the item list
     */
    public ArrayList<Item> getItemList(ArrayList<Item> recipe){
        Item flag = null;
        ArrayList<Item> itemList = new ArrayList<>();

        for(int i=0;i<recipe.size();i++){
            if(flag==null){
                flag=recipe.get(i);
                itemList.add(flag);
            }
            else{
                if(!(flag==recipe.get(i))){
                    itemList.add(recipe.get(i));
                }
            }
        }

        return itemList;
    }

}
