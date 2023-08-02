
public class Cash {
    private final double DENOMINATION;
    private int Quantity;

    public Cash(double denomination, int qty){
        this.DENOMINATION = denomination;
        this.Quantity = qty;
    }

    /**
     * gets the quantity of the cash
     * @return Quantity the quantity of the cash
     */
    public int getQuantity() {
        return this.Quantity;
    }

    /**
     * adds quantity to the cash
     * @param qty the quantity to be added
     */
    public void addQuantity(int qty){
        if(qty>=1){
            this.Quantity+=qty;
        }
    }

    /**
     * removes quantity from the cash
     * @param qty the quantity to be removed
     */
    public void removeQuantity(int qty){
        if(qty>=1 && (this.Quantity-qty)>=0){
            this.Quantity-=qty;
        }
    }

    /**
     * gets the denomination of the cash
     * @return DENOMINATION the denomination of the cash
     */
    public double getDenomination(){
        return this.DENOMINATION;
    }
}
