import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class VMGUI_Controller implements Initializable {

    @FXML
    private GridPane VMPanel;
    @FXML
    private TextField paidTextPane;
    @FXML
    private TextField itemPane;
    @FXML
    private TextArea itemDescPane;
    @FXML
    private TextField pricePane;
    @FXML
    private TextField caloriesPane;
    @FXML
    private Button customButton;
    private int slotPicked;
    private Stage stage;
    private Scene scene;
    private Parent root;

    VMSingleton VM = VMSingleton.getInstance();
    private double counter = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!VM.getVM().getClass().toString().equals("class SVMachine")){
            customButton.setVisible(false);
            customButton.setDisable(true);
        }
    }

    @FXML
    public void buttonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        paidTextPane.setText(String.valueOf(String.format("%.2f",counter)));
    }

    public void itemClick(ActionEvent event){
        int choice;
        Button button = (Button) event.getSource();
        String[] items = {"Egg","Flour","Chocolate","Butter","Vanilla Extract","Baking Powder","Milk",
                            "Rainbow Sprinkles","Chocolate Chips","Sugar","Chocolate Cake",
                            "Black Forest Cake","Cornbread Muffin","Vanilla Cupcake","Baguette"};

        String[] itemDesc = {"An ordinary egg, for breakfast and binding agent","Used for baking and deep frying","Milk Chocolate, from Belgium","Fresh Butter\nfrom local farmers","Typically used for deserts","Helps in making good bread"
                ,"Fresh Milk\ngathered by local farmers", "Assorted sprinkles for cakes","For chocolate chip cookies","Natural sweetener","Freshly baked chocolate cake",
                "A work of art","Muffins sourced from a\nchain restaurant","A very basic cupcake","Long narrow French Bread"};

        choice = Integer.parseInt(button.getText());
        if(choice!=1) {
            this.slotPicked = choice - 1;
        }

        itemPane.setText("Selected Item : "+items[slotPicked]);
        caloriesPane.setText("Calories : "+VM.getVM().getSlotList()[slotPicked].getProduct().getCalories()+" kcal");
        itemDescPane.setText("Description : "+itemDesc[slotPicked]);
        pricePane.setText(String.valueOf(VM.getVM().getSlotList()[slotPicked].getProduct().getPrice()));

    }

    public void buy(ActionEvent event) throws IOException{
        double payment;
        int result=2;

        try {
            if (pricePane.getText().length() != 0) {
                payment = Double.parseDouble(paidTextPane.getText());
                System.out.println("slotPicked : " + slotPicked);
                result = VM.getVM().buyItem(payment, slotPicked);
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Insert Cash!!");
            alert.showAndWait();
        }

        if(result==1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuySuccess.fxml"));
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
        else if(result==-1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Failed to buy item, Item Unavailable");
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

    public void custom(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomItemsVMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
