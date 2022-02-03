import java.awt.*;


public class Enemy extends GameObject {
	Enemy(double x, double y, String path){
		super(x, y, path);
	}
	public void move() {
		this.setPosY(getPosY() - 0.01);
	}
	
	public void draw() {
		StdDraw.picture(getPosX(), getPosY(), getPicturePath(), 0.08, 0.1);
	}
	public int destroy(Enemy a) {
		return 1;
	}
	public void animate() {
		
		draw();
		move();
	}
	
}