
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;


public class Tile extends GameComponent{
    
    public Tile(int x, int y){
        super(x,y);
        location = new Point2D.Double(x + GAME_TILE_SIZE / 2, 
                               y + GAME_TILE_SIZE / 2);        
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, GAME_TILE_SIZE, GAME_TILE_SIZE);
    }

    @Override
    public void update() {
        //Nothing goes here
    }

    @Override
    public double getRadius() {
        return 0;
    }
    
}
