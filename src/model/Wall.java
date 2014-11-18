
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Wall extends Tile{   
    
    public Wall(int x, int y){
        super(x,y);  
        location = new Point2D.Double(x + GAME_TILE_SIZE/3,y);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, GAME_TILE_SIZE, GAME_TILE_SIZE);
    }

    @Override
    public void update() {
        //Nothing goes here
    }

    @Override
    public double getRadius() {
        return (GAME_TILE_SIZE * 0.5);
    }
    
}
