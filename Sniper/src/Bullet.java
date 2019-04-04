import java.util.ArrayList;

import processing.core.PImage;

public class Bullet extends MovingImage{
	
	private String owner;
	int damage;
	int direction;

	public Bullet(PImage img, int x, int y, int w, int h, String owner, int direction, int damage) {
		//Initialize all variables. Make sure you use the super() constructor, passing in the image, x, y, width, and height.
		//The field owner should equal the parameter owner.
		super(img, x, y, w, h);
		this.owner = owner;
		this.damage = damage;
		this.direction = direction;
	}
	
	public MovingImage act(ArrayList<MovingImage> list){
		if (direction == 0) {
			this.moveByAmount(-15, 0  );
		}
		else if (direction == 1) {
			this.moveByAmount(0, -15  );}
		else if (direction == 2) {
			this.moveByAmount(15, 0  );}	
		else if (direction == 3) {
			this.moveByAmount(0, 15  );}
		
		
		if (!this.isInWindow()) {
			return this;
		}
		
		for (MovingImage m : list){ //Collision detection 
			if (this.intersects(m) && (m instanceof Wall)){
				return this;
			}
			if (this!=m && this.intersects(m) && !this.owner.equals(m.toString()) && !(m instanceof Bullet)){
				return m;
			}
		}
		return null; //If all else fails, return null
		
	}

}
