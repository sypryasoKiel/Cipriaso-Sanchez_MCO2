import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VMGUI_Controller implements Initializable{

    @FXML
    private GridPane VMPanel;

    @FXML
    private TextField paidTextPane;
    VMSingleton VM = VMSingleton.getInstance();
    private double counter = 0;

    /**
     * This method is used to initialize the vending machine
     * @param url the url to be used
     * @param resourceBundle the resource bundle to be used
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VMPanel.setGridLinesVisible(true);
        VBox_Controller vfactory = new VBox_Controller();
        VBox[] box = new VBox[15];

        for(int i=0;i<15;i++){
            box[i]=vfactory.frameFactory(VM.getCurrentVM().getSlotList()[i].getProduct().getName(),new Button(String.valueOf(i+1)));
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                VMPanel.add(box[i*5+j],i,j);
            }
        }
    }

    /**
     * This method is used to get the data from the button
     * @param event the event to be used
     */
    @FXML
    public void buttonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        counter += Double.parseDouble(button.getText());
        paidTextPane.setText("Paid : "+counter);
    }

    /**
     * This method is used to get the data from the enter button
     * @param event the event to be used
     */
    public void enterClick(ActionEvent event){
        Button button = (Button) event.getSource();
        paidTextPane.setText("Paid : ");
        counter = 0;
    }



}
