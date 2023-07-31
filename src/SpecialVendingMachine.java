import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine{
    private Slot[] slotList;
    private CashRegister CashStorage;

    public SpecialVendingMachine(int numSlot,int maxQty){
        super(numSlot,maxQty);
        this.slotList = new Slot[numSlot];
        this.CashStorage = new CashRegister(10);
        for(int i=0;i<numSlot;i++){
            slotList[i]=new Slot(maxQty);
        }
    }

    public void createCustomFood(){
        
    }

}