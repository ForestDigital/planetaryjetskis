package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindow;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == MainWindow.startButton) {
            if(!Main.animator.running){
                Thread t = new Thread(Main.animator);
                t.start();
            }
         else {
                System.exit(0);
            }
        }
    }

}
