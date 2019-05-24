package model;

public class Shuttle extends Spaceship{
	
	public final static int AMOUNT_LIFE = 100;
	public final static int SIZE = 1;

	//ATRIBUTOS
	
	private int turboLaser;
	private int laserCannon;
	
	public Shuttle(String name, int staffLimit, String model, double fuelRatio, int healt,int turboLaser, int laserCannon) {
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
