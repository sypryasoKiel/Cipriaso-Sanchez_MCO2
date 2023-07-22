import java.util.ArrayList;

public class Transaction {
    private int[] currentStocks;
    private int[] initialStocks;

    public void addStocks(int slotNum, int qty){
        currentStocks[slotNum-1]+=qty;
        initialStocks[slotNum-1]=currentStocks[slotNum-1];
    }

    public void removeStocks(int slotNum, int qty){
        currentStocks[slotNum-1]-=qty;
    }

    /*
    GUI related methods
     */
    public void displayEarnings(ArrayList<Slot> slotList){

    }

    public void displayStocks(ArrayList<Slot> slotList){

    }
}
