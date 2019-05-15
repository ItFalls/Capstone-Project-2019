public class Poop extends Weapon{
    private int damage, speed;
    private double xMovement, yMovement;

    public Poop(String imagePath, int xPos, int yPos, int width, int height) {
        super(imagePath,xPos,yPos, width, height);
        xMovement = 0;
        yMovement = 0;

    }

}
