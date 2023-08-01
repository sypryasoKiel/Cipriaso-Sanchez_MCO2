import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
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
    private int slotPicked;
    private Stage stage;
    private Scene scene;
    private Parent root;

    VMSingleton VM = VMSingleton.getInstance();
    private double counter = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void buttonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        paidTextPane.setText("Paid : "+String.format("%.2f",counter));
    }

    public void itemClick(ActionEvent event){
        int choice;
        Button button = (Button) event.getSource();
        String[] items = {"Egg","Flour","Chocolate","Butter","Vanilla Extract","Baking Powder","Milk",
                            "Rainbow Sprinkles","Chocolate Chips","Sugar","Chocolate Cake",
                            "Black Forest Cake","Cornbread Muffin","Vanilla Cupcake","Baguette"};

        String[] itemDesc = {"An ordinary egg, wow","Used for baking and... deep frying?","Dark is the best flavor fight me!","Smooth like butter\nlike a criminal undercover","That one Owl City song","Pinagkaiba nito sa baking soda?"
                ,"Tambay sa ref", "#Pride","Kulang sa cookies fr","Yoko sa maroon 5","mmmmmfgh...",
                "overrated but oks naman basta libre sa bday","I believe in Kenny Rogers Supremacy","Ew? basic..","BAGUETTEEEEEEEEE"};

        choice = Integer.parseInt(button.getText());
        System.out.println("choice : "+choice);
        if(choice!=1) {
            this.slotPicked = choice - 1;
        }
        System.out.println("slotPicked : "+slotPicked);
        itemPane.setText("Selected Item : "+items[slotPicked]);
        itemDescPane.setText("Description : "+itemDesc[slotPicked]);
        pricePane.setText("Price : "+VM.getCurrentVM().getSlotList()[slotPicked].getProduct().getPrice());

    }

    public void buy(ActionEvent event) throws IOException{
        BuySuccess_Controller loading = new BuySuccess_Controller();
        double payment;
        int result;

        payment=Double.parseDouble(paidTextPane.getText().substring(6));
        System.out.println("slotPicked : "+slotPicked);
        result = VM.getCurrentVM().buyItem(payment,slotPicked);

        if(result==1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuySuccess.fxml"));
            root = loader.load();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(result==0){
            System.out.println("oof");
        }
        else if(result==-1){
            System.out.println("oof grabe");
        }
        else if(result==-2){
            System.out.println("wawa ka naman");
        }
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
