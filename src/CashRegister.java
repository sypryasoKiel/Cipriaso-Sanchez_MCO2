    public class CashRegister {
    private Cash[] Register;

    /**
     * Constructor for objects of class CashRegister
     * @param qty
     */
    public CashRegister(int qty){
        this.Register=new Cash[12];
        this.Register[0] = new Cash(1000,qty);
        this.Register[1] = new Cash(500,qty);
        this.Register[2] = new Cash(200,qty);
        this.Register[3] = new Cash(100,qty);
        this.Register[4] = new Cash(50,qty);
        this.Register[5] = new Cash(20,qty);
        this.Register[6] = new Cash(10,qty);
        this.Register[7] = new Cash(5,qty);
        this.Register[8] = new Cash(1,qty);
        this.Register[9] = new Cash(0.25,qty);
        this.Register[10] = new Cash(0.5,qty);
        this.Register[11] = new Cash(0.01,qty);
    }


    /**
     * Adds cash to the register
     * @param cash
     */
    public void addCash(Cash cash){ //adds cash to register
        for(int i=0;i<Register.length;i++){
            if(cash.getDenomination()==Register[i].getDenomination()){
                Register[i].addQuantity(cash.getQuantity());
            }
        }
    }

    /**
     * Removes cash from the register
     * @param cash
     */
    public void removeCash(Cash cash){ //removes cash from the register
        for(int i=0;i<Register.length;i++){
            if(cash.getDenomination()==Register[i].getDenomination()){
                Register[i].removeQuantity(cash.getQuantity());
            }
        }
    }


    /**
     * Gets the register
     * @return Register the register array
     */
    public Cash[] getRegister(){
        return this.Register;
    } //gets the register
}
