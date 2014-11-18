package model;

import java.awt.Graphics;
import java.awt.geom.Point2D;

public abstract class GameComponent {

    public final int GAME_TILE_SIZE = 32;
    Point2D.Double location;
    public int x; // for a faster access
    public int y;

    public GameComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }    
    
    public abstract double getRadius();    // For Collision Radius   

    public abstract void render(Graphics g);

    public abstract void update();
}
