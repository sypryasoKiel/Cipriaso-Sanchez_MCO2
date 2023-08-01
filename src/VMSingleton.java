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

    public void setCurrentVM(VendingMachine currentVM) {
        this.currentVM = currentVM;
    }

    public void deleteCurrentVM(){
        this.currentVM = null;
    }
    public VendingMachine getCurrentVM(){
        return currentVM;
    }
}
