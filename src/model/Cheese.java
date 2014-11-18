/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;


/**
 *
 * @author jay-t
 */
public class Cheese extends Mouse{
    private final Image cheeseImage;
    
    public Cheese(int x, int y){
        super(x,y);
        location = new Point2D.Double(x,y);
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");        
        cheeseImage = getImage(imagePath + separator + "ImagesFolder" + separator
                + "CheeseModel.png"); 
    }


    @Override
    public void render(Graphics g) {
                g.drawImage(cheeseImage,(int) location.x,(int) location.y, 30, 30, null);
    }


    
}
