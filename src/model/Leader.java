package model;

public class Leader {

    public enum LevelExperience{HIGHT, MEDIUM, LOW};

    private String name;
    private LevelExperience levelExperience;

    public Leader(String name, LevelExperience levelExperience) {
        this.name = name;
        this.levelExperience = levelExperience;
    }
}
