package creature;

import java.awt.Color;
import java.io.Serializable;

import screen.PlayScreen;
import world.Floor;
import world.Thing;
import world.World;

public abstract class Creature extends Thing implements Runnable, Serializable {

	protected int health, power, maxHp, dir;
	protected transient PlayScreen screen;
	protected boolean ispause;
	
	Creature(Color color, char glyph, World world, PlayScreen screen) {
        super(color, glyph, world);
        this.screen = screen;
        dir = 0;
        ispause = false;
    }

    public void moveTo(int xPos, int yPos) {
    	int x = this.getX();
    	int y = this.getY();
        world.put(this, xPos, yPos);
        world.put(new Floor(world), x, y);
    }
	
	public abstract void run();
	
	public int getHealth() {
		return health;
	}
	
	public int getPower() {
		return power;
	}
	
	public void beHit(int damage) {
		health -= damage;
		if(health <= 0) {
			health = 0;
		}
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void setState(boolean s) {
		ispause = s;
	}
	
	public boolean getS() {
		return ispause;
	}
	
	public PlayScreen getScreen() {
		return screen;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setScreen(PlayScreen p) {
		screen = p;
	}

    public void setWorld(World w) {
		world = w;
	}
	
}
