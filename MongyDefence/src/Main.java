/*
 * Authors: Ethan Ling, Kevin Chu
 * Period: 4
 * Date: 4/3/2019
 * Capstone Project
 */


import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
	private final Font FONT = new Font("ComicSans", Font.PLAIN, 20);
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		
		g.fillRect(0, 0, getWidth(), 5*getHeight()/8);
		
		g.setColor(Color.BLACK);
		
		g.setFont(FONT);
		
		g.drawString("Power Ups", getWidth()/2 - 30, 11*getHeight()/16);
		
		g.drawLine(0, 23*getHeight()/32, getWidth(), 23*getHeight()/32);
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("MongyDefense");
		
		window.setBounds(300,300,800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Main panel = new Main();
		panel.setBackground(Color.PINK);
		Container c = window.getContentPane();
		c.add(panel);
		
		window.setVisible(true);
	}
}