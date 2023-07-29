import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Maintenance extends JFrame {
    private JTextPane item1;
    private JTextPane item3;
    private JTextPane item5;
    private JTextPane item7;
    private JTextPane item2;
    private JTextPane item4;
    private JTextPane item6;
    private JTextPane item8;
    private final JTextPane[] slotDisplay = {item1, item2, item3, item4, item5, item6, item7, item8};
    private JButton reStock;
    private JButton setPrice;
    private JButton collectP;
    private JButton replenishMoney;
    private JButton printTransSum;
    private final JButton[] maintenanceButtons = {reStock, setPrice, collectP, replenishMoney, printTransSum};
    private JTextPane display;
    private JButton back;
    private JTextPane displayMoney;
    private final Slot[] rvmSlots;
    private final Slot[] svmSlots;
    private int[] money;
    private int total;


    public int getTotal(){
        return total;
    }
    public void setMoney(){
        this.money = money;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int[] getMoney(){
        return money;
    }
    public JTextPane getDisplayMoney(){
        return displayMoney;
    }
    public JTextPane[] slotDisplay(){
        return slotDisplay;
    }

    public Maintenance(Menu sourceFrame, slot[] rvmSlots, slot[] svmSlots, int[] money){
        this.rvmSlots = rvmSlots;
        this.svmSlots = svmSlots;
        this.money = money;
        setContentPane(display);
        setTitle("Maintenance");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
        reStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
        setPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
        collectP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
        replenishMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
        printTransSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                sourceFrame.setVisible(true);
            }
        });
    }

    public void 

    }
