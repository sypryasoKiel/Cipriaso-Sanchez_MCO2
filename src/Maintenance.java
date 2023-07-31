public class Maintenance{
    private Slot[] slots;
    private Cash[] cash;
    private CashRegister[] registers;
    private Item[] items;
    private Transaction[] transactions;
    private int slotCount;
    private int cashCount;
    private int itemCount;
    private int transactionCount;
    private double price;

    public void setItemPrice(int index, double price){
        this.items[index];
    }

    public void refillStock(){
        for(int i=0;i<slotCount;i++){
            this.slots[i].getQuantity();
        }
    }

    public void replaceItemSlots(int index, Item item){
        this.slots[index].setProduct(item);
    }

    public String getTransactionHistory(){
        String transactionHistory = "";
        for(int i=0;i<transactionCount;i++){
            transactionHistory += transactions[i].getProduct() + " "+ transactions[i].getTransactionType() + "\n";
        }
        return transactionHistory;
    }

    public Cash[] getRegisters(){ //gets money from register
        Cash[] registers = getRegisters();
        return registers;
    }

    public void refillRegis(){
        
    }

    
}
