import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuySuccess_Controller implements Initializable {

    @FXML
    private Label changePane;
    @FXML
    private ScrollPane receiptPane;
    @FXML
    private Button backButton;
    @FXML
    private Label total;
    private Stage stage;
    private Scene scene;
    private Parent root;
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

        System.out.println("Denom : "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[0].getDenomination());
        System.out.println("Denom : "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[0].getQuantity());

        for(int i = 0; i<VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash().length; i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    grid3.add(new Label("PHP "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getDenomination()),j,i);
                }
                else{
                    grid3.add(new Label("x "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getQuantity()),j,i);
                }
            }
        }
        for(int i = 0; i<VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash().length; i++){
            totalChange+=VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getDenomination()*VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getQuantity();
        }


        total.setText("Change : "+totalChange);
        receiptPane.setContent(grid3);
        receiptPane.setFitToWidth(true);
        receiptPane.setFitToHeight(false);
        changePane.setText("Change : PHP "+String.format("%.2f",totalChange));
    }

    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
