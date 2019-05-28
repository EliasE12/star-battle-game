package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa una nave de tipo Interceptor.
 */
public class Interceptor extends Starfigther implements Serializable {

    // Atributos

    /**
     * Es la cantidad de proviciones de la nave.
     */
    private int provisions;

    /**
     * Es la cantidad de turbo de la nave
     */
    private int turbo;

    // Costructor

    /**
     * Inicializa los valores de los atributos de la nave
     * @param name - Es el nombre de la nave.
     * @param staffLimit - Es el límite de miembros en la nave.
     * @param model - Es el modelo de la nave.
     * @param fuelRatio - Es la relación de combustible.
     * @param healt - Es el nivel de salub de la nave.
     * @param turboLaser - Es el nivel de poder del turbo láser.
     * @param provisions - Es la cantidad de provisiones.
     * @param turbo - Es la cantidad de turbo.
     */
    public Interceptor(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int provisions, int turbo) {
        super(name, staffLimit, model, fuelRatio, healt, turboLaser);
        this.provisions = provisions;
        this.turbo = turbo;
    }

    // Métodos

    /**
     * Devuelve la cantidad de provisones.
     * @return provisions.
     */
    public int getProvisions() {
        return provisions;
    }

    /**
     * Cambia la cantidad de provisiones.
     * @param provisions - las provisiones.
     */
    public void setProvisions(int provisions) {
        this.provisions = provisions;
    }

    /**
     * Devuelve la cantiada de privisiones.
     * @return turbo.
     */
    public int getTurbo() {
        return turbo;
    }

    /**
     * Cambia la cantidad de turbo.
     * @param turbo - la cantidad de turbo.
     */
    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }
}
