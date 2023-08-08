/**
 * This class is used to control the main menu of the application
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuGUI{

    private Stage stage;
    private Scene scene;
    private Parent root;
    VMSingleton VM = VMSingleton.getInstance();

    /**
     * This method is used to open the create menu
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void openCreateMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateVMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayTopSellingItem(){
        if(VM.getVM()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Create a Vending machine first!!!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Top Selling Item: " + VM.getVM().getTopSellingItem() + "\nTotal Sales: " + VM.getVM().getTotalSales());
            alert.showAndWait();
        }
    }

    /**
     * This method is used to open the test menu
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void openTestMenu(ActionEvent event) throws IOException {
        if(VM.getVM()==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Create a Vending machine first!!");
            alert.showAndWait();
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * This method is used to open the maintenance menu
     * @param event the event that triggers the method
     * @throws IOException if the scene cannot be set
     */
    public void exitMainMenu(ActionEvent event) throws IOException{
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
