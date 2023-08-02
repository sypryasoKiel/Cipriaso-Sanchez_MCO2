import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class CustomItemsVMGUI implements Initializable {

    @FXML
    private GridPane itemGrid;
    @FXML
    private ScrollPane itemPane;
    @FXML
    private TextArea itemsPickedPane;
    @FXML
    private TextField paidField;
    @FXML
    private TextField priceField;
    @FXML
    private Spinner<Integer> spin1;

    @FXML
    private Spinner<Integer> spin10;

    @FXML
    private Spinner<Integer> spin11;

    @FXML
    private Spinner<Integer> spin12;

    @FXML
    private Spinner<Integer> spin13;

    @FXML
    private Spinner<Integer> spin14;

    @FXML
    private Spinner<Integer> spin15;

    @FXML
    private Spinner<Integer> spin2;

    @FXML
    private Spinner<Integer> spin3;

    @FXML
    private Spinner<Integer> spin4;

    @FXML
    private Spinner<Integer> spin5;

    @FXML
    private Spinner<Integer> spin6;

    @FXML
    private Spinner<Integer> spin7;

    @FXML
    private Spinner<Integer> spin8;

    @FXML
    private Spinner<Integer> spin9;
    private Stage stage;
    private Scene scene;
    private Parent root;
    VMSingleton VM = VMSingleton.getInstance();
    private double counter=0;
    private double spinCounter=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> spinValue1 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[0].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue2 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[1].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue3 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[2].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue4 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[3].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue5 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[4].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue6 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[5].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue7 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[6].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue8 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[7].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue9 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[8].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue10 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[9].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue11 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[10].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue12 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[11].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue13 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[12].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue14 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[13].getQuantity(),0);
        SpinnerValueFactory<Integer> spinValue15 = new SpinnerValueFactory.IntegerSpinnerValueFactory
                (0,VM.getVM().slotList[14].getQuantity(),0);

        spinValue1.setValue(0);
        spinValue2.setValue(0);
        spinValue3.setValue(0);
        spinValue4.setValue(0);
        spinValue5.setValue(0);
        spinValue6.setValue(0);
        spinValue7.setValue(0);
        spinValue8.setValue(0);
        spinValue9.setValue(0);
        spinValue10.setValue(0);
        spinValue11.setValue(0);
        spinValue12.setValue(0);
        spinValue13.setValue(0);
        spinValue14.setValue(0);
        spinValue15.setValue(0);

        spin1.setValueFactory(spinValue1);
        spin2.setValueFactory(spinValue2);
        spin3.setValueFactory(spinValue3);
        spin4.setValueFactory(spinValue4);
        spin5.setValueFactory(spinValue5);
        spin6.setValueFactory(spinValue6);
        spin7.setValueFactory(spinValue7);
        spin8.setValueFactory(spinValue8);
        spin9.setValueFactory(spinValue9);
        spin10.setValueFactory(spinValue10);
        spin11.setValueFactory(spinValue11);
        spin12.setValueFactory(spinValue12);
        spin13.setValueFactory(spinValue13);
        spin14.setValueFactory(spinValue14);
        spin15.setValueFactory(spinValue15);
    }

    public void buttonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        paidField.setText(String.valueOf(String.format("%.2f",counter)));
    }

    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void spinnerClick(ActionEvent event){
        Spinner spin = (Spinner) event.getSource();

    }

    public void update(ActionEvent event){
        double totalPrice=0;

        ((SVMachine) VM.getVM()).clearList();
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[0].getProduct(),spin1.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[1].getProduct(),spin2.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[2].getProduct(),spin3.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[3].getProduct(),spin4.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[4].getProduct(),spin5.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[5].getProduct(),spin6.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[6].getProduct(),spin7.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[7].getProduct(),spin8.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[8].getProduct(),spin9.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[9].getProduct(),spin10.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[10].getProduct(),spin11.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[11].getProduct(),spin12.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[12].getProduct(),spin13.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[13].getProduct(),spin14.getValue());
        ((SVMachine) VM.getVM()).addItemToBundle( VM.getVM().getSlotList()[14].getProduct(),spin15.getValue());

        itemsPickedPane.setText("Items Picked : "+((SVMachine) VM.getVM()).setItemsText());

        for(int i=0; i < ((SVMachine) VM.getVM()).getItemBundle().size();i++){
            totalPrice+=((SVMachine) VM.getVM()).getItemBundle().get(i).getPrice();
        }

        priceField.setText(String.valueOf(totalPrice));
    }

    public void buy(ActionEvent event) throws IOException{
        int result=2;
        double payment;

        try {
            if(Double.parseDouble(priceField.getText())!=0) {
                payment = Double.parseDouble(paidField.getText());
                result = ((SVMachine) VM.getVM()).buyItem(payment);
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Insert Cash!!");
            alert.showAndWait();
        }

        if(result==1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("svBuySuccess.fxml"));
            root = loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }
        else if(result==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Failed to buy item, Not enough money!!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
            root = loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(result==-2){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Failed to buy item, Insufficient change!!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
            root = loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}
