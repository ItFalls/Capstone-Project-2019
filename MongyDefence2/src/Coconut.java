public class Coconut extends Weapon{
    private int damage, speed;
    private double xMovement, yMovement;

    public Coconut(String imagePath, int xPos, int yPos, int width, int height) {
        super(imagePath,xPos,yPos, width, height);
        xMovement = 0;
        yMovement = 0;

    }

}
