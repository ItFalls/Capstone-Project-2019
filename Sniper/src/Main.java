	

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.core.PApplet;

public class Main {
	
	public static void main(String args[]) {
		DrawingSurfaceG drawing = new DrawingSurfaceG();
		drawing.init();
		JFrame window = new JFrame();
		window.setSize(DrawingSurfaceG.WIDTH, DrawingSurfaceG.HEIGHT);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(drawing);
		window.requestFocus();
		window.setVisible(true);
	}

}


