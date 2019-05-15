import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Weapon extends MovingImage implements ActionListener{
	private int damage, speed;
	private double xMovement, yMovement;

	private Timer clock = new Timer(10, this);
	
	
	public Weapon(String imagePath, int damage, int speed, int xPos, int yPos) {
		super(imagePath,damage,speed,xPos,yPos);
		this.damage = damage;
		this.speed = speed;
		xMovement = 0;
		yMovement = 0;
	}

//	public void moveToTarget(int targetX, int targetY) {
//		if (targetX > targetY) {
//			double moveRatio = (double) targetX / (double) targetY;
//			while (true) {
//				xMovement += speed*moveRatio;
//				yMovement += speed;
//				moveByAmount((int)xMovement, (int)yMovement);
//			}
//
//		} else {
//			double moveRatio = (double) targetY / (double) targetX;
//			while (true) {
//				yMovement += speed*moveRatio;
//				xMovement += speed;
//				moveByAmount((int)xMovement, (int)yMovement);
//			}
//		}
//
//	}

	public void shoot(int direction) {
		switch (direction) {
			case 1:
				clock.start();
				this.moveByAmount(0, -10);
				break;
			case 2:
				
				this.moveByAmount(10, 0);
				break;
			case 3:
				
				this.moveByAmount(0, 10);
				break;
			case 4:
				
				this.moveByAmount(-10, 0);
				break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.moveByAmount(0, -7);
		
        if (gex < 0 || x > getWidth() || y < 0 || y > 2 * getHeight() / 3)
        	clock.stop();
		
	}
}