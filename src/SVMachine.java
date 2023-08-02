import java.util.ArrayList;


public class SVMachine extends VendingMachine {
    
    public SVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }



}
