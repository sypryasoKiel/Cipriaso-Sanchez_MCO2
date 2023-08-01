import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class VBox_Controller {
    private VBox slotFrame;
    VMSingleton VM = VMSingleton.getInstance();

    public VBox transactionFactory(Transaction transaction){
        VBox initial = new VBox();
        TextArea textbox = new TextArea();
        GridPane returnedCash = new GridPane();

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(50);
        columnConstraints1.setHgrow(Priority.NEVER);

        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPercentWidth(50);
        columnConstraints2.setHgrow(Priority.NEVER);

        returnedCash.getColumnConstraints().addAll(columnConstraints1,columnConstraints2);
        returnedCash.setGridLinesVisible(true);

        textbox.setText("Transaction Type : "+transaction.getTransactionType()+"\nProduct : "+transaction.getProduct()+"\nReturned Cash : ");

        for(int i=0;i<transaction.getReturnedCash().length;i++){
            for(int j=0;j<2;i++){
                if(j==1&&(transaction.getReturnedCash()[i].getQuantity()!=0)){
                    returnedCash.add(new Label(String.valueOf(transaction.getReturnedCash()[i].getQuantity())),i,j);
                }
                else{
                    returnedCash.add(new Label(String.valueOf(transaction.getReturnedCash()[i].getDenomination())),i,j);
                }
            }
        }

        initial.getChildren().addAll(textbox,returnedCash);

        return initial;
    }
}
