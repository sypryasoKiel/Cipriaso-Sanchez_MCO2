import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class VMGUI_Controller {

    @FXML
    private FlowPane VMPanel;

    @FXML
    private TextField paidTextPane;
    VMSingleton VM = VMSingleton.getInstance();
    private double counter = 0;

    public void addSlots(){
        Button button = new Button();
        button.setPrefWidth(250);
        button.setPrefHeight(250);
    }

    @FXML
    public void buttonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        paidTextPane.setText("Paid : "+counter);
    }

    public void enterClick(ActionEvent event){
        Button button = (Button) event.getSource();
        paidTextPane.setText("Paid : ");
        counter = 0;
    }

}
