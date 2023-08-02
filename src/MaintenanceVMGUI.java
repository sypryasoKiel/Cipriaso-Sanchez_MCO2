import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    @FXML
    private ScrollPane cashPane;
    @FXML
    private TextField cashText;
    @FXML
    private ScrollPane cashPane1;
    @FXML
    private TextField refillText;
    @FXML
    private TextField priceText;
    @FXML
    private ChoiceBox<String> slotChoice;
    @FXML
    private ScrollPane pricePane;
    private Stage stage;
    private Scene scene;
    private Parent root;


    VMSingleton VM = VMSingleton.getInstance();
    private VBox_Controller vfactory = new VBox_Controller();

    /**
     * This method is called when the user clicks on the button.
     * @param event the event that triggers the method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int ctr = 0;
        ArrayList<VBox> box = new ArrayList<>();
        String[] choice = new String[VM.getVM().getSlotList().length];


        for(int i = 0; i<VM.getVM().getSlotList().length; i++){
            ctr++;
            choice[i] = String.valueOf(ctr);
        }

        choiceBox.getItems().addAll(choice);
        choiceBox.setOnAction(this::getData);

        slotChoice.getItems().addAll(choice);
        slotChoice.setOnAction(e->getChoice(slotChoice));

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHgrow(Priority.NEVER);
        columnConstraints1.setPercentWidth(33.3);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHgrow(Priority.NEVER);
        columnConstraints2.setPercentWidth(33.3);
        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        columnConstraints3.setHgrow(Priority.NEVER);
        columnConstraints3.setPercentWidth(33.3);
        ColumnConstraints oneColumn = new ColumnConstraints();
        oneColumn.setPercentWidth(100);
        columnConstraints3.setHgrow(Priority.NEVER);


        GridPane grid2 = new GridPane();
        grid2.setGridLinesVisible(true);
        grid2.getColumnConstraints().addAll(columnConstraints1,columnConstraints2,columnConstraints3);
        for(int i=0;i<3;i++){
            for(int j = 0; j<VM.getVM().getSlotList().length; j++){
                if(i==0){
                    grid2.add(new Label("Slot #"+(j+1)),i,j);
                }
                else if(i==1){
                    grid2.add(new Label("\n"+VM.getVM().getSlotList()[j].getQuantity()+"\n"),i,j);
                }
                else if(i==2){
                    grid2.add(new Label("\n"+VM.getVM().getSlotList()[j].getMaxQty()+"\n"),i,j);
                }
            }
        }

        restockScroll.setContent(grid2);
        restockScroll.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        GridPane grid1 = new GridPane();
        grid1.getColumnConstraints().add(oneColumn);
        grid1.setGridLinesVisible(true);

        for(int i = 0; i<VM.getVM().getTransactions().size(); i++){
            box.add(vfactory.transactionFactory(VM.getVM().getTransactions().get(i)));
        }

        for(int i = 0; i<VM.getVM().getTransactions().size(); i++){
            grid1.add(box.get(i),0,i);
        }

        scrollPane.setContent(grid1);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        GridPane grid3 = new GridPane();
        ColumnConstraints columnConstraints4 = new ColumnConstraints();
        ColumnConstraints columnConstraints5 = new ColumnConstraints();
        columnConstraints4.setPercentWidth(50);
        columnConstraints4.setHgrow(Priority.ALWAYS);
        columnConstraints5.setPercentWidth(50);
        columnConstraints5.setHgrow(Priority.ALWAYS);

        grid3.getColumnConstraints().addAll(columnConstraints4,columnConstraints5);
        grid3.setGridLinesVisible(true);

        for(int i = 0; i<VM.getVM().getCashStorage().getRegister().length; i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    grid3.add(new Label("PHP "+VM.getVM().getCashStorage().getRegister()[i].getDenomination()+"\n"),j,i);
                }
                else{
                    grid3.add(new Label("x "+VM.getVM().getCashStorage().getRegister()[i].getQuantity()+"\n"),j,i);
                }
            }
        }

        cashPane.setContent(grid3);
        cashPane.setFitToHeight(true);
        cashPane.setFitToWidth(true);

        GridPane grid4 = new GridPane();
        grid4.getColumnConstraints().addAll(columnConstraints4,columnConstraints5);
        grid4.setGridLinesVisible(true);

        for(int i = 0; i<VM.getVM().getCashStorage().getRegister().length; i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    grid4.add(new Label("PHP "+VM.getVM().getCashStorage().getRegister()[i].getDenomination()+"\n"),j,i);
                }
                else{
                    grid4.add(new Label("x "+VM.getVM().getCashStorage().getRegister()[i].getQuantity()+"\n"),j,i);
                }
            }
        }

        cashPane1.setContent(grid4);
        cashPane1.setFitToHeight(true);
        cashPane1.setFitToWidth(true);

        GridPane grid5 = new GridPane();
        grid5.getColumnConstraints().addAll(columnConstraints4,columnConstraints5);
        grid5.setGridLinesVisible(true);

        for(int i = 0; i<VM.getVM().getCashStorage().getRegister().length; i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    grid5.add(new Label(VM.getVM().getSlotList()[i].getProduct().getName()),j,i);
                }
                else{
                    grid5.add(new Label("PHP "+(VM.getVM().getSlotList()[i].getProduct().getPrice())),j,i);
                }
            }
        }

        pricePane.setContent(grid5);
        pricePane.setFitToHeight(true);
        pricePane.setFitToWidth(true);
    }
    /**
     * This method is used to get the data from the choice box
     * @param e ActionEvent
     * @return String the data from the choice box
     */
    public String getData(ActionEvent e){
        String choice = choiceBox.getValue();
        return choice;
    }

    /**
     * This method is used to get the choice
     * @param slotChoice ChoiceBox
     * @return String the choice
     */
    public String getChoice(ChoiceBox<String> slotChoice){
        String choice =slotChoice.getValue();
        return choice;
    }
    /**
     * restock button
     * @param e ActionEvent
     * @throws IOException IOException
     */
    public void restock(ActionEvent e) throws IOException {
        int qty;
        int slot;
        try{
            slot = Integer.parseInt(choiceBox.getValue())-1;
            qty=Integer.parseInt(restockField.getText());
            if(!VM.getVM().getSlotList()[slot].addItem(qty)){
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

    /**
     * get cash button
     * @param event ActionEvent
     * @throws IOException IOException
     */
    public void getCash(ActionEvent event) throws IOException{
        double test,cash;
        Cash[] wallet;

        try{
            test=Double.parseDouble(cashText.getText());
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Input!!");
            alert.showAndWait();
        }
        cash=Double.parseDouble(cashText.getText());
        wallet=VM.getVM().doubleToCash(cash);
        for(int i=0;i< wallet.length;i++){
            System.out.printf("Cash : %f %d\n",wallet[i].getDenomination(),wallet[i].getQuantity());
        }
        if(VM.getVM().isChangeAvailable(wallet)){
            for(int i=0;i<VM.getVM().getCashStorage().getRegister().length;i++){
                VM.getVM().getCashStorage().removeCash(wallet[i]);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Get Success!!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceVMGUI.fxml"));
            root = loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Insufficient Balance!!");
            alert.showAndWait();
        }


    }

    /**
     * refill register button
     * @param event ActionEvent
     * @throws IOException IOException
     */
    public void refillRegister(ActionEvent event) throws IOException {
        double test, cash;
        Cash[] wallet;

        try {
            test = Double.parseDouble(refillText.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Input!!");
            alert.showAndWait();
        }
        cash = Double.parseDouble(refillText.getText());
        wallet = VM.getVM().doubleToCash(cash);

        for (int i = 0; i < wallet.length; i++) {
            VM.getVM().getCashStorage().addCash(wallet[i]);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vending Machine");
        alert.setHeaderText(null);
        alert.setContentText("Refill Success!!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * set price button
     * @param event ActionEvent
     * @throws IOException IOException
     */
    public void setPrice(ActionEvent event) throws IOException{
        double price;
        int slot;

        try{
            slot = Integer.parseInt(getChoice(slotChoice))-1;
            price=Double.parseDouble(priceText.getText());
            if(!VM.getVM().getSlotList()[slot].getProduct().setPrice(price)){
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
                alert.setContentText("Set Price Successfully!!");
                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceVMGUI.fxml"));
                root = loader.load();
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Integer inputs only!!");
            alert.showAndWait();
        }
    }
    /**
     * back button
     * @param event ActionEvent
     * @throws IOException IOException
     */
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
