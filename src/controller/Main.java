package controller;

import java.io.IOException;
import javax.swing.JFrame;
import model.GameData;
import view.GameMap;
import view.MainWindow;

public class Main {

    public static GameMap gamePanel;
    public static GameData gameData;
    public static GameAnimator animator;
    public static MenuAnimator menuAnimator;

    public static void main(String[] args) throws IOException {

        animator = new GameAnimator();
        gameData = new GameData();
        gamePanel = new GameMap(); 
        
        JFrame game = new MainWindow();
        game.setTitle("CatMouse1");
        game.setSize(645, 440);
        game.setLocation(100, 100);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        
        
//        Thread t = new Thread(Main.menuAnimator);
//        t.start();
//                t.run();
    }
}
