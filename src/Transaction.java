import java.util.ArrayList;

public class Transaction {

    private String transactionType;
    private Item product;
    private Cash[] returnedCash;

    public Transaction(String transactionType, Item product, Cash[] returnedCash){ //constructor, requires transactionType (i.e. "Sold Item", "Refunded - Insufficient Payment, "Refunded - No Change produced"), The product itself, and the money refunded/change
        this.transactionType = transactionType;
        this.product = product;
        this.returnedCash = returnedCash;
    }

    public String getTransactionType(){ // returns String of type of transaction (i.e. "Sold Item", "Refunded - Insufficient Payment, "Refunded - No Change produced")
        return transactionType;
    }

    public Item getProduct(){ //returns the product to be bought (when cash is refunded) or when sold (when change is provided)
        return product;
    }

    public Cash[] getReturnedCash() { //returns the cash refunded/change in Cash Array form
        return returnedCash;
    }
}
