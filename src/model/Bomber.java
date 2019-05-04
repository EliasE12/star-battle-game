package model;

public class Bomber extends Starfigther {

    private int loadingCapacity;

    public Bomber(String name, int staffLimit, String model, double volume, double fuelRatio, int healt, int turboLaser, int loadingCapacity) {
        super(name, staffLimit, model, volume, fuelRatio, healt, turboLaser);
        this.loadingCapacity = loadingCapacity;
    }

    public int getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }
}
