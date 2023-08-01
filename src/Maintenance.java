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
    VMSingleton VM = VMSingleton.getInstance();

    /**
     * sets the price of the item
     * @param price the price
     */
    public void setItemPrice(double price,int slotNum){
        VM.getCurrentVM().getSlotList()[slotNum].getProduct().setPrice(price);
    }

    /**
     * refills the stock of that slot
     */
    public void refillStock(int qty, int slotNum){
        VM.getCurrentVM().getSlotList()[slotNum-1].addItem(qty);
    }

    /**
     * replaces the Item in the slot
     * @param item the item
     * @param index the index of the item
     */
    public void replaceItemSlots(int index, Item item){
        this.slots[index].setProduct(item);
    }

    /**
     * gets the transaction history
     * @return transactionHistory the transaction history
     */
    public String getTransactionHistory(){
        String transactionHistory = "";
        for(int i=0;i<transactionCount;i++){
            transactionHistory += transactions[i].getProduct() + " "+ transactions[i].getTransactionType() + "\n";
        }
        return transactionHistory;
    }

    /**
     * gets the cash
     * @return cash the amount cash
     */
    public Cash[] getCash(){
        return this.cash;
    }

    /**
     * refills the money in the register
     * @param registers the registers
     * @param cash the amount of cash
     */
    public void refillMoneyRegis(CashRegister[] registers, Cash[] cash){
        for(int i=0;i<cashCount;i++){
            registers[i].addCash(cash[i]);
        }
    }

    
}
