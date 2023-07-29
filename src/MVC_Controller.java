import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC_Controller implements ActionListener {
    private GUI_Main View1;
    private GUI_CreateVM View2;
    private Factory Model;

    public MVC_Controller(GUI_Main view1,GUI_CreateVM view2, Factory model){
        this.View1 = view1;
        this.View2 = view2;
        this.Model = model;
    }

    public void initController(){
        initView1();
    }

    public void initView1(){
        View1.setVisible(true);
        View1.getButton_1().addActionListener(e -> initView2());
        View1.getButton_3().addActionListener(e -> System.exit(0));
    }

    public void initView2(){
        View2.setVisible(true);
        View2.getChoice_1().addActionListener(this);
        View2.getChoice_2().addActionListener(this);
        View2.getSlots().addChangeListener(e -> setNumSlots());
        View2.getMaxCap().addChangeListener(e -> setMaxCap());
        View2.getSubmit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==View2.getChoice_1()){
            setChoice(1);
            View2.getChoice_1().setEnabled(false);
            View2.getChoice_2().setEnabled(true);
        }
        else if(e.getSource()==View2.getChoice_2()){
            setChoice(2);
            View2.getChoice_2().setEnabled(false);
            View2.getChoice_1().setEnabled(true);
        }
        else if(e.getSource()==View2.getSubmit()){
            View2.dispose();
            createVM();
            initController();
        }
    }

    private void setChoice(int choice){
        Model.setChoice(choice);
    }

    private void setNumSlots(){
        Model.setNumSlot(View2.getSlots().getValue());
    }

    private void setMaxCap(){
        Model.setMaxCap(View2.getMaxCap().getValue());
    }

    private VendingMachine createVM(){
        return Model.createVendingMachine();
    }
}
