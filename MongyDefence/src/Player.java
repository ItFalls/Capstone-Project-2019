import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private BufferedImage mongy;
	private int xPos;
	private int yPos;
	private int xMovement;
	private int yMovement;
	private boolean flipped;

	public Player(int xPos, int yPos) {
		try {
			mongy = ImageIO.read(new File("assets/mongy.png"));
			this.xPos = xPos;
			this.yPos = yPos;
			flipped = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void move() {
		if (xMovement < 0 && flipped == false) {
			this.flip();
			flipped = true;
		}
		else if (xMovement > 0 && flipped == true) {
			this.flip();
			flipped = false;
		}
		xPos += xMovement;
		yPos += yMovement;
	}

	public void draw(Graphics g) {
		((Graphics2D) g).drawImage(mongy, xPos, yPos, 50, 50, null);
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			xMovement = -5;
		}

		if (key == KeyEvent.VK_RIGHT) {
			xMovement = 5;
		}

		if (key == KeyEvent.VK_UP) {
			yMovement = -5;
		}

		if (key == KeyEvent.VK_DOWN) {
			yMovement = 5;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			xMovement = 0;
		}

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			yMovement = 0;
		}
	}

	private void flip() {
		AffineTransform at = AffineTransform.getScaleInstance(-1, 1);
		at.translate(-mongy.getWidth(null), 0);
		AffineTransformOp ato = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		mongy = ato.filter(mongy, null);
	}
}
