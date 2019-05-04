package model;

public class Stress extends Leader{

    public static final int HABILITATION_TIME = 40;

    private boolean fildView;

    public Stress(String name, LevelExperience levelExperience,boolean fildView) {
        super(name, levelExperience);
        this.fildView = fildView;
    }
}
