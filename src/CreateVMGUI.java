import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateVMGUI implements Initializable {

    @FXML
    ChoiceBox<String> vmType;
    @FXML
    Slider maxCap;
    @FXML
    Label maxText;
    String[] types = {"Regular","Special"};
    private Stage stage;
    private Scene scene;
    private Parent root;
    VMSingleton VM = VMSingleton.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        vmType.getItems().addAll(types);
        vmType.setOnAction(this::getData);
        maxCap.valueProperty().addListener((observableValue, number, t1) -> {
            maxText.setText("Capacity = "+Double.toString((int) maxCap.getValue()));
        });
    }

    public void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuGUI.fxml"));
        root = loader.load();
        MainMenuGUI mainMenu = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getData(ActionEvent e){
        String choice = vmType.getValue();
        return choice;
    }

    public void enter(ActionEvent event) throws IOException{
        try {
            Factory createVM = new Factory();
            String choice = vmType.getValue();
            int maxcap = (int) maxCap.getValue();
            System.out.println("choice : "+choice);
            createVM.createVendingMachine(choice, maxcap);
            VM.getCurrentVM();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuGUI.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vending Machine");
            alert.setHeaderText(null);
            alert.setContentText("Select Vending machine type!!");
            alert.showAndWait();
        }
    }
}
