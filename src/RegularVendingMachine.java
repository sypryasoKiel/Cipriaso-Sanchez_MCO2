public class RegularVendingMachine extends VendingMachine{
    private Slot[] slotList;
    private CashRegister CashStorage;
    private CustomItems[] CustomItems;
    
    public RegularVendingMachine(int numSlot,int maxQty){
        super(numSlot,maxQty);
        this.slotList = new Slot[numSlot];
        this.CashStorage = new CashRegister(10);
        for(int i=0;i<numSlot;i++){
            slotList[i]=new Slot(maxQty);
        }
    }

}