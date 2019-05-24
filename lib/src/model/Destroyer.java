package model;

import model.Spaceship;

public class Destroyer extends Spaceship{
	
	
	public static final int AMOUNT_LIFE = 2000;
	public static final int SIZE = 3;

	private int turboLaser;
	private int laserCannon;

	
	
	public Destroyer(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int laserCannon) {
		super(name, staffLimit, model, fuelRatio, healt);
		this.laserCannon = laserCannon;
		this.turboLaser = turboLaser;
	}

	public int getTurboLaser() {
		return turboLaser;
	}

	public void setTurboLaser(int turboLaser) {
		this.turboLaser = turboLaser;
	}

	public int getLaserCannon() {
		return laserCannon;
	}

	public void setLaserCannon(int laserCannon) {
		this.laserCannon = laserCannon;
	}
	
	
}
