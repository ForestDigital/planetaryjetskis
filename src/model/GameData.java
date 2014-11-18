package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameData {
    public final List<GameComponent> walls; 
    public final List<GameComponent> doors; 
    public final List<GameComponent> floors;
    public Mouse player;
    public Cat cat;
    public Cheese cheese;
    

    public GameData() {
        walls = Collections.synchronizedList(new ArrayList<GameComponent>());
        doors = Collections.synchronizedList(new ArrayList<GameComponent>());
        floors = Collections.synchronizedList(new ArrayList<GameComponent>());
        
        player = new Mouse(580,220);
        cat = new Cat(150,150);
        cheese = new Cheese(36, 220);
    }


    public synchronized void update() {
//        synchronized (walls) {
//            for (GameComponent f : walls) {
//                f.update();
//            }
//        }
//        synchronized (doors) {
//            for (GameComponent b : doors) {                
//                b.update();
//            } 
//        }
    }
}