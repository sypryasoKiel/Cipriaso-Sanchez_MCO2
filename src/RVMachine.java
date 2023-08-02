import java.util.ArrayList;

/**
 * RVMachine class
 * This class is a subclass of VendingMachine
 */
public class RVMachine extends VendingMachine{
    /**
     * This is the list of slots in the vending machine
     * @param slotList the list of slots
     */
    public RVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }

}
