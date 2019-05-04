package model;

public abstract class Leader {

    public enum LevelExperience{HIGHT, MEDIUM, LOW};

    protected String name;
    protected LevelExperience levelExperience;

    public Leader(String name, LevelExperience levelExperience) {
        this.name = name;
        this.levelExperience = levelExperience;
    }
}
