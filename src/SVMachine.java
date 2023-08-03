import java.util.ArrayList;
import java.util.Collections;

/**
 * SVMachine class is a subclass of VendingMachine
 */
public class SVMachine extends VendingMachine {
    private ArrayList<Item> itemBundle;
    private ArrayList<Item> itemList;
    public SVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
        this.itemBundle = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }

    /**
     * This method is used to get the item bundle
     * @return slotList the list of slots
     */
    public ArrayList<Item> getItemBundle() {
        return itemBundle;
    }

    /**
     * gets the total amount of calories in the item bundle
     * @return totalCalories the total amount of calories
     */
    public double getTotalCalories() {
        double totalCalories=0;
        for (Item item : itemBundle) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    /**
     * clears the item bundle and item list
     */
    public void clearList(){
        this.itemBundle.clear();
        this.itemList.clear();
    }

    /**
     * gets the item list
     * @return itemList the list of items
     */
    public ArrayList<Item> getItemList(){
        return itemList;
    }


    /**
     * This method is used to set the text of the items
     * @return items the text of the items
     */
    public String setItemsText(){
        StringBuilder items = new StringBuilder();

        for(int i=0;i<itemList.size();i++){
            if(i==0)
                items.append("\n");
            items.append(itemList.get(i).getName());
            if(i<=itemList.size()-1)
                items.append("\n");
        }

        return items.toString();
    }

    /**
     * adds an item to the item bundle
     * @param item the item to be added
     * @param qty the quantity of the item to be added
     */
    public void addItemToBundle(Item item, int qty){
        boolean doesExist = false;
        for (Item value : itemBundle) {
            if(item==value){
                doesExist = true;
            }

        }
        for(int i=0;i<qty;i++){
            this.itemBundle.add(item);
        }

        if(!doesExist&&qty!=0)
            itemList.add(item);
    }

    public double calculateChange(double payment){
        double price=0;
        for (Item item : itemBundle) {
            price += item.getPrice();
        }
        return payment-price;
    }

    /**
     * produces change in cash array format
     * @param payment the amount of money to be given
     * @return change the change to be given
     */
    public Cash[] produceChange(double payment){ //produces the change needed to give in cash array format
        Cash[] change = doubleToCash(calculateChange(payment));
        for(int i=0;i<CashStorage.getRegister().length;i++){
            this.CashStorage.removeCash(change[i]);
        }
        return change;
    }

    /**
     * checks the criteria for a transaction
     * @param payment the amount of money to be given
     * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
     */
    public int checkBuy(double payment){ //checks the criteria for a transaction, returns: 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
        double doubleChange;
        Cash[] change;

        doubleChange=calculateChange(payment);
        if(doubleChange<0){
            return 0;
        }
        else{
            change = doubleToCash(doubleChange);
            if(!isChangeAvailable(change)){
                return -2;
            }
            else{
                return 1;
            }
        }
    }


/**
 * buys an item 
 * @param payment the amount of money to be given
 * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
 */
    public int buyItem(double payment){ //makes a transaction log and sells the actual item, returns the criteria to be handled by the controller
        int checkbuy;
        StringBuilder items = new StringBuilder();


        checkbuy=checkBuy(payment);

        switch(checkbuy){
            case 1:
                for (Slot slot : slotList) {
                    for (int j = 0; j < Collections.frequency(itemBundle, slot.getProduct()); j++) {
                        slot.sellItem();
                    }
                }
                for(int i=0;i<itemList.size();i++){
                    items.append(itemList.get(i).getName());
                    if(i<=itemList.size()-1)
                        items.append(", ");
                }

                this.Transactions.add(new Transaction("Sold Item",items.toString(),produceChange(payment)));
                return 1;

            case 0:
                this.Transactions.add(new Transaction("Refunded - Not Enough Money",items.toString(),doubleToCash(payment)));
                return 0;

            case -2:
                this.Transactions.add(new Transaction("Refunded - Not Enough Change","Bundle ("+items.toString()+")",doubleToCash(payment)));
                return -2;
        }
        return -3;
    }
}
