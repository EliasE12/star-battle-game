package model;

public class Dominator extends Leader{

    public static final int HABILITATION_TIME = 50;
    public static final double DAMAGE = 0.10;

    private boolean harm;

    public Dominator(String name, LevelExperience levelExperience, boolean harm) {
        super(name, levelExperience);
        this.harm = harm;
    }
}
