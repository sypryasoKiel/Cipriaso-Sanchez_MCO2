public class Factory {

    private int choice;
    private int NumSlot;
    private int MaxCap;

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setNumSlot(int numSlot) {
        NumSlot = numSlot;
    }

    public void setMaxCap(int maxCap) {
        MaxCap = maxCap;
    }

    public int getNumSlot() {
        return NumSlot;
    }

    public int getMaxCap() {
        return MaxCap;
    }

    public VendingMachine createVendingMachine(){
        switch(choice){
            case 1:
                return new VendingMachine(getNumSlot(),getMaxCap());

            default:
                return null;
        }
    }
}
