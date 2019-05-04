package model;

public class Interceptor extends Starfigther {

    private int provisions;
    private int turbo;

    public Interceptor(String name, int staffLimit, String model, double volume, double fuelRatio, int healt, int turboLaser, int provisions, int turbo) {
        super(name, staffLimit, model, volume, fuelRatio, healt, turboLaser);
        this.provisions = provisions;
        this.turbo = turbo;
    }

    public int getProvisions() {
        return provisions;
    }

    public void setProvisions(int provisions) {
        this.provisions = provisions;
    }

    public int getTurbo() {
        return turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }
}
