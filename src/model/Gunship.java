package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa una nave de tipo Gunship
 */
public class Gunship extends Starfigther implements Serializable {

    // Atributos

    /**
     * Es el nivel de poder del antimisil.
     */
    private int antiMissile;

    /**
     * Es el nivel de poder del cañón de iones.
     */
    private int ionCannon;

    /**
     * Es el nivel de poder del torpedo de protones.
     */
    private int protonTorpedo;

    /**
     * Es el tipo de escudo de la nave.
     */
    private String typeShield;

    /**
     * Indica si la nave tiene Hyperdrive.
     */
    private boolean hyperdrive;

    // Constructor

    /**
     * Inicializa los valores de los atributos de la nave Gunship.
     * @param name - Es el nombre de la nave.
     * @param staffLimit - Es el límite de miembros de la nave.
     * @param model - Es el modelo de la nave.
     * @param fuelRatio - Es la relación de combustible de la nave.
     * @param healt - Es el nivel se salub de la nave.
     * @param turboLaser - Es el nivel de poder del turbo láser.
     * @param antiMissile - Es el nivel de poder del antimisil.
     * @param ionCannon - Es el nivel de poder del cañón de iones.
     * @param protonTorpedo - Es el nivel de poder del torpedo de protones.
     * @param typeShield - Es el tipo de escudo de la nave.
     * @param hyperdrive - Indica si la nave tiene Hyperdrive.
     */
    public Gunship(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int antiMissile, int ionCannon, int protonTorpedo, String typeShield, boolean hyperdrive) {
        super(name, staffLimit, model, fuelRatio, healt, turboLaser);
        this.antiMissile = antiMissile;
        this.ionCannon = ionCannon;
        this.protonTorpedo = protonTorpedo;
        this.typeShield = typeShield;
        this.hyperdrive = hyperdrive;
    }


    // Métodos

    /**
     * Devuelve el nivvel de poder del antimisil.
     * @return antiMissile.
     */
    public int getAntiMissile() {
        return antiMissile;
    }

    /**
     * Cambia el nivel de poder de antimisil.
     * @param antiMissile - El nivel poder del antimisil
     */
    public void setAntiMissile(int antiMissile) {
        this.antiMissile = antiMissile;
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


    /**
     * Devuelve el nivel de poder del torpedo de protones.
     * @return protonTorpedo.
     */
    public int getProtonTorpedo(){
        return protonTorpedo;
    }


    /**
     * Devuelve el nivel de poder del torpedo
     * @param protonTorpedo - el nivel de poder del torpedo
     */
    public void setProtonTorpedo(int protonTorpedo) {
        this.protonTorpedo = protonTorpedo;
    }

    /**
     * Devuelve el tipo de escudo de la nave.
     * @return typeShield..
     */
    public String getTypeShield() {
        return typeShield;
    }

    /**
     * Cambia el tipo de escudo la nave.
     * @param typeShield - El esudo de la nave.
     */
    public void setTypeShield(String typeShield) {
        this.typeShield = typeShield;
    }

    /**
     * Indica si tiene o na Hyperdrive.
     * @return isHyperdrive
     */
    public boolean isHyperdrive() {
        return hyperdrive;
    }

    /**
     * Cambia si tiene o no Hyperdrive
     * @param hyperdrive - el Hyperdrive.
     */
    public void setHyperdrive(boolean hyperdrive) {
        this.hyperdrive = hyperdrive;
    }
}
