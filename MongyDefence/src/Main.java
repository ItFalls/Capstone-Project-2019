/*
 * Authors: Ethan Ling, Kevin Chu
 * Period: 4
 * Date: 4/3/2019
 * Capstone Project
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Main extends JPanel implements KeyListener {
	public static final int DRAWING_WIDTH = 763;
	public static final int DRAWING_HEIGHT = 403;
	private final Font FONT = new Font("ComicSans", Font.PLAIN, 20);
	private Player mongy;
	private boolean upKeyPressed,downKeyPressed,leftKeyPressed,rightKeyPressed;

	public Main() {
		this.setFocusable(true);
		addKeyListener(this);
		mongy = new Player(360, 200);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.GREEN);

		g.fillRect(0, 0, getWidth(), 3 * getHeight() / 4);

		g.setColor(Color.BLACK);

		g.setFont(FONT);

		g.drawString("Power Ups", getWidth() / 2 - 30, 13 * getHeight() / 16);

		g.drawLine(0, 27 * getHeight() / 32, getWidth(), 27 * getHeight() / 32);
		
		mongy.draw(g,this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			leftKeyPressed = true;
		}

		if (key == KeyEvent.VK_D) {
			rightKeyPressed = true;
		}

		if (key == KeyEvent.VK_W) {
			upKeyPressed = true;
		}

		if (key == KeyEvent.VK_S) {
			downKeyPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			leftKeyPressed = false;
		}

		if (key == KeyEvent.VK_D) {
			rightKeyPressed = false;
		}

		if (key == KeyEvent.VK_W) {
			upKeyPressed = false;
		}

		if (key == KeyEvent.VK_S) {
			downKeyPressed = false;
		}
	}
	
	public void run() {
	  	while(true) {
	  		// MAKE A CHANGE
	  		if (leftKeyPressed) {
	  			mongy.walkX(-1);
	  	  	} 
	  		if (rightKeyPressed) {
	  			mongy.walkX(1);
	  	  	} 
	  		if (upKeyPressed) {
	  			mongy.walkY(-1);
	  	  	} 
	  		if (downKeyPressed) {
	  	  		mongy.walkY(1);
	  	  	}
	  		
	  		mongy.update();
	  		checkPlayer();
	  		// SHOW THE CHANGE
	  		repaint();
	  		
	  		
	  		// WAIT
	  		try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		
	  	}
	}
	
	public void checkPlayer() {
	  	int x = mongy.getX() + mongy.getWidth()/2;
	  	int y = mongy.getY() + mongy.getHeight()/2;
	  	if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
	  		mongy = new Player(360, 200);
	  }

	public static void main(String[] args) {
		JFrame window = new JFrame("MongyDefense");

		window.setBounds(300, 100, 800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Main panel = new Main();
		panel.setBackground(Color.PINK);
		Container c = window.getContentPane();
		c.add(panel);

		window.setVisible(true);
		
		panel.run();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}