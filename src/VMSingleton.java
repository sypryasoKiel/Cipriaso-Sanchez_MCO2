public class VMSingleton {
    private static VMSingleton instance;
    private VendingMachine currentVM;

    private VMSingleton(){}
    static VMSingleton getInstance() {
        if(instance==null){
            instance = new VMSingleton();
        }
        return instance;
    }

    /**
     * sets the current vending machine
     * @param currentVM the current vending machine
     */
    public void setCurrentVM(VendingMachine currentVM) {
        this.currentVM = currentVM;
    }

    /**
     * deletes the current vending machine
     */
    public void deleteCurrentVM(){
        this.currentVM = null;
    }
    /**
     * gets the current vending machine
     * @return currentVM the current vending machine
     */
    public VendingMachine getCurrentVM(){
        return currentVM;
    }
}
