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

    public Cash[] getCash(){
        return this.cash;
    }

    public void refillMoneyRegis(CashRegister[] registers, Cash[] cash){
        for(int i=0;i<cashCount;i++){
            registers[i].addCash(cash[i]);
        }
    }

    
}
