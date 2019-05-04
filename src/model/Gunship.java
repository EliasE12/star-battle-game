package model;

public class Gunship extends Starfigther {

    private int antiMissile;
    private int ionCannon;
    private int protonTorpedo;
    private String typeShield;
    private boolean hyperdrive;

    public Gunship(String name, int staffLimit, String model, double volume, double fuelRatio, int healt, int turboLaser, int antiMissile, int ionCannon, int protonTorpedo, String typeShield, boolean hyperdrive) {
        super(name, staffLimit, model, volume, fuelRatio, healt, turboLaser);
        this.antiMissile = antiMissile;
        this.ionCannon = ionCannon;
        this.protonTorpedo = protonTorpedo;
        this.typeShield = typeShield;
        this.hyperdrive = hyperdrive;
    }
}
