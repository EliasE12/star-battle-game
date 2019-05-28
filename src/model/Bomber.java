package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un nave de tipo Bomber.
 */
public class Bomber extends Starfigther implements Serializable {

    // Atributos

    /**
     * Es la capacidad de carga de la nave.
     */
    private int loadingCapacity;

    // Constructor.

    /**
     * Inicializa los valores de los atributos de la nave.
     * @param name - Es el nombre de la nave.
     * @param staffLimit - Es el límite de miembros en la nave.
     * @param model - Es el modelo de la nave.
     * @param fuelRatio - Es la relación de combustible.
     * @param healt - Es el nivel de salub de la nave.
     * @param turboLaser - Es el nivel de poder del turbo láser.
     * @param loadingCapacity - Es la capacidad de carga de la nave.
     */
    public Bomber(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int loadingCapacity) {
        super(name, staffLimit, model, fuelRatio, healt, turboLaser);
        this.loadingCapacity = loadingCapacity;
    }

    // Métodos

    /**
     * Devuelve la capacidad de carga de la nave.
     * @return - loadingCapacity.
     */
    public int getLoadingCapacity() {
        return loadingCapacity;
    }

    /**
     * Cambia la capacidad de carga de la nave.
     * @param loadingCapacity - la nueva capacidad de carga de la nave.
     */
    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }
}
