public class Factory {

    private int choice;
    private int NumSlot;
    private int MaxCap;

    /**
     * sets the choice of the user
     * @param choice
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }

    /**
     * sets the number of slots
     * @param numSlot
     */
    public void setNumSlot(int numSlot) {
        NumSlot = numSlot;
    }

    /**
     * sets the maximum capacity of the slots
     * @param maxCap
     */
    public void setMaxCap(int maxCap) {
        MaxCap = maxCap;
    }

    /**
     * gets number of slots
     * @return NumSlot the number of slots
     */
    public int getNumSlot() {
        return NumSlot;
    }

    /**
     * gets the maximum capacity of the slots
     * @return MaxCap the maximum capacity of the slots
     */
    public int getMaxCap() {
        return MaxCap;
    }

    /**
     * creates a vending machine
     * @return VendingMachine the vending machine
     */
    public VendingMachine createVendingMachine(){
        switch(choice){
            case 1:
                return new VendingMachine(getNumSlot(),getMaxCap());

            default:
                return null;
        }
    }
}
