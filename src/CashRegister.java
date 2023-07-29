
public class CashRegister {
    private Cash[] Register;

    public CashRegister(){
        this.Register=new Cash[12];
        this.Register[0] = new Cash(1000,0);
        this.Register[1] = new Cash(500,0);
        this.Register[2] = new Cash(200,0);
        this.Register[3] = new Cash(100,0);
        this.Register[4] = new Cash(50,0);
        this.Register[5] = new Cash(20,0);
        this.Register[6] = new Cash(10,0);
        this.Register[7] = new Cash(5,0);
        this.Register[8] = new Cash(1,0);
        this.Register[9] = new Cash(0.25,0);
        this.Register[10] = new Cash(0.5,0);
        this.Register[11] = new Cash(0.01,0);
    }

    public void addCash(Cash cash){
        for(int i=0;i<Register.length;i++){
            if(cash.getDenomination()==Register[i].getDenomination()){
                Register[i].addQuantity(cash.getQuantity());
            }
        }
    }

    public void removeCash(Cash cash){
        for(int i=0;i<Register.length;i++){
            if(cash.getDenomination()==Register[i].getDenomination()){
                Register[i].removeQuantity(cash.getQuantity());
            }
        }
    }

    public Cash[] doubleToCash(double money){
        Cash[] wallet = new Cash[12];

        wallet[0] = new Cash(1000,0);
        wallet[1] = new Cash(500,0);
        wallet[2] = new Cash(200,0);
        wallet[3] = new Cash(100,0);
        wallet[4] = new Cash(50,0);
        wallet[5] = new Cash(20,0);
        wallet[6] = new Cash(10,0);
        wallet[7] = new Cash(5,0);
        wallet[8] = new Cash(1,0);
        wallet[9] = new Cash(0.25,0);
        wallet[10] = new Cash(0.05,0);
        wallet[11] = new Cash(0.01,0);



        if(money>=1000){
            wallet[0].addQuantity((int) money/1000);
            money-=1000*wallet[0].getQuantity();
        }

        if(money>=500){
            wallet[1].addQuantity((int) money/500);
            money-=500*wallet[1].getQuantity();
        }

        if(money>=200){
            wallet[2].addQuantity((int) money/200);
            money-=200*wallet[2].getQuantity();
        }

        if(money>=100){
            wallet[3].addQuantity((int) money/100);
            money-=100*wallet[3].getQuantity();
        }

        if(money>=50){
            wallet[4].addQuantity((int) money/50);
            money-=50*wallet[4].getQuantity();
        }

        if(money>=20){
            wallet[5].addQuantity((int) money/20);
            money-=20*wallet[5].getQuantity();
        }

        if(money>=10){
            wallet[6].addQuantity((int) money/10);
            money-=10*wallet[6].getQuantity();
        }

        if(money>=5){
            wallet[7].addQuantity((int) money/5);
            money-=5*wallet[7].getQuantity();
        }

        if(money>=1){
            wallet[8].addQuantity((int) money);
            money-=wallet[8].getQuantity();
        }

        if(money>=0.25){
            wallet[9].addQuantity((int) money*100/25);
            money-=0.25*wallet[9].getQuantity();
        }

        if(money>=0.05){
            wallet[10].addQuantity((int) money*100/5);
            money-=0.05*wallet[10].getQuantity();
        }

        if(money>=0.01){
            wallet[11].addQuantity((int) money*100);
            money-=0.01*wallet[11].getQuantity();
        }

        return wallet;
    }

    public Cash[] getRegister(){
        return this.Register;
    }
}
