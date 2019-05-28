package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un lider de la facción de tipo protector.
 */
public class Protector extends Leader implements Serializable {

    // Constantes

    /**
     * Indica el tiempo en que se activa la habilidad.
     */
    public static final int HABILITATION_TIME = 50;

    /**
     * Indica la cantidad de protección que aplica a la facción.
     */
    public static final double PROTECT = 0.25;

    /**
     * Indica si el lider se defiende o no.
     */
    private boolean defend;

    // Constructor

    /**
     * Inicializa los atributos del protector.
     * @param name - El nombre del protector.
     * @param levelExperience - El nivel de experiencia del protector.
     * @param defend - Indica si se está defendiendo o no.
     */
    public Protector(String name, LevelExperience levelExperience, boolean defend) {
        super(name, levelExperience);
        this.defend = defend;
    }
}
