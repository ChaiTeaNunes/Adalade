package adalade.game;

import java.util.ArrayList;

public class Missile extends Sprite {

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    private boolean[] dir;
    
    public static ArrayList<Missile> missiles = new ArrayList<>();

    public Missile(int x, int y, boolean[] dir) {
        super(x, y);
        this.dir = dir;

        initMissile();
    }
    
    public Missile getLastMissile() {
        return missiles.get(missiles.size() - 1);
    }
    
    private void initMissile() {
        
        if(!dir[0]) {
            loadImage("src/adalade/res/MissileLR.png");
        } else {
            loadImage("src/adalade/res/MissileUD.png");
        }
        getImageDimensions();        
    }

    public void move() {
        initMissile();
        
        if(dir[0]) {
            if(dir[1]) {
                getLastMissile().y += MISSILE_SPEED;
            } else {
                getLastMissile().y -= MISSILE_SPEED;
            }
        } else {
            if(dir[1]) {
                getLastMissile().x -= MISSILE_SPEED;
            } else {
                getLastMissile().x += MISSILE_SPEED;
            }
        }
        
        if (getLastMissile().x > BOARD_WIDTH)
            vis = false;
    }
}