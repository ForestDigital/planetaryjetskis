package controller;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import view.MainWindow;

public class MouseController implements MouseListener, MouseMotionListener {

    private int px;
    private int py;

    @Override
    public void mousePressed(MouseEvent me) {
      
    }

    @Override
    public void mouseReleased(MouseEvent me) {        
            if (me.getSource() == Main.gamePanel) {
            if(!Main.animator.running){
                Thread t = new Thread(Main.animator);
                t.start();
                Main.gamePanel.createMap();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//                if (me.getSource() == MainWindow.startButton) {
//            if(!Main.animator.running){
//                Thread t = new Thread(Main.animator);
//                t.start();
//                Main.gamePanel.createMap();
//            }
//
//        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
