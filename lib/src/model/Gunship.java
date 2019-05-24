package model;

public class Gunship extends Starfigther {

    private int antiMissile;
    private int ionCannon;
    private int protonTorpedo;
    private String typeShield;
    private boolean hyperdrive;

    public Gunship(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int antiMissile, int ionCannon, int protonTorpedo, String typeShield, boolean hyperdrive) {
        super(name, staffLimit, model, fuelRatio, healt, turboLaser);
        this.antiMissile = antiMissile;
        this.ionCannon = ionCannon;
        this.protonTorpedo = protonTorpedo;
        this.typeShield = typeShield;
        this.hyperdrive = hyperdrive;
    }

    public int getAntiMissile() {
        return antiMissile;
    }

    public void setAntiMissile(int antiMissile) {
        this.antiMissile = antiMissile;
    }

    public int getIonCannon() {
        return ionCannon;
    }

    public void setIonCannon(int ionCannon) {
        this.ionCannon = ionCannon;
    }

    public int getProtonTorpedo() {
        return protonTorpedo;
    }

    public void setProtonTorpedo(int protonTorpedo) {
        this.protonTorpedo = protonTorpedo;
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
}
