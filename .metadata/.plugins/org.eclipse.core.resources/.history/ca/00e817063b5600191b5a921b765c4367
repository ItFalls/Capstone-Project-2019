import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurfaceG extends PApplet{
	
	private PImage bg;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	
	private int direction1 = 0;
	private int direction2 = 0;
	private static PImage bullet;
	private static PImage wall;
	public static PImage pistol;
	public static PImage Ak;
	public static PImage sniper;
	public static PImage pistol2;
	public static PImage Ak2;
	public static PImage sniper2;
	private Player p1;
	private Player p2;
	private ArrayList<MovingImage> entities; //This ArrayList stores every single object represented on screen.
	private int timer = 0;
	
	public DrawingSurfaceG(){ //Initializes every field, creating images and objects, adding them to the list.
		wall = loadImage("../assets/brick.png");
		wall.resize(50, 50);
		bg = loadImage("../assets/bg.png");
		bg.resize(WIDTH, HEIGHT);
		PImage p1Img = loadImage("../assets/Player1.png");
		PImage p2Img = loadImage("../assets/Player2.png");
		bullet = loadImage("../assets/Bullet.png");
		entities = new ArrayList<MovingImage>();
		pistol = loadImage("../assets/Pistol.png");
		pistol.resize(50, 20);
		Ak = loadImage("../assets/Ak.png");
		Ak.resize(50, 20);
		sniper = loadImage("../assets/Sniper.png");
		sniper.resize(75, 20);
		pistol2 = loadImage("../assets/Pistol2.png");
		pistol2.resize(50, 20);
		Ak2 = loadImage("../assets/Ak2.png");
		Ak2.resize(50, 20);
		sniper2 = loadImage("../assets/Sniper2.png");
		sniper2.resize(75, 20);
		p1 = new Player(p1Img, 100, 500, 40, 40, "player1");
		p2 = new Player(p2Img, 900, 500, 40, 40, "player2");
		entities.add(p1);
		entities.add(p2);
		
		
	}
	public static PImage getBullet(){
		return bullet;
	}
	
	public void setup(){
		size(WIDTH,HEIGHT);
		this.frameRate(60);
		
		File f = new File("../Map");
		Scanner file = null;
		try {
			file = new Scanner(f);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 20; i++ ){
			for (int j = 0; j < 20; j++) {
				int currentBlock = file.nextInt();
				if (currentBlock == 1) {
					Wall wall = new Wall(this.wall, j*50, i*50, 50, 50);
					entities.add(wall);
				}
			}
		}
		
		
	}
	
	public void draw(){
		background(255,255,255);
		this.image(bg, 0, 0);

		//Under this comment, draw every MovingImage in list. To do that, loop through MovingImage and do list.get(index).draw(this);.
		
		for (MovingImage m : entities) {
			m.draw(this);
		}
		
		textSize(30);
		fill(200);
		
		if (!p1.isDead()  && !p2.isDead()) {
			runGame();
		} else if (p1.isDead()) {
			text("Player 2 Wins!", WIDTH /2 , HEIGHT /2);
		} else if (p2.isDead()) {
			text("Player 1 Wins!", WIDTH /2 , HEIGHT /2);
		}
		
	}
	
	public void runGame(){
		if (timer % 600 == 0) {
			double x = Math.random() * WIDTH;
			double y = Math.random() * HEIGHT;
			PowerUp g = new PowerUp(pistol,(int)x,(int)y,40,40);
			entities.add(g);
		}
		for(int i = 0;i<entities.size();i++){ //This code handles the collision. I recommend that you try understanding the code. Don't worry if you don't.
			MovingImage actor = entities.get(i);
			MovingImage actedUpon = actor.act(entities);
			if (actor instanceof Bullet) {
				if (actedUpon instanceof Player) {
					entities.remove(actor);
					((Player) actedUpon).loseHP(((Bullet) actor).damage);
				}
			}
			if (actor instanceof PowerUp && actedUpon instanceof Player) {
				((Player) actedUpon).weapon = new Sniper();
				entities.remove(actor);
			}
			if (actor == actedUpon) {
				entities.remove(actor);
			}
		}
		timer++;
	}

	public void keyPressed(){
		System.out.println("keyPressed");
		
		if(keyCode == KeyEvent.VK_W) {
			p1.setvY(-7);
			direction1 = 1;
		}else if (keyCode == KeyEvent.VK_A) {
			p1.setvX(-7);
			direction1 = 0;
		}else if (keyCode == KeyEvent.VK_S) {
			p1.setvY(7);
			direction1 = 3;
		}else if (keyCode == KeyEvent.VK_D) {
			p1.setvX(7);
			direction1 = 2;
		}else if (keyCode == KeyEvent.VK_C) {
			Bullet shot = p1.shoot(direction1);
			if (shot != null) {
				entities.add(shot);
			}
		}
		
		if(keyCode == KeyEvent.VK_I) {
			p2.setvY(-7);
			direction2 = 1;
		}else if (keyCode == KeyEvent.VK_J) {
			p2.setvX(-7);
			direction2 = 0;
		}else if (keyCode == KeyEvent.VK_K) {
			p2.setvY(7);
			direction2 = 3;  
		}else if (keyCode == KeyEvent.VK_L) {
			p2.setvX(7);
			direction2 = 2;
		}else if (keyCode == KeyEvent.VK_N) {
			Bullet shot = p2.shoot(direction2);
			if (shot != null) {
				entities.add(shot);
			}
		}

	}
	
	public void keyReleased(){
		//Create four if statements, W/A/S/D, that sets the player (p1)'s velocity x or y to 0.
		if(keyCode == KeyEvent.VK_W) {
			p1.setvY(0);
		}else if (keyCode == KeyEvent.VK_A) {
			p1.setvX(0);
		}else if (keyCode == KeyEvent.VK_S) {
			p1.setvY(0);
		}else if (keyCode == KeyEvent.VK_D) {
			p1.setvX(0);
		}
		
		if(keyCode == KeyEvent.VK_I) {
			p2.setvY(0);
		}else if (keyCode == KeyEvent.VK_J) {
			p2.setvX(0);
		}else if (keyCode == KeyEvent.VK_K) {
			p2.setvY(0);
		}else if (keyCode == KeyEvent.VK_L) {
			p2.setvX(0);
		}
	}
}
