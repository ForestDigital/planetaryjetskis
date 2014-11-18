package model;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends Wall {
    
    public Door(int x, int y){
        super(x,y);
    }
    
    @Override
    public void render(Graphics g){ // Made to look like a mouse hole
        g.setColor(Color.blue);
        g.fillRect(x, y, GAME_TILE_SIZE, GAME_TILE_SIZE);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x + 4, y + 4, GAME_TILE_SIZE - 8, GAME_TILE_SIZE - 8, 12, 12);
    }
    
    @Override
    public double getRadius() {
        return (GAME_TILE_SIZE * 0.2);
    }
    
    
}
