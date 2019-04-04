import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends MovingImage {

	private int vX;
	private int vY;
	private int hp;
	private boolean dead;
	private String name;
	Weapon weapon;
	private int cooldown;
	private int shp;
	private PImage weaponSprite;
	
	
	public Player(PImage image,int x, int y, int width, int height, String name){
		super(image, x, y, width, height);
		vX = 0;
		vY = 0;
		hp = 20;
		shp = hp;
		dead = false;
		this.name = name;
		weapon = new Pistol();
		weaponSprite = weapon.leftSprite;
	}
		
	public Bullet shoot(int direction){
		//To get the x and the y coordinates of the player, do this.getX() and this.getY().
		if (cooldown == 0) {
			cooldown = weapon.cooldown;
			return weapon.shoot((int)this.getX(), (int)this.getY() + 10, name, direction);
		}else {
			return null;
		}
	}
	
	public void setvX(int x){
		 vX = x;
		//Sets velocity x
	}
	
	public void setvY(int y){
		vY = y;
		//Sets velocity y
	}
	
	public void loseHP(int damage){
		hp = hp - damage;
		if (hp < 0)
			die();
			
		//Subtracts 1 from "hp"
		//If hp is less than 0, call the die() method
	}
	
	private void die(){
		dead = true;
		//Sets the dead boolean to true
	}
	
	public boolean isDead(){
		//Change the below statement to return an accurate value.
		return dead;
	}
	
	public void draw(PApplet marker){
		super.draw(marker);
		marker.fill(0, 255, 0);
		marker.rect((float)this.getX(), (float)(this.getCenterY()+15), (float)(40*hp/20.0), 10f);
		if (hp  <= shp/2) {
			marker.fill(255, 255, 0);	
			marker.rect((float)this.getX(), (float)(this.getCenterY()+15), (float)(40*hp/20.0), 10f);
		}
		if (hp  <= shp/4) {
			marker.fill(255, 0, 0);	
			marker.rect((float)this.getX(), (float)(this.getCenterY()+15), (float)(40*hp/20.0), 10f);
		}
		marker.image(weaponSprite, (float) x, (float) y + 15);
	}
	
	public MovingImage act(ArrayList<MovingImage> list){ //The parameter is the list of *all* Bullets, Players, and Enemies.
		this.moveByAmount(vX, vY);
		if(!isInWindow()){
			this.moveByAmount(-vX, -vY);
		}
		
		if (vX < 0) {
			weaponSprite = weapon.leftSprite;
		}else if (vX > 0){
			weaponSprite = weapon.rightSprite;
		}
		
		for (MovingImage s:list) {
			if(this.intersects(s) && s instanceof Wall){
				this.moveByAmount(-vX, -vY);
			}
		}
		
		for(MovingImage s:list){
			if(this != s && this.intersects(s)){
				return s;
			}
		}
		if (cooldown > 0) {
			cooldown--;
		}
		return null;
	}
	
	public String toString() {
		return name;
	}
	
}
