public class Cash {
    private final double DENOMINATION;
    private int Quantity;

    public Cash(double denomination, int qty){
        this.DENOMINATION = denomination;
        this.Quantity = qty;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void addQuantity(int qty){
        if(qty>=1){
            this.Quantity+=qty;
        }
    }

    public void removeQuantity(int qty){
        if(qty>=1 && (this.Quantity-qty)>=0){
            this.Quantity-=qty;
        }
    }

    public double getDenomination(){
        return this.DENOMINATION;
    }
}
