package model;

public class Protector extends Leader{

    public static final int HABILITATION_TIME = 50;
    public static final double PROTECT = 0.25;

    private boolean defend;

    public Protector(String name, LevelExperience levelExperience, boolean defend) {
        super(name, levelExperience);
        this.defend = defend;
    }
}
