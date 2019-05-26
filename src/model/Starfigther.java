package model;

// Clase

/**
 * Entidad que representa una nave de tipo Starfigther.
 */
public abstract class Starfigther extends Spaceship {

    // Constantes

    /**
     * Indica la cantidad de vida de la nave
     */
    public static final int AMOUNT_LIFE = 1000;

    /**
     * Indica el tamaño de la nave.
     */
    public static final int SIZE = 2;


    // Atributos

    /**
     * Es el nivel de poder del turbo láser.
     */
    protected int turboLaser;

    // Constructor.

    /**
     * Inicializa los atributos de una nave de tipo Starfigther
     * @param name - El nombre de la nave.
     * @param staffLimit - El límite de miembros de la nave.
     * @param model - El modelo de la nave.
     * @param fuelRatio - La relación de combustible de la nave.
     * @param healt - La salub de la nave.
     * @param turboLaser - El nivel de poder de del
     */
    public Starfigther(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser) {
        super(name, staffLimit, model, fuelRatio, healt);
        this.turboLaser = turboLaser;
    }

    // Métodos

    /**
     * Devuelve el nivel de poder del turbo láser.
     * @return turboLaser.
     */
    public int getTurboLaser() {
        return turboLaser;
    }

    /**
     * Cambia el nivel de poder del turbo láser.
     * @param turboLaser - El nuevo poder de turbo láser.
     */
    public void setTurboLaser(int turboLaser) {
        this.turboLaser = turboLaser;
    }
}
