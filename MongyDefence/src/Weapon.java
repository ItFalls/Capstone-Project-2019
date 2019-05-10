public class Weapon extends MovingImage {
	private int damage, speed;
	private double xMovement, yMovement;
	
	public Weapon(String imagePath, int damage, int size, int speed, int xPos, int yPos) {
		super(imagePath, xPos, yPos, 10, 10);
		this.damage = damage;
		this.speed = speed;
		xMovement = 0;
		yMovement = 0;
	}
	
	public void moveToTarget(int targetX, int targetY) {
		if (targetX > targetY) {
			double moveRatio = (double) targetX / (double) targetY;
			while (true) {
				xMovement += speed*moveRatio;
				yMovement += speed;
				moveByAmount((int)xMovement, (int)yMovement);
			}
			
		} else {
			double moveRatio = (double) targetY / (double) targetX;
			while (true) {
				yMovement += speed*moveRatio;
				xMovement += speed;
				moveByAmount((int)xMovement, (int)yMovement);
			}
		}
		
	}
}