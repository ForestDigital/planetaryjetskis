package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Mouse;

public class KeyController implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        Mouse player = Main.gameData.player;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.translate(-2, 0);
                break;
            case KeyEvent.VK_RIGHT:
                player.translate(2, 0);
                break;
            case KeyEvent.VK_UP:
                player.translate(0, -2);
                break;
            case KeyEvent.VK_DOWN:
                player.translate(0, 2);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
