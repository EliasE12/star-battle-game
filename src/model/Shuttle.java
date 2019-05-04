package model;

public class Shuttle extends Spaceship{
	
	public final static int AMOUNT_LIFE = 100;
	//ATRIBUTOS
	
	private int turboLaser;
	private int laserCannon;
	
	public Shuttle(String name, int staffLimit, String model, double volume, double fuelRatio, int healt,int turboLaser, int laserCannon) {
		super(name, staffLimit, model, volume, fuelRatio, healt);
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
