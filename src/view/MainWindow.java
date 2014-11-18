package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import java.awt.Color;
import controller.MouseController;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

    public static JLabel startButton;

    public MainWindow(){

        Container c = getContentPane();

        c.add(Main.gamePanel, "Center");
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        
        
        Font font;        
        font = new Font("Fipps", Font.BOLD, 42);
        
        startButton = new JLabel("START");
        startButton.setForeground(Color.yellow);
        startButton.setFont(font);
        
        Main.gamePanel.add(startButton);

        ButtonListener buttonListener = new ButtonListener();

        MouseController mouseController = new MouseController();

        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        startButton.addKeyListener(keyListener);
        startButton.setFocusable(true);
    }

}
