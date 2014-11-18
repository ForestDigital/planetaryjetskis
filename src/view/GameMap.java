package view;

import controller.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
//import model.Cat;
import model.Door;
import model.GameComponent;
//import model.Mouse;
import model.Tile;
import model.Wall;

public class GameMap extends JPanel {

    public static final int PWIDTH = 700; // size of the game panel
    public static final int PHEIGHT = 500;
    

    public Rectangle areaSelector = null;

    // off screen rendering
    private Graphics graphics;
    private Image dbImage = null;

    public GameMap() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
    }

    public void gameRender() {        
         dbImage = createImage(PWIDTH, PHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                graphics = dbImage.getGraphics();
            }
        graphics.clearRect(0, 0, GameMap.PWIDTH, GameMap.PHEIGHT);
        
       synchronized (Main.gameData.walls) {
            for (GameComponent w : Main.gameData.walls) {
                w.render(graphics);
            }
       }
            
        synchronized (Main.gameData.doors) {
            for (GameComponent d : Main.gameData.doors) {
                d.render(graphics);
            }            
        }
        
        synchronized (Main.gameData.floors) {
            for (GameComponent f : Main.gameData.floors) {
                f.render(graphics);
            }            
        }
        
       //Player and Cat 
       Main.gameData.player.render(graphics);
       Main.gameData.cat.render(graphics);
       Main.gameData.cheese.render(graphics);
    }
    
    public void createMap(){
        //reads map txt file into a gameMap
        
        Scanner in = null;
        String mapPath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        
        try {
            in = new Scanner(new File(mapPath + separator + "MapsFolder" + separator
                    + "map1.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int increment = 32;
        int width = 20;
        int count = 0;
        int row = 0; // Increment by 1 every (count % width == 0)
        
        while(in.hasNext()){
            int current = in.nextInt();
            
            if (current == 1){ //Wall
                Main.gameData.walls.add(new Wall(count * increment, row * increment));
            }
            else if(current == 2){ //Tile
                Main.gameData.floors.add(new Tile(count * increment, row * increment));
            }
            else if (current == 3){ //Door
                Main.gameData.doors.add(new Door(count * increment, row * increment));
            }            
            
            if( count != 0 && ((count  % (width -1)) == 0)){ //Change Rows
                count = 0;
                row++;
            }
            else
                count++;
        }
    }
    
 //Not Finished yet   
//    public void gameMenu(){
//        int i = 0;
//        if (i == 0)
//        {
//            menuCat = new Cat(200, 200);
//            menuMouse = new Mouse(300, 300);            
//        }
//        i++;
//        
//        int dx = 3;
//        int dy = 3;
//        
//        menuMouse.x += dx;
//        menuMouse.y += dy;
//
//        if (menuMouse.x + menuMouse.getRadius() > GameMap.PWIDTH) {
//            dx = -dx;
//            menuMouse.x = (int)(GameMap.PWIDTH - menuMouse.getRadius());
//        } else if (menuMouse.x - menuMouse.getRadius() < 0) {
//            dx = -dx;
//            menuMouse.x = (int)(menuMouse.getRadius());
//        }
//
//        if (menuMouse.y + menuMouse.getRadius() > GameMap.PHEIGHT) {
//            dy = -dy;
//            menuMouse.y = (int) (GameMap.PHEIGHT - menuMouse.getRadius());
//        } else if (menuMouse.y - menuMouse.getRadius() < 0) {
//            dy = -dy;
//            menuMouse.y = (int) (menuMouse.getRadius());
//        }
//        
//        
//        
//        if (menuCat.x + menuCat.getRadius() > GameMap.PWIDTH) {
//            dx = -dx;
//            menuCat.x = (int)(GameMap.PWIDTH - menuCat.getRadius());
//        } else if (menuCat.x - menuCat.getRadius() < 0) {
//            dx = -dx;
//            menuCat.x = (int)(menuCat.getRadius());
//        }
//
//        if (menuCat.y + menuCat.getRadius() > GameMap.PHEIGHT) {
//            dy = -dy;
//            menuCat.y = (int) (GameMap.PHEIGHT - menuCat.getRadius());
//        } else if (menuCat.y - menuCat.getRadius() < 0) {
//            dy = -dy;
//            menuCat.y = (int) (menuCat.getRadius());
//        }
//
//        menuMouse.render(graphics);
//        menuCat.render(graphics);
//        
//    }

    // use active rendering to put the buffered image on-screen
    public void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }
}
