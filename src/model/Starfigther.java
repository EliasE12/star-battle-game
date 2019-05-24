package model;

public abstract class Starfigther extends Spaceship {

    public static final int AMOUNT_LIFE = 1000;
    public static final int SIZE = 2;

    protected int turboLaser;

    public Starfigther(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser) {
        super(name, staffLimit, model, fuelRatio, healt);
        this.turboLaser = turboLaser;
    }

    public int getTurboLaser() {
        return turboLaser;
    }

    public void setTurboLaser(int turboLaser) {
        this.turboLaser = turboLaser;
    }
}
