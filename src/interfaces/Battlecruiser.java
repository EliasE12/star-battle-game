package interfaces;

import model.Spaceship;

public class Battlecruiser extends Spaceship{
		
	public enum Rank{NOVA_CLASS,CENTURION_CLASS,MEDIATOR_CLASS,PRAETOR_CLASS};
	public final static int AMOUNT_LIFE = 5000;
	
	private Rank rank;
	private int turboLaser;
	private int laserCannon;
	private int ionCannon;
	private String typeShield;
	private boolean hyperdrive;
	private boolean  IANavigationSystem;
	
	public Battlecruiser(String name, int staffLimit, String model, double volume, double fuelRatio, int healt,
			int turboLaser, int laserCannon, int ionCannon, String typeShield, boolean hyperdrive,
			boolean iANavigationSystem) {
		super(name, staffLimit, model, volume, fuelRatio, healt);
		this.turboLaser = turboLaser;
		this.laserCannon = laserCannon;
		this.ionCannon = ionCannon;
		this.typeShield = typeShield;
		this.hyperdrive = hyperdrive;
		IANavigationSystem = iANavigationSystem;
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

	public int getIonCannon() {
		return ionCannon;
	}

	public void setIonCannon(int ionCannon) {
		this.ionCannon = ionCannon;
	}

	public String getTypeShield() {
		return typeShield;
	}

	public void setTypeShield(String typeShield) {
		this.typeShield = typeShield;
	}

	public boolean isHyperdrive() {
		return hyperdrive;
	}

	public void setHyperdrive(boolean hyperdrive) {
		this.hyperdrive = hyperdrive;
	}

	public boolean isIANavigationSystem() {
		return IANavigationSystem;
	}

	public void setIANavigationSystem(boolean iANavigationSystem) {
		IANavigationSystem = iANavigationSystem;
	}




	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}

	
	
}
