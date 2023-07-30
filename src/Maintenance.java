public class Maintenance{
    private Slot[] slots;
    private Cash[] cash;
    private Item[] items;
    private Transaction[] transactions;
    private int slotCount;
    private int cashCount;
    private int itemCount;
    private int transactionCount;

    public void setItemPrice(int itemIndex, int price){
        this.items[itemIndex];
    }

    public void refillSlots(){
        for(int i=0;i<slotCount;i++){
            this.slots[i].getQuantity();
        }
    }

    public void refillCash(){
        for(int i=0;i<cashCount;i++){
            this.cash[i].addQuantity(i);;
        }
    }

    
    
}
