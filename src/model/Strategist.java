package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un lider de tipo estratega.
 */
public class Strategist extends Leader implements Serializable {

    // Constantes

    /**
     * Indica el tiempo se activa la habilidad.
     */
    public static final int HABILITATION_TIME = 40;

    /**
     * Indica si tiene acceso al campo de juego del oponente.
     */
    private boolean fildView;

    // Constructor

    /**
     * Inicializa los atributos del estratega.
     * @param name - El nombre del estratega.
     * @param levelExperience - El nivel de experiencia del estratega.
     * @param fildView- Indica si tiene habilitada la habilidad.
     */
    public Strategist(String name, LevelExperience levelExperience, boolean fildView) {
        super(name, levelExperience);
        this.fildView = fildView;
    }
}
