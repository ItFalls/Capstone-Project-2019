
public class Banana extends Weapon{
	private int damage, speed;
	private double xMovement, yMovement;
	
	public Banana(String imagePath, int xPos, int yPos, int width, int height) {
		super(imagePath, xPos, yPos, width, height);
		xMovement = 0;
		yMovement = 0;
	}
}
