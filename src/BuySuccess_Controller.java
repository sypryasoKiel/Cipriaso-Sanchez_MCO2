import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class BuySuccess_Controller implements Initializable {

    @FXML
    private Label changePane;
    @FXML
    private ScrollPane receiptPane;
    VMSingleton VM = VMSingleton.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double totalChange=0;
        ColumnConstraints columnConstraints4 = new ColumnConstraints();
        ColumnConstraints columnConstraints5 = new ColumnConstraints();
        columnConstraints4.setPercentWidth(50);
        columnConstraints4.setHgrow(Priority.NEVER);
        columnConstraints5.setPercentWidth(50);
        columnConstraints5.setHgrow(Priority.NEVER);

        GridPane grid3 = new GridPane();
        grid3.getColumnConstraints().addAll(columnConstraints4,columnConstraints5);

        System.out.println("Denom : "+VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[0].getDenomination());
        System.out.println("Denom : "+VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[0].getQuantity());

        for(int i=0;i<VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash().length;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    grid3.add(new Label("PHP "+VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[i].getDenomination()),j,i);
                }
                else{
                    grid3.add(new Label("x "+VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[i].getQuantity()),j,i);
                }
            }
        }
        for(int i=0;i<VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash().length;i++){
            totalChange+=VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[i].getDenomination()*VM.getCurrentVM().getTransactions().get(VM.getCurrentVM().getTransactions().size()-1).getReturnedCash()[i].getQuantity();
        }

        receiptPane.setContent(grid3);
        receiptPane.setFitToWidth(true);
        receiptPane.setFitToHeight(false);
        changePane.setText("Change : PHP "+totalChange);
    }
}
