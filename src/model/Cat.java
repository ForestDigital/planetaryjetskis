package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;


public class Cat extends Mouse {
    private final Image catImage;
    
    public Cat(int x, int y){
        super(x,y);
        location = new Point2D.Double(x,y);
        
        String imagePath = System.getProperty("user.dir");
        // separator: Windows '\', Linux '/'
        String separator = System.getProperty("file.separator");        
        catImage = getImage(imagePath + separator + "ImagesFolder" + separator
                + "CatModel.gif");        
    }
    
    @Override    
    public void render(Graphics g) {        
                g.drawImage(catImage,(int) location.x,(int) location.y, 30, 30, null);
    }
    
}
