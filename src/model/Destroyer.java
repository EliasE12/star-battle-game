package model;

import model.Spaceship;

import java.io.Serializable;

// Clase

/**
 * Entidad que reprsenta una nave de tipo Destroyer.
 */
public class Destroyer extends Spaceship implements Serializable {

	// Constantes

	/**
	 * Representa la cantidad de vida de la ave.
	 */
	public static final int AMOUNT_LIFE = 2000;

	/**
	 * Indica el tamaño de la nave.
	 */
	public static final int SIZE = 3;

	// Atributos

	/**
	 * Es el nivel de poder del tuebo láser.
	 */
	private int turboLaser;

	/**
	 * Es el nivel de poder del cañón láser.
	 */
	private int laserCannon;

	// Constructor

	/**
	 * Inicializa los valores de los atributos de la nave.
	 * @param name - Es el nombre de la nave.
	 * @param staffLimit - Es el límite de miembros en la nave.
	 * @param model - Es el modelo de la nave.
	 * @param fuelRatio - Es la relación de combustible.
	 * @param healt - Es el nivel de salub de la nave.
	 * @param turboLaser - Es el nivel de poder del turbo láser.
	 * @param laserCannon - Es el nivel de poder del cañón láser.
	 */
	public Destroyer(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int laserCannon) {
		super(name, staffLimit, model, fuelRatio, healt);
		this.laserCannon = laserCannon;
		this.turboLaser = turboLaser;
	}

	// Métodos

	/**
	 * Devuelve el nivel de poder de turbo laser.
	 * @return - turboLaser.
	 */
	public int getTurboLaser() {
		return turboLaser;
	}

	/**
	 * Cambia el nivel de poder del tubo laser.
	 * @param turboLaser - El nuevo poder de turbo laserr.
	 */
	public void setTurboLaser(int turboLaser) {
		this.turboLaser = turboLaser;
	}

	/**
	 * Devuelve el nivel de poder del cañón laser.
	 * @return - laserCannon.
	 */
	public int getLaserCannon() {
		return laserCannon;
	}

	/**
	 * Cambia el nivel de poder del cañón de laser.
	 * @param laserCannon - el nuevo poder del cañón láser.
	 */
	public void setLaserCannon(int laserCannon) {
		this.laserCannon = laserCannon;
	}
	
	
}
