package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un nave de tipo Dreadnougth
 */
public class Dreadnought extends Spaceship implements Serializable {

    // Constantes

    /**
     * Indica la cantidad de vida de la nave.
     */
    public static final int AMOUNT_LIFE = 7000;

    /**
     * Indica el tamaño de la nave.
     */
    public static final int SIZE = 5;

    // Atributos

    /**
     * Indica si tene destrucción masiva o no.
     */
    private boolean massDestruction;

    /**
     * Es el nivel de poder del trubo laser
     */
    private int turboLaser;

    /**
     * Es el nivel de poder del cañon laser
     */
    private int laserCannon;

    /**
     * Es el nivel de poder del cañon de iones.
     */
    private int ionCannon;

    // Constructor

    /**
     * Inicializa los valores de los atributos de la nave.
     * @param name - Es el nombre de la nave.
     * @param staffLimit - Es el límite de miembros en la nave.
     * @param model - Es el modelo de la nave.
     * @param fuelRatio - Es la relación de combustible.
     * @param healt - Es el nivel de salub de la nave.
     * @param massDestruction - Indica si nave tiene destruccuon masiva.
     * @param turboLaser - Es el nivel de poder del turbo láser.
     * @param laserCannon - Es el nivel de poder del cañón láser.
     * @param ionCannon - Es el nivel de poder del cañón de iones.
     */
    public Dreadnought(String name, int staffLimit, String model, double fuelRatio, int healt, boolean massDestruction, int turboLaser, int laserCannon, int ionCannon) {
        super(name, staffLimit, model, fuelRatio, healt);
        this.massDestruction = massDestruction;
        this.turboLaser = turboLaser;
        this.laserCannon = laserCannon;
        this.ionCannon = ionCannon;
    }

    // métodods

    /**
     * Devuelve si la nave tiene destrucción masiva o no.
     * @return massDestruction.
     */
    public boolean isMassDestruction() {
        return massDestruction;
    }

    /**
     * Cambia si la nave tiene destrucción masiva
     * @param massDestruction - si tiene destrucción masiva.
     */
    public void setMassDestruction(boolean massDestruction) {
        this.massDestruction = massDestruction;
    }

    /**
     * DEvuelve el nivel de poder del turbo láser.
     * @return turboLaser.
     */
    public int getTurboLaser() {
        return turboLaser;
    }

    /**
     * Cambia el nivel de poder de turbo láser.
     * @param turboLaser - el nivel de poder de turbo láser.
     */
    public void setTurboLaser(int turboLaser) {
        this.turboLaser = turboLaser;
    }

    /**
     * Devuelve el nivel de poder de cañón láser
     * @return laserCannon
     */
    public int getLaserCannon() {
        return laserCannon;
    }

    /**
     * Cambia el nivel de poder del cañón láser.
     * @param laserCannon - el nivel de poder del cañón láser.
     */
    public void setLaserCannon(int laserCannon) {
        this.laserCannon = laserCannon;
    }

    /**
     * Devuelve el nivel de poder del cañón de iones.
     * @return ionCannon.
     */
    public int getIonCannon() {
        return ionCannon;
    }

    /**
     * Cambia el nivel de poder del cañón de iones.
     * @param ionCannon - el nivel de poder del cañón de iones.
     */
    public void setIonCannon(int ionCannon) {
        this.ionCannon = ionCannon;
    }
}
