package model;

// Clase

/**
 * Entidad que representa un lider de facción de tipo Dominator.
 */
public class Dominator extends Leader{

    // Constantes

    /**
     * Indica el tiempo de habilitación del daño.
     */
    public static final int HABILITATION_TIME = 50;

    /**
     * Indica el nivel de daño.
     */
    public static final double DAMAGE = 0.10;

    // Atributos

    /**
     * Indica si el lider produce daño o no.
     */
    private boolean harm;

    // Constructor

    /**
     * Inicializa los valores de los atributos de la nave.
     * @param name - Es el nombre del lider.
     * @param levelExperience - Es el nivel de experiencia del lider.
     * @param harm - Indica si produce daño o no.
     */
    public Dominator(String name, LevelExperience levelExperience, boolean harm) {
        super(name, levelExperience);
        this.harm = harm;
    }






}
