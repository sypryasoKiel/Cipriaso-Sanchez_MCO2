import java.util.ArrayList;

public class VendingMachine {
    public Slot[] slotList;
    public CashRegister CashStorage;
    public ArrayList<Transaction> Transactions;

    public VendingMachine(){
        this.CashStorage = new CashRegister(10);
        this.Transactions = new ArrayList<>();
    }

    public void setSlotList(Slot[] slotList){
        this.slotList = slotList;
    }

    public Slot[] getSlotList(){
        return slotList;
    }

    /**
     * converts the double variable to Cash array format
     * @param money the amount to be converted to cash array format
     * @return wallet the value in cash array format
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

        if(money>=0.25){
            wallet[9].addQuantity((int) money*100/25);
            money-=0.25*wallet[9].getQuantity();
        }

        if(money>=0.05){
            wallet[10].addQuantity((int) money*100/5);
            money-=0.05*wallet[10].getQuantity();
        }

        if(money>=0.01){
            wallet[11].addQuantity((int) money*100);
        }

        return wallet;
    }

    /**
     * updates the product of the slot
     * @param product the product to be updated
     * @param slotIndex the index of the slot to be updated
     */
    public void updateSlotProducts(Item product, int slotIndex){ //changes the product of the slot, removes all previous item in the slot
        this.slotList[slotIndex].setProduct(product);
    }

    /**
     * checks if the change can be given by the cash register
     * @param change the change to be given
     * @return true if the change can be given, false if not
     */
    public boolean isChangeAvailable(Cash[] change){ //checks if change can be given by the cash register
        for(int i=0;i<CashStorage.getRegister().length;i++){
            if(change[i].getQuantity()>this.CashStorage.getRegister()[i].getQuantity())
                return false;
        }
        return true;
    }

    /**
     * calculates the change to be given
     * @param payment the payment given by the user
     * @param product the product to be bought
     * @return change the change to be given
     */
    public double calculateChange(double payment, Item product){
        return payment-product.getPrice();
    } //calculates the change to be produced in double format

    /**
     * produces the change to be given
     * @param payment the payment given by the user
     * @param product the product to be bought
     * @return change the change to be given
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
     * @param payment the payment given by the user
     * @param slotNum the slot number of the product to be bought
     * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
     */
    public int checkBuy(double payment, int slotNum){ //checks the criteria for a transaction, returns: 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
        Cash[] cashChange;
        double doubleChange;

        doubleChange = calculateChange(payment, slotList[slotNum-1].getProduct());

        if(doubleChange<0){ //checks if the payment is less than the price of the item
            return 0;
        }
        else{
            cashChange = doubleToCash(doubleChange);
            if(isChangeAvailable(cashChange)){ //checks if the machine can provide change
                if(this.slotList[slotNum-1].sellItem()){ //checks if the item is available
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
     * buys the item
     * @param payment the payment given by the user
     * @param slotNum the slot number of the product to be bought by the user
     * @return 1 if the transaction was a success, 0 if the payment was not enough, -1 if the machine cant give change, and -2 if the item is unavailable/out of stock
     */
    public int buyItem(double payment, int slotNum){ //makes a transaction log and sells the actual item, returns the criteria to be handled by the controller
        int checkbuy;

        checkbuy=checkBuy(payment,slotNum);

        switch(checkbuy){
            case 1:
                this.slotList[slotNum-1].sellItem();
                this.Transactions.add(new Transaction("Sold Item",this.slotList[slotNum].getProduct(),produceChange(payment,slotList[slotNum-1].getProduct())));
                return 1;

            case 0:
                this.Transactions.add(new Transaction("Refunded - Not Enough Money",this.slotList[slotNum].getProduct(),doubleToCash(payment)));
                return 0;

            case -1:
                this.Transactions.add(new Transaction("Refunded - Item Unavailable",this.slotList[slotNum].getProduct(),doubleToCash(payment)));
                return -1;

            case -2:
                this.Transactions.add(new Transaction("Refunded - Not Enough Change",this.slotList[slotNum].getProduct(),doubleToCash(payment)));
                return -2;

            default:
                return -3;
        }
    }

    /**
     * gets the transactions
     * @return the transactions
     */
    public int[] getQuantities(){ //gets the quantities of the items and store them in an int array, to be used for checking initial and current number of stocks
        int slotLength = this.slotList.length;
        int[] quantities = new int[slotLength];

        for(int i=0;i<slotLength;i++){
            quantities[i] = this.slotList[i].getQuantity();
        }
        return quantities;
    }
}


