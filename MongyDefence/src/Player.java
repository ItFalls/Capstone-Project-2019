import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        } else if (xMovement > 0 && flipped == true) {
            this.flip();
            flipped = false;
        }
        xPos += xMovement;
        yPos += yMovement;
    }

    public void draw(Graphics g) {

        g.drawImage(mongy, xPos, yPos, 70, 70, null);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        int speed = 8;

        if (key == KeyEvent.VK_A) {
            xMovement = -speed;
        }

        if (key == KeyEvent.VK_D) {
            xMovement = speed;
        }

        if (key == KeyEvent.VK_W) {
            yMovement = -speed;
        }

        if (key == KeyEvent.VK_S) {
            yMovement = speed;
        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
            xMovement = 0;
        }

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
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
