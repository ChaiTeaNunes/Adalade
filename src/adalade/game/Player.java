package adalade.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Sprite {
    
    public boolean[] last = new boolean[2];
    private int dx;
    private int dy;
    public int hp;
    public int mp;
    
    private ArrayList<Missile> missiles = Missile.missiles;

    public Player(int x, int y) {
        super(x, y);

        player();
    }

    private void player() {
        
        loadImage("src/adalade/res/player.png");
        getImageDimensions();
        mp = 10;
        hp = 10;
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            last[0] = false;
            last[1] = true;
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            last[0] = false;
            last[1] = false;
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            last[0] = true;
            last[1] = false;
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            last[0] = true;
            last[1] = true;
            dy = 1;
        }
    }

    public void fire() {
        if(!(mp <= 0)) {
            missiles.add(new Missile(x + width, y + height / 2, last));
            mp--;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}