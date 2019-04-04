import processing.core.PImage;

public abstract class Weapon {
	
	int damage;
	int cooldown;
	PImage leftSprite;
	PImage rightSprite;
	
	
	public Weapon(PImage leftSprite, PImage rightSprite, int damage, int cooldown) {
		this.damage = damage;
		this.cooldown = cooldown;
		this.leftSprite = leftSprite;
		this.rightSprite = rightSprite;
	}
	
	public abstract Bullet shoot(int x, int y, String owner, int direction);

}
