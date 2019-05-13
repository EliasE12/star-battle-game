package model;

public class Strategist extends Leader{

    public static final int HABILITATION_TIME = 40;

    private boolean fildView;

    public Strategist(String name, LevelExperience levelExperience, boolean fildView) {
        super(name, levelExperience);
        this.fildView = fildView;
    }
}
