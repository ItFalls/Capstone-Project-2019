public class Coconut extends Weapon{
    private int damage, speed;
    private double xMovement, yMovement;

    public Coconut(String imagePath, int damage, int speed, int xPos, int yPos) {
        super(imagePath,damage,speed,xPos,yPos);
        xMovement = 0;
        yMovement = 0;

    }

}
