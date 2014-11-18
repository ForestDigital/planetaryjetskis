package model;

import controller.Main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Mouse extends GameComponent{
    
    private final int MOUSE_SIZE = 10;
    private final Image mouseImage;

    
    public Mouse(int x, int y){
        super(x,y);
        location = new Point2D.Double(x,y);
        
        //get the image
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");
        mouseImage = getImage(imagePath + separator + "ImagesFolder" + separator
                + "MouseModel.gif");
    }

    @Override
    public double getRadius() {
        return  (MOUSE_SIZE * 0.8);
    }
    
    public void translate(int dx, int dy) {
        //Check first where the next step will be
        // If Next step is wall, don't step
        // If Next step is door, let door know
        
        //Flags
        boolean clear = true;
        boolean door = false;
        
        Random rand = new Random();
        
        synchronized (Main.gameData.walls) {
            for (GameComponent w : Main.gameData.walls) {
                Point2D.Double nextLocation = this.location;                
                nextLocation.setLocation(x + dx, y + dy);                
                
                if(collides(nextLocation, w)){
                    clear = false; //Not okay to step
                }            
            }            
        }
        
        synchronized (Main.gameData.doors) {
            for (GameComponent d : Main.gameData.doors){            
                if(collides(location, d)){
                    door = true; //Will enter door
                }            
            }            
        }
        
        if(door){
            int nextDoor = rand.nextInt(Main.gameData.doors.size());
            super.x = Main.gameData.doors.get(nextDoor).x + 30;
            super.y = Main.gameData.doors.get(nextDoor).y + 10;
        }
            
        
        if(clear){ // Only step forward if it's okay to step
        super.x += dx;
        super.y += dy;
        
        location.setLocation(x, y); //Update location        
        }        
    }

    @Override
    public void render(Graphics g) {        
                g.drawImage(mouseImage,(int) location.x + 20,(int) location.y, -30, 30, null);
    }
    
    //Simple Collision check using
    //      D <= r1 + r2
    public boolean collides(Point2D nextLocation, GameComponent w){
        return nextLocation.distance(w.location) <=
                (this.getRadius() + w.getRadius());
    }

    @Override
    public void update() { //Nothing todo here
    }
    
     public static Image getImage(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException ioe) {
            System.out.println("Error: Cannot open image:" + fileName);
            JOptionPane.showMessageDialog(null, "Error: Cannot open image:" + fileName);
        }
        return image;
    }
    
}
