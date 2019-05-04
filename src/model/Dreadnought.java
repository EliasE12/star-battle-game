package model;

public class Dreadnought extends Spaceship {

    public static final int AMOUNT_LIFE = 7000;

    private boolean massDestruction;
    private int turboLaser;
    private int laserCannon;
    private int ionCannon;

    public Dreadnought(String name, int staffLimit, String model, double volume, double fuelRatio, int healt, boolean massDestruction, int turboLaser, int laserCannon, int ionCannon) {
        super(name, staffLimit, model, volume, fuelRatio, healt);
        this.massDestruction = massDestruction;
        this.turboLaser = turboLaser;
        this.laserCannon = laserCannon;
        this.ionCannon = ionCannon;
    }
}
