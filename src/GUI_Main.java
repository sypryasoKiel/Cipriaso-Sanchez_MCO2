import javax.swing.*;
import java.awt.*;


public class GUI_Main extends JFrame{
    public JPanel main_menu,main_menu_panel;
    public JButton button_1,button_2,button_3;
    public JLayeredPane layeredPane;
    public JTextArea credit;
    public ImageIcon image_1;
    public JLabel vm_image,bg_1,proj_name;

    public GUI_Main(){
        setTitle("MCO2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,800));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addComponents();
    }

    private void addComponents(){
        bg_1 = new JLabel();
        bg_1.setBounds(300,0,700,800);
        bg_1.setBackground(new Color(60,183,151));
        bg_1.setOpaque(true);

        proj_name = new JLabel("MCO2 Vending Machine");
        proj_name.setBounds(450, 100,450,50);
        proj_name.setFont(new Font("Times New Roman", Font.BOLD,40));
        proj_name.setForeground(new Color(0,0,0));

        image_1 = new ImageIcon("vending_machine.png");
        vm_image = new JLabel();
        vm_image.setIcon(image_1);
        vm_image.setBounds(550,300,450,200);

        credit = new JTextArea("Created by :\nJames Cipriaso\nJeck Sanchez");
        credit.setFont(new Font("Times New Roman", Font.BOLD,25));
        credit.setForeground(new Color(0,0,0));
        credit.setBounds(800,655,500,100);
        credit.setOpaque(false);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,1000,800);
        layeredPane.add(proj_name);
        layeredPane.add(credit);
        layeredPane.add(vm_image);
        layeredPane.add(bg_1);

        main_menu = new JPanel();

        main_menu_panel = new JPanel();
        main_menu_panel.setLayout(new GridLayout(3,1,20,50));

        main_menu.setBounds(0,0,300,800);
        main_menu_panel.setBounds(50,200,200,250);

        main_menu.setBackground(new Color(50,146,121));
        main_menu.setOpaque(true);
        main_menu.setLayout(null);
        main_menu_panel.setOpaque(false);

        main_menu.add(main_menu_panel);

        button_1 = new JButton("Create Vending Machine");
        button_2 = new JButton("Test Vending Machine");
        button_3 = new JButton("Exit");

        button_1.setPreferredSize(new Dimension(100,30));
        button_2.setPreferredSize(new Dimension(100,30));
        button_3.setPreferredSize(new Dimension(100,30));

        main_menu_panel.add(button_1);
        main_menu_panel.add(button_2);
        main_menu_panel.add(button_3);

        this.getContentPane().add(main_menu);
        this.getContentPane().add(layeredPane);

    }
    public JButton getButton_1() {
        return button_1;
    }

    public JButton getButton_2() {
        return button_2;
    }

    public JButton getButton_3() {
        return button_3;
    }
}
