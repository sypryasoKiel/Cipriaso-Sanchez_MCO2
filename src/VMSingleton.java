public class VMSingleton {
    private final VendingMachine data;

    private static VMSingleton instance;

    private VMSingleton(VendingMachine data) {
        this.data = data;
    }
    public static VMSingleton getInstance(VendingMachine data) {
            if (instance == null) {
                instance = new VMSingleton(data);
            }
        return instance;
    }

    public VendingMachine getData() {
        return data;
    }
}
