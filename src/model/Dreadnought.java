package model;

public class Dreadnought extends Spaceship {

    public static final int AMOUNT_LIFE = 7000;
    public static final int SIZE = 5;

    private boolean massDestruction;
    private int turboLaser;
    private int laserCannon;
    private int ionCannon;

    public Dreadnought(String name, int staffLimit, String model, double fuelRatio, int healt, boolean massDestruction, int turboLaser, int laserCannon, int ionCannon) {
        super(name, staffLimit, model, fuelRatio, healt);
        this.massDestruction = massDestruction;
        this.turboLaser = turboLaser;
        this.laserCannon = laserCannon;
        this.ionCannon = ionCannon;
    }

    public boolean isMassDestruction() {
        return massDestruction;
    }

    public void setMassDestruction(boolean massDestruction) {
        this.massDestruction = massDestruction;
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
}
