/*
 * Authors: Ethan Ling, Kevin Chu
 * Period: 4
 * Date: 4/3/2019
 * Capstone Project
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {
    private static final int DRAWING_WIDTH = 800;
    private static final int DRAWING_HEIGHT = 600;
    private final Font FONT = new Font("ComicSans", Font.PLAIN, 20);
    private JButton bananaButton = new JButton("Banana");
    private JButton coconutButton = new JButton("Coconut");
    private JButton poopButton = new JButton("Poop");
    private boolean wKeyPressed, sKeyPressed, aKeyPressed, dKeyPressed,
            upKeyPressed, leftKeyPressed, downKeyPressed, rightKeyPressed;
    private Player mongy;
    private Weapon banana;
    private Weapon coconut;
    private Weapon poop;


    private Main() {
        this.setFocusable(true);
        addKeyListener(this);
        mongy = new Player(100, 200);

        banana = new Banana("assets/Banana.png", 400, 200, 50, 50);
        coconut = new Coconut("assets/Coconut.png", 500, 200, 50, 50);
        poop = new Poop("assets/Poop.png", 400, 200, 50, 50);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("MongyDefense");

        window.setBounds(300, 100, DRAWING_WIDTH, DRAWING_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main panel = new Main();
        panel.setBackground(Color.PINK);
        Container c = window.getContentPane();
        c.add(panel);

        //Icon
        ImageIcon img = new ImageIcon("assets/Icon.png");
        window.setIconImage(img.getImage());

        window.setVisible(true);

        panel.run();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), 3 * getHeight() / 4 - 10);
        g.setColor(Color.BLACK);
        g.setFont(FONT);
        g.drawString("Power Ups", getWidth() / 2 - 30, 13 * getHeight() / 16);
        g.drawLine(0, 27 * getHeight() / 32, getWidth(), 27 * getHeight() / 32);


        this.add(bananaButton);
        this.add(coconutButton);
        this.add(poopButton);


        mongy.draw(g, this);

        banana.draw(g, this);
        coconut.draw(g, this);
        poop.draw(g, this);

        //bananaButton
        bananaButton.setBounds(50 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        bananaButton.setBackground(Color.WHITE);

        //coconutButton
        coconutButton.setBounds(310 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        coconutButton.setBackground(Color.WHITE);

        //poopButton
        poopButton.setBounds(570 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        poopButton.setBackground(Color.WHITE);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        //Movement
        if (key == KeyEvent.VK_A) {
            aKeyPressed = true;
        }
        if (key == KeyEvent.VK_D) {
            dKeyPressed = true;
        }
        if (key == KeyEvent.VK_W) {
            wKeyPressed = true;
        }
        if (key == KeyEvent.VK_S) {
            sKeyPressed = true;
        }

        //Shooting
        if (key == KeyEvent.VK_UP) {
            upKeyPressed = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            leftKeyPressed = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            downKeyPressed = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        //Movement
        if (key == KeyEvent.VK_A) {
            aKeyPressed = false;
        }
        if (key == KeyEvent.VK_D) {
            dKeyPressed = false;
        }
        if (key == KeyEvent.VK_W) {
            wKeyPressed = false;
        }
        if (key == KeyEvent.VK_S) {
            sKeyPressed = false;
        }

        //Shooting
        if (key == KeyEvent.VK_UP) {
            upKeyPressed = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            leftKeyPressed = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            downKeyPressed = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightKeyPressed = false;
        }

    }



    private void run() {

        // MAKE A CHANGE
        while (true) {
            if (aKeyPressed) {
                mongy.walkX(-1);
            }
            if (dKeyPressed) {
                mongy.walkX(1);
            }
            if (wKeyPressed) {
                mongy.walkY(-1);
            }
            if (sKeyPressed) {
                mongy.walkY(1);
            }


            if (upKeyPressed) {
                mongy.shoot(-1);
            }
            if (leftKeyPressed) {
                mongy.shoot(1);
            }
            if (downKeyPressed) {
                mongy.shoot(-1);
            }
            if (rightKeyPressed) {
                mongy.shoot(1);
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

    private void checkPlayer() {
        int x = mongy.getX() + mongy.getWidth() / 2;
        int y = mongy.getY() + mongy.getHeight() / 2;
        if (x < 0 || x > getWidth() || y < 0 || y > 2 * getHeight() / 3)
            mongy = new Player(360, 200);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}