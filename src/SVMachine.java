import java.util.ArrayList;

/**
 * SVMachine class 
 * This class is a subclass of VendingMachine
 */
public class SVMachine extends VendingMachine {
    
    /**
     * This is the list of slots in the vending machine
     * @param slotList the list of slots
     */
    public SVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }



}
