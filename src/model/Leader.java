package model;

// Clase

/**
 * Entidad que representa un líder de la facción.
 */
public abstract class Leader {

    // Constante

    /**
     * Indica el nivel de experiencia del líder.
     */
    public enum LevelExperience{HIGHT, MEDIUM, LOW};

    // Atributos

    /**
     * Es el nombre del lider.
     */
    protected String name;

    /**
     * Es el nivel de experiencia del lider.
     */
    protected LevelExperience levelExperience;

    // Constructor

    /**
     * Inicializa los valores de los atributos del líder.
     * @param name - nombre del lider.
     * @param levelExperience - nivel de experiencia del líder.
     */
    public Leader(String name, LevelExperience levelExperience) {
        this.name = name;
        this.levelExperience = levelExperience;
    }

    //Metodos

    /**
     * Devuelve el nivel de experiencia del lider
     * @return El nivel de experiencia del lider
     */
    public LevelExperience getLevelExperience() {
        return levelExperience;
    }
}
