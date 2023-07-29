import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class GUI_CreateVM extends JFrame implements ChangeListener {

    JSlider Slots,MaxCap;
    JLabel numSlots,numMaxCap;
    JButton choice_1,choice_2,submit;


    public GUI_CreateVM(){
        setTitle("MCO2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,800));
        getContentPane().setBackground(new Color(60,183,151));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addComponents();
    }

    private void addComponents(){
        JLabel question_1 = new JLabel("1. Select Vending Machine");
        question_1.setFont(new Font("Times New Roman",Font.BOLD,30));
        question_1.setBounds(340,100,400,50);

        choice_1 = new JButton("Regular");
        choice_1.setBounds(370, 180, 100,20);

        choice_2 = new JButton("Special");
        choice_2.setBounds(550, 180, 100,20);

        JLabel question_2 = new JLabel("2. Input number of Slots");
        question_2.setFont(new Font("Times New Roman",Font.BOLD,30));
        question_2.setBounds(350,240,400,50);

        Slots = new JSlider(8,24,16);
        Slots.setBounds(340,320,350,50);
        Slots.setPaintTicks(true);
        Slots.setMinorTickSpacing(4);
        Slots.setPaintTrack(true);
        Slots.setMajorTickSpacing(8);
        Slots.setPaintLabels(true);
        Slots.addChangeListener(this);

        numSlots = new JLabel();
        numSlots.setBounds(445,400,200,20);

        JLabel question_3 = new JLabel("3. Input Max Capacity per Slot");
        question_3.setFont(new Font("Times New Roman",Font.BOLD,30));
        question_3.setBounds(310,445,430,50);

        MaxCap = new JSlider(10,30,20);
        MaxCap.setBounds(340,520,350,50);
        MaxCap.setPaintTicks(true);
        MaxCap.setMinorTickSpacing(5);
        MaxCap.setPaintTrack(true);
        MaxCap.setMajorTickSpacing(10);
        MaxCap.setPaintLabels(true);
        MaxCap.addChangeListener(this);

        numMaxCap = new JLabel();
        numMaxCap.setBounds(450,610,200,20);

        submit = new JButton("Submit");
        submit.setBounds(450,710,100,30);




        this.getContentPane().add(question_1);
        this.getContentPane().add(question_2);
        this.getContentPane().add(question_3);
        this.getContentPane().add(choice_1);
        this.getContentPane().add(choice_2);
        this.getContentPane().add(submit);
        this.getContentPane().add(Slots);
        this.getContentPane().add(numSlots);
        this.getContentPane().add(MaxCap);
        this.getContentPane().add(numMaxCap);

    }

    public void stateChanged(ChangeEvent e){
        numSlots.setText("Number of Slots = "+Slots.getValue());
        numMaxCap.setText("Max Capacity = "+MaxCap.getValue());

    }

    public JSlider getSlots() {
        return Slots;
    }

    public JSlider getMaxCap() {
        return MaxCap;
    }

    public JButton getChoice_1() {
        return choice_1;
    }

    public JButton getChoice_2() {
        return choice_2;
    }

    public JButton getSubmit() {
        return submit;
    }

}
