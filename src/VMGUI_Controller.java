import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;

import java.awt.event.ActionEvent;

public class VMGUI_Controller {

    @FXML
    private FlowPane VMPanel;

    @FXML
    private Button button1;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button enter;

    @FXML
    private TextArea payDisplay;

    @FXML
    public void buttonClick(ActionEvent event){
        double counter = 0;
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        System.out.println("Counter : "+counter);
    }
}
