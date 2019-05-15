public class Banana extends Weapon{
	private int damage, speed;
	private double xMovement, yMovement;
	
	public Banana(String imagePath, int damage, int speed, int xPos, int yPos) {
		super(imagePath,damage,speed,xPos,yPos);
		xMovement = 0;
		yMovement = 0;
		
	}

}
