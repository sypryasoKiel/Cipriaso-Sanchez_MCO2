/**
 * Factory class that creates a vending machine
 */
public class Factory {
    private VendingMachine VM;
    VMSingleton vm = VMSingleton.getInstance();

    /**
     * Initializes the items in the vending machine
     * @return itemList the list of items in the vending machine
     */
    public Item[] itemInit(){
        Item[] itemList = new Item[16];

        itemList[0] = new Item(80.10,"Egg",10.50);
        itemList[1] = new Item(60.25,"Flour",75.00);
        itemList[2] = new Item(300.04,"Chocolate",150.50);
        itemList[3] = new Item(450.50,"Butter",105.50);
        itemList[4] = new Item(600.75,"Vanilla Extract",250.75);
        itemList[5] = new Item(200.60,"Baking Powder",35.00);
        itemList[6] = new Item(300.90,"Milk",250.50);
        itemList[7] = new Item(120.60,"Rainbow Sprinkles",50.00);
        itemList[8] = new Item(140.50,"Chocolate Chips",60.00);
        itemList[9] = new Item(100.50,"Sugar",45.50);
        itemList[10] = new Item(1250.60,"Chocolate Cake",645.50);
        itemList[11] = new Item(1450.50,"Black Forest Cake",875.50);
        itemList[12] = new Item(700.50,"Cornbread Muffin",145.50);
        itemList[13] = new Item(500.40,"Vanilla Cupcake",105.50);
        itemList[14] = new Item(350.75,"Baguette",85.50);

        return itemList;
    }

    /**
     * Creates a vending machine
     * @param type the tyep of vending machine
     * @param maxcap the maximum capacity of the vending machine
     */
    public void createVendingMachine(String type, int maxcap){
        RVMachine regular;
        SVMachine special;
        Slot[] slotList = new Slot[15];
        Item[] items = itemInit();

        vm.deleteVM();

        for(int i=0;i<15;i++){
            slotList[i] = new Slot(maxcap);
            slotList[i].setProduct(items[i]);
            slotList[i].addItem(10);
        }

        switch(type){
            case "Regular":
                regular=new RVMachine(slotList);
                vm.setupVM(regular);
                break;

            case "Special":
                special=new SVMachine(slotList);
                vm.setupVM(special);
                break;

            default:
                System.out.println("bruh");
        }
    }
}
