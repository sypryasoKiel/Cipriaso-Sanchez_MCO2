import java.util.ArrayList;

public class RVMachine extends VendingMachine{
    public RVMachine(Slot[] slotList){
        super();
        this.slotList = slotList;
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }

}
