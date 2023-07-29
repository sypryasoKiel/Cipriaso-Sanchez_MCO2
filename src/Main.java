// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JButton createB;
    private JButton testB;
    private JButton quitB;
    private JPanel buttonsPanel;
    private Factory createVM;

    public Main() {
        createVM = new Factory();

        setContentPane(mainPanel);

        createB.setMargin(new Insets(10, 0, 10, 0));
        testB.setMargin(new Insets(10, 0, 10, 0));
        quitB.setMargin(new Insets(10, 0, 10, 0));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Vending Machine Factory ");
        setSize(720, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        createB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        testB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        quitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }


    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
    }
}