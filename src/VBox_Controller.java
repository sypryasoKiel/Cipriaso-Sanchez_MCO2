import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class VBox_Controller {
    private VBox slotFrame;
    VMSingleton VM = VMSingleton.getInstance();

    /**
     * produces the receipt of the transaction
     * @param transaction the transaction to be printed
     * @return initial the receipt
     */
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

        textbox.setPrefRowCount(3);
        textbox.setFont(new Font("Arial Black",15));
        textbox.setText("Transaction Type : "+transaction.getTransactionType()+"\nProduct : "+transaction.getProductName()+"\nReturned Cash : ");

        for(int i=0;i<transaction.getReturnedCash().length;i++){
            for(int j=0;j<2;j++){
                if(j==1){
                    returnedCash.add(new Label("x "+transaction.getReturnedCash()[i].getQuantity()),j,i);
                }
                else{
                    returnedCash.add(new Label("PHP "+transaction.getReturnedCash()[i].getDenomination()),j,i);
                }
            }
        }

        initial.getChildren().addAll(textbox,returnedCash);

        return initial;
    }
}
