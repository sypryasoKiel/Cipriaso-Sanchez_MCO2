import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MaintenanceVMGUI implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField restockField;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ScrollPane restockScroll;
    private Stage stage;
    private Scene scene;
    private Parent root;


    VMSingleton VM = VMSingleton.getInstance();
    private VBox_Controller vfactory = new VBox_Controller();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int ctr = 0;
        ArrayList<VBox> box = new ArrayList<>();
        String[] choice = new String[VM.getCurrentVM().getSlotList().length];
        for(int i=0;i<VM.getCurrentVM().getSlotList().length;i++){
            ctr++;
            choice[i] = String.valueOf(ctr);
        }
        choiceBox.getItems().addAll(choice);
        choiceBox.setOnAction(this::getData);
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(Priority.NEVER);
        columnConstraints1.setPercentWidth(33.3);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHgrow(Priority.NEVER);
        columnConstraints2.setPercentWidth(33.3);
        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        columnConstraints3.setHgrow(Priority.NEVER);
        columnConstraints3.setPercentWidth(33.3);


        GridPane grid2 = new GridPane();
        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().addAll(columnConstraints1,columnConstraints2,columnConstraints3);
        for(int i=0;i<3;i++){
            for(int j=0;j<VM.getCurrentVM().getSlotList().length;j++){
                if(i==0){
                    grid2.add(new Label("Slot #"+(j+1)),i,j);
                }
                else if(i==1){
                    grid2.add(new Label("\n"+VM.getCurrentVM().getSlotList()[j].getQuantity()+"\n"),i,j);
                }
                else if(i==2){
                    grid2.add(new Label("\n"+VM.getCurrentVM().getSlotList()[j].getMaxQty()+"\n"),i,j);
                }
            }
        }

        restockScroll.setContent(grid2);
        restockScroll.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        GridPane grid1 = new GridPane();
        grid1.getColumnConstraints().addAll(columnConstraints1,columnConstraints2,columnConstraints3);
        grid1.setGridLinesVisible(true);

        for(int i=0;i<VM.getCurrentVM().getTransactions().size();i++){
            box.add(vfactory.transactionFactory(VM.getCurrentVM().getTransactions().get(i)));
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<VM.getCurrentVM().getTransactions().size();j++){
                if(VM.getCurrentVM().getTransactions().size()!=0)
                    grid1.add(box.get(i*10+j),i,j);
            }
        }

        scrollPane.setContent(grid1);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);


    }
    public String getData(ActionEvent e){
        String choice = choiceBox.getValue();
        return choice;
    }

    public void restock(ActionEvent e) throws IOException {
        int qty;
        int slot;
        try{
            slot = Integer.parseInt(choiceBox.getValue())-1;
            qty=Integer.parseInt(restockField.getText());
            if(!VM.getCurrentVM().getSlotList()[slot].addItem(qty)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Vending Machine");
                alert.setHeaderText(null);
                alert.setContentText("No zeroes and negatives or inputs the are past max capacity!!");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vending Machine");
                alert.setHeaderText(null);
                alert.setContentText("Restocked Successfully!!");
                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceVMGUI.fxml"));
                root = loader.load();
                stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch(NumberFormatException event){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Integer inputs only!!");
            alert.showAndWait();
        }
    }
}
