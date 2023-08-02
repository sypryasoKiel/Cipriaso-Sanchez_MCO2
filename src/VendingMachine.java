import java.util.ArrayList;
/**
 * VendingMachine class
 * This class is the superclass of RVMachine and SVMachine
 */
public class VendingMachine {
    /**
     * This is the list of slots in the vending machine
     */
    public Slot[] slotList;
    /**
     * This is the cash storage of the vending machine
     */
    public CashRegister CashStorage;
    /**
     * This is the list of transactions of the vending machine
     */
    public ArrayList<Transaction> Transactions;

    /**
     * This is the constructor for the VendingMachine class
     */
    public VendingMachine(){
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }

    /**
     * gets the slot list
     * @return slotList the slot list
     */
    public Slot[] getSlotList(){
        return slotList;
    }
    /**
     * gets the transactions
     * @return Transactions the transactions
     */
    public ArrayList<Transaction> getTransactions(){
        return this.Transactions;
    }
    /**
     * gets the cash storage
     * @return CashStorage the cash storage
     */
    public CashRegister getCashStorage() {
        return CashStorage;
    }

    /**
     *  converts a money in double format to cash array format
     * @param money the money to be converted
     * @return wallet  the cash array format of the money
     */
    public Cash[] doubleToCash(double money){ //transforms a money in double format (i.e. PHP 1234.56) to cash array format (i.e. 1x 1000, 1x 200, 1x 20, 1x 10, 4x 1, 2x 0.25, 1x 0.05, 1x 0.01)
        Cash[] wallet = new Cash[12];

        wallet[0] = new Cash(1000,0);
        wallet[1] = new Cash(500,0);
        wallet[2] = new Cash(200,0);
        wallet[3] = new Cash(100,0);
        wallet[4] = new Cash(50,0);
        wallet[5] = new Cash(20,0);
        wallet[6] = new Cash(10,0);
        wallet[7] = new Cash(5,0);
        wallet[8] = new Cash(1,0);
        wallet[9] = new Cash(0.25,0);
        wallet[10] = new Cash(0.05,0);
        wallet[11] = new Cash(0.01,0);



        if(money>=1000){
            wallet[0].addQuantity((int) money/1000);
            money-=1000*wallet[0].getQuantity();
        }

        if(money>=500){
            wallet[1].addQuantity((int) money/500);
            money-=500*wallet[1].getQuantity();
        }

        if(money>=200){
            wallet[2].addQuantity((int) money/200);
            money-=200*wallet[2].getQuantity();
        }

        if(money>=100){
            wallet[3].addQuantity((int) money/100);
            money-=100*wallet[3].getQuantity();
        }

        if(money>=50){
            wallet[4].addQuantity((int) money/50);
            money-=50*wallet[4].getQuantity();
        }

        if(money>=20){
            wallet[5].addQuantity((int) money/20);
            money-=20*wallet[5].getQuantity();
        }

        if(money>=10){
            wallet[6].addQuantity((int) money/10);
            money-=10*wallet[6].getQuantity();
        }

        if(money>=5){
            wallet[7].addQuantity((int) money/5);
            money-=5*wallet[7].getQuantity();
        }

        if(money>=1){
            wallet[8].addQuantity((int) money);
            money-=wallet[8].getQuantity();
        }

        if(money >= 0.25){
            int temp = (int) (money*100/25);
            wallet[9].addQuantity(temp);
            money-=0.25*temp;
        }
        if(money >= 0.05){
            int temp = (int) (money*100/5);
            wallet[10].addQuantity(temp);
            money-=0.05*temp;
        }
        if(money >= 0.01){
            money*=100;
            int temp=(int) money;
            wallet[11].addQuantity(temp);
        }

        return wallet;
    }

    /**
     * checks if change can be given by the cash register
     * @param change the change to be given
     * @return true if change can be given, false if not
     */
    public boolean isChangeAvailable(Cash[] change){ //checks if change can be given by the cash register
        for(int i=0;i<CashStorage.getRegister().length;i++){
            if(change[i].getQuantity()>this.CashStorage.getRegister()[i].getQuantity())
                return false;
        }
        return true;
    }

    /**
     * calculates the change to be produced
     * @param payment the payment
     * @param product the product
     * @return the change to be produced
     */
    public double calculateChange(double payment, Item product){
        return payment-product.getPrice();
    } //calculates the change to be produced in double format

    /**
     * produces the change needed to give in cash array format
     * @param payment the payment
     * @param product the product
     * @return the change needed to give in cash array format
     */
    public Cash[] produceChange(double payment, Item product){ //produces the change needed to give in cash array format
        Cash[] change = doubleToCash(calculateChange(payment,product));

        for(int i=0;i<CashStorage.getRegister().length;i++){
            this.CashStorage.removeCash(change[i]);
        }
        return change;
    }

    /**
     * checks if the transaction is valid
     * @param payment the payment
     * @param slotNum the slot number
     * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
     */
    public int checkBuy(double payment, int slotNum){ //checks the criteria for a transaction, returns: 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
        Cash[] cashChange;
        double doubleChange;

        doubleChange = calculateChange(payment, slotList[slotNum].getProduct());

        if(doubleChange<0){ //checks if the payment is less than the price of the item
            return 0;
        }
        else{
            cashChange = doubleToCash(doubleChange);
            if(isChangeAvailable(cashChange)){ //checks if the machine can provide change
                if(this.slotList[slotNum].sellItem()){ //checks if the item is available
                    return 1;
                }
                else
                    return -1;
            }
            else
                return -2;
        }
    }

    /**
     * buys an item
     * @param payment the payment
     * @param slotNum the slot number
     * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
     */
    public int buyItem(double payment, int slotNum){ //makes a transaction log and sells the actual item, returns the criteria to be handled by the controller
        int checkbuy;

        checkbuy=checkBuy(payment,slotNum);

        switch(checkbuy){
            case 1:
                this.slotList[slotNum].sellItem();
                this.Transactions.add(new Transaction("Sold Item",this.slotList[slotNum].getProduct().getName(),produceChange(payment,slotList[slotNum].getProduct())));
                return 1;

            case 0:
                this.Transactions.add(new Transaction("Refunded - Not Enough Money",this.slotList[slotNum].getProduct().getName(),doubleToCash(payment)));
                return 0;

            case -1:
                this.Transactions.add(new Transaction("Refunded - Item Unavailable",this.slotList[slotNum].getProduct().getName(),doubleToCash(payment)));
                return -1;

            case -2:
                this.Transactions.add(new Transaction("Refunded - Not Enough Change",this.slotList[slotNum].getProduct().getName(),doubleToCash(payment)));
                return -2;

            default:
                return -3;
        }
    }
}


