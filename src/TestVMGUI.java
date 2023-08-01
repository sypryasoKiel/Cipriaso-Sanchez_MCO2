import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TestVMGUI {

    @FXML
    private Button back;

    @FXML
    private Button buyButton;

    @FXML
    private Button maintenanceButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    VMSingleton VM;

    /**
     * This method is used to buy a product
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void buy(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is used to maintain the vending machine
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void maintain(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceVMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is used to go back to the main menu
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

