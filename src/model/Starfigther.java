package model;

public abstract class Starfigther extends Spaceship {

    public static final int AMOUNT_LIFE = 1000;

    protected int turboLaser;

    public Starfigther(String name, int staffLimit, String model, double volume, double fuelRatio, int healt, int turboLaser) {
        super(name, staffLimit, model, volume, fuelRatio, healt);
        this.turboLaser = turboLaser;
    }
}
