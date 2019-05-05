import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Banana{
	
	private String owner;
	int damage;
	int direction;
	private BufferedImage banana;
	private int xPos;
	private int yPos;

	public Banana(int xPos, int yPos) {
		try {
			banana = ImageIO.read(new File("assets/banana.png"));
			this.xPos = xPos;
			this.yPos = yPos;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
