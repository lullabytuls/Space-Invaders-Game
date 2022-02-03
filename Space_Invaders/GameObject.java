import java.awt.*;
abstract public class GameObject {
	private double posX;
	private double posY;
	private Rectangle hitbox;
	private String picturePath;
	private double height;
	private double width;
	GameObject(){
		posX = 0;
		posY = 0;
		hitbox = null;
	}
	
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	GameObject(double x, double y, String path){
		this.posX = x;
		this.posY = y;
		hitbox = new Rectangle((int)x, (int)y, 1, 1);
		this.picturePath = path;
		width = 0.07;
		height = 0.07;
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	abstract public void move();
	abstract public void draw();
}