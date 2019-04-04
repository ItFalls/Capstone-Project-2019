import java.util.ArrayList;

import processing.core.PImage;

public class PowerUp extends MovingImage {
	
	public PowerUp(PImage image,int x, int y, int width, int height){
		super(image, x, y, width, height);
	}
	public MovingImage act(ArrayList<MovingImage> list) {
		for (MovingImage m : list) {
			if (this.intersects(m) && m instanceof Wall) {
				return this;
			}if (this.intersects(m) && m instanceof Player) {
				return m;
			}
		}
		return null;
	}
}
