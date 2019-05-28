package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa una nave de tipo Shuttle.
 */
public class Shuttle extends Spaceship implements Serializable {

	// Constantes

	/**
	 * Indica la cantidad de vida la nave.
	 */
	public final static int AMOUNT_LIFE = 100;

	/**
	 * Indica el tamaño de la nave.
	 */
	public final static int SIZE = 1;

	//Atributos

	/**
	 * Es el nivel de poder de turbo laser.
	 */
	private int turboLaser;

	/**
	 * Es el nivel de poder de cañon laser.
	 */
	private int laserCannon;

	// Constructor

	/**
	 * Inicializa los atributos de la nave.
	 * @param name - El nombre de la nave.
	 * @param staffLimit - El límite de miembros en la nave.
	 * @param model - El modelo de la nave.
	 * @param fuelRatio - La relación de combustible.
	 * @param healt - La salub de la nave.
	 * @param turboLaser - El nivel de poder del turbo laser.
	 * @param laserCannon - El nivel de poder del cañón láser.
	 */
	public Shuttle(String name, int staffLimit, String model, double fuelRatio, int healt,int turboLaser, int laserCannon) {
		super(name, staffLimit, model, fuelRatio, healt);
		this.laserCannon = laserCannon;
		this.turboLaser = turboLaser;
	}

	// Métodos

	/**
	 * Devuelve el nivel de poder de turbo láser.
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

	/**
	 * Devuelve el nivel de poder del cañón láser.
	 * @return laserCannon.
	 */
	public int getLaserCannon() {
		return laserCannon;
	}

	/**
	 * Cambia el nivel de poder del cañón láser.
	 * @param laserCannon - El nuevo poder de cañón láser.
	 */
	public void setLaserCannon(int laserCannon) {
		this.laserCannon = laserCannon;
	}
		
	

}
