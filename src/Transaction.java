/**
 * Transaction class that stores the transaction type, the product, and the cash returned/change
 */
import java.util.ArrayList;

public class Transaction {

    private String transactionType;
    private String product;
    private Cash[] returnedCash;
    private Slot[] slots;

    public Transaction(String transactionType, String product, Cash[] returnedCash){ //constructor, requires transactionType (i.e. "Sold Item", "Refunded - Insufficient Payment, "Refunded - No Change produced"), The product itself, and the money refunded/change
        this.transactionType = transactionType;
        this.product = product;
        this.returnedCash = returnedCash;
    }

    /**
     * gets the type of transaction
     * @return transactionType the type of transaction
     */
    public String getTransactionType(){ // returns String of type of transaction (i.e. "Sold Item", "Refunded - Insufficient Payment, "Refunded - No Change produced")
        return transactionType;
    }

    /**
     * gets the product to be bought (when cash is refunded) or when sold (when change is provided)
     * @return product the product to be bought (when cash is refunded) or when sold (when change is provided)
     */
    public String getProductName(){
        return product;
    }

    /**
     * gets the cash refunded/change in Cash Array form
     * @return returnedCash the cash refunded/change in Cash Array form
     */
    public Cash[] getReturnedCash() { 
        return returnedCash;
    }

    /**
     * gets the initial stocks of the machine in String format after restocking
     * @return initialStock the initial stocks of the machine
     */
    public String getInitialStock(){ 
        String initialStock = "";
        for(int i=0;i<slots.length;i++){
            initialStock += slots[i].getProduct().getName() + ": " + slots[i] +  "\n";
    }
    return initialStock;
    }

    /**
     * gets the current stocks of the machine in String format
     * @return currentStocks the current stocks of the machine 
     */
    public String getCurrentStocks(){ //returns the current stocks of the machine in String format
        String currentStocks = "";
        for(int i=0;i<slots.length;i++){
            currentStocks += slots[i].getProduct().getName() + ": " + slots[i].getQuantity() + "\n";
        }
        return currentStocks;
    }
}
