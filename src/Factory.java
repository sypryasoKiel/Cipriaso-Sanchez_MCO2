import java.util.Random;

public class Factory {
    private VendingMachine VM;

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
        itemList[14] = new Item(350.75,"Strawberry Donut",85.50);
        itemList[15] = new Item(250.20,"Baguette",60.50);

        return itemList;
    }

    public Slot[] randomInitializer(int numSlots,int maxcap){
        Slot[] intSlot = new Slot[numSlots];
        Item[] itemList = itemInit();
        Random rand = new Random();
        int upperBound = 16;

        for(int i=0;i<numSlots;i++){
            int randomInt = rand.nextInt(upperBound);
            intSlot[i] = new Slot(maxcap);
            intSlot[i].setProduct(itemList[randomInt]);
        }
        return intSlot;
    }


    public VendingMachine createVendingMachine(String type, int numslot, int maxcap){
        RVMachine regular = new RVMachine();
        SVMachine special = new SVMachine();
        Slot[] slotList = randomInitializer(numslot,maxcap);

        switch(type){
            case "Regular":
                regular.setSlotList(slotList);
                return regular;

            case "Special":
                return new SVMachine();

            default:
                return null;
        }
    }
}
