public class VMSingleton {
    private static final VMSingleton instance = new VMSingleton();
    public static VMSingleton getInstance(){
        return instance;
    }
    private VendingMachine VM;

    public void setVM(VendingMachine VM) {
        this.VM = VM;
    }

    public void deleteVM(){
        this.VM=null;
    }

    public VendingMachine getVM() {
        return VM;
    }
}
