import java.awt.*;
public class Shot extends GameObject{
    static int counter=0;
    public boolean toRemove;

    double posX, posY, speed = 10;

    public Shot(Player a) {
        this.posX = a.getPosX();
        this.posY = a.getPosY();
    }

    public void draw() {
    	StdDraw.setPenColor(StdDraw.GREEN);
    	StdDraw.filledCircle(posX, posY, 0.005);
        speed = 50;
    }

    public int destroy(Enemy e) {
        if(e.getPosX() == posX && e.getPosY() == posY) {
            toRemove=true;
            counter++;
        }
        return counter;
    }
    public void move(){
        draw();
        posY+=0.01;
    }
    public boolean collide (GameObject g) {									//CHECKS WHETEHER THE SHOT AND THE GAMEOBJECT HAS COLLIDED
        double dist = distance(this.posX, this.posY, g.getPosX(), g.getPosY());
        return dist <= 0.04;
    }
    public double distance(double x1, double y1, double x2, double y2) {
    	return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)); //CALCULATES THE DISTANCE BETWEEN THE SHOT AND THE GAMEOBJECT
    }
    
    

}