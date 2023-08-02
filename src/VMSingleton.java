/**
 * VMSingleton class is used to create a single instance of the vending machine
 */
public class VMSingleton {
    private static VMSingleton instance;
    private VendingMachine VM;

    /**
     * constructor for the VMSingleton
     */
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
    public void setupVM(VendingMachine currentVM) {
        this.VM = currentVM;
    }

    /**
     * deletes the current vending machine
     */
    public void deleteVM(){
        this.VM = null;
    }
    /**
     * gets the current vending machine
     * @return currentVM the current vending machine
     */
    public VendingMachine getVM(){
        return VM;
    }
}
