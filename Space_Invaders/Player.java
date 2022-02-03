import java.awt.*;
public class Player extends GameObject {
	boolean exploding;
	int destroyed;

    Player(double posX, double posY, String path ) {
        super(posX, posY, path);
    }


    public void draw() {
        StdDraw.picture(super.getPosX(), super.getPosY(), super.getPicturePath(), 0.08, 0.1);
        StdDraw.show();
    }
    public void move(){
        super.setPosX(StdDraw.mouseX());
    }
    public Shot shoot() {
    	return new Shot(this);
    	
    }
    
    public int collide (GameObject g) {
        if(super.getPosY()+super.getHeight()/2 > g.getPosY() + g.getHeight()/2) {
            if( g.getPosX() + g.getWidth()/2 > super.getPosX() - super.getWidth()/2 && g.getPosX() - g.getWidth()/2 < super.getPosX() + super.getWidth()/2  )
                return 1;
        }
        return 0;
    }
}