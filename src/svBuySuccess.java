import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class svBuySuccess implements Initializable {

    @FXML
    private Label loadLabel;
    @FXML
    private Button homeButton;
    @FXML
    private ScrollPane changePane;
    private Stage stage;
    private Scene scene;
    private Parent root;

    int i=0;
    VMSingleton VM = VMSingleton.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeButton.setVisible(false);
        changePane.setVisible(false);
        loadLabel.setText("Prepapring...");
        int j=((SVMachine)VM.getVM()).getItemList().size();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),e ->{
            i++;
            if(i<j)
                loadLabel.setText("Disposing "+((SVMachine)VM.getVM()).getItemList().get(i).getName());
            else if(i==j) {
                loadLabel.setText("Finished!! Here's your change : ");
                homeButton.setDisable(false);
                homeButton.setVisible(true);
                changePane.setVisible(true);

                ColumnConstraints columnConstraints4 = new ColumnConstraints();
                ColumnConstraints columnConstraints5 = new ColumnConstraints();
                columnConstraints4.setPercentWidth(50);
                columnConstraints4.setHgrow(Priority.NEVER);
                columnConstraints5.setPercentWidth(50);
                columnConstraints5.setHgrow(Priority.NEVER);

                GridPane grid = new GridPane();
                grid.getColumnConstraints().addAll(columnConstraints4,columnConstraints5);

                System.out.println("Denom : "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[0].getDenomination());
                System.out.println("Denom : "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[0].getQuantity());

                for(int i = 0; i<VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash().length; i++){
                    for(int k=0;k<2;k++){
                        if(k==0){
                            grid.add(new Label("PHP "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getDenomination()),k,i);
                        }
                        else{
                            grid.add(new Label("x "+VM.getVM().getTransactions().get(VM.getVM().getTransactions().size()-1).getReturnedCash()[i].getQuantity()),k,i);
                        }
                    }
                }

                changePane.setContent(grid);
                changePane.setFitToWidth(true);
                changePane.setFitToHeight(false);
            }
        }));
        timeline.setCycleCount((int) j);
        timeline.play();
    }

    public void home(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TestVMGUI.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
