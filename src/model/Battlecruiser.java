package model;


// Clase

import java.io.Serializable;

/**
 * Entidad que representa una nave de tipo Battlecruser.
 */
public class Battlecruiser extends Spaceship implements Serializable {

	// Constantes

	/**
	 * Representa los diferentes rangos o jerarquías de la nave.
	 */
	public enum Rank{NOVA_CLASS,CENTURION_CLASS,MEDIATOR_CLASS,PRAETOR_CLASS};

	/**
	 * Es la cantidad de vida de la nace
	 */
	public static final int AMOUNT_LIFE = 5000;

	/**
	 * Representael tamaño de la nave.
	 */
	public static final int SIZE = 4;

	/**
	 * Es el rango de la nave.
	 */
	private Rank rank;

	/**
	 * Es el nivel de poder de turbo laser de la nave.
	 */
	private int turboLaser;

	/**
	 * Es el nivel de poder de cañon de laser de la nave.
	 */
	private int laserCannon;

	/**
	 * Es el nivel de poder de cañon de iones de la nave.
	 */
	private int ionCannon;

	/**
	 * Es el tipo de escudo de la nave.
	 */
	private String typeShield;

	/**
	 * Indica si la nave tiene o no Hyperdrive.
	 */
	private boolean hyperdrive;

	/**
	 * Indica si la nave tiene  o no sistema de navegación con Inteligencia Artificial.
	 */
	private boolean  IANavigationSystem;

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
	 * @param ionCannon - Es el nivel de poder del cañón de iones.
	 * @param typeShield - Es el tipo de escudo.
	 * @param hyperdrive - Indica si tiene Hyperdrive o no.
	 * @param iANavigationSystem - Indica si tiene IA o no.
	 */
	public Battlecruiser(String name, int staffLimit, String model, double fuelRatio, int healt, int turboLaser, int laserCannon, int ionCannon, String typeShield, boolean hyperdrive,boolean iANavigationSystem) {
		super(name, staffLimit, model, fuelRatio, healt);
		this.turboLaser = turboLaser;
		this.laserCannon = laserCannon;
		this.ionCannon = ionCannon;
		this.typeShield = typeShield;
		this.hyperdrive = hyperdrive;
		IANavigationSystem = iANavigationSystem;
	}

	// Métodos

	/**
	 * Devuelve el nivel poder del turbo láser.
	 * @return - turboLaser.
	 */
	public int getTurboLaser() {
		return turboLaser;
	}

	/**
	 * Cambia el nivel de poder del turbo láser.
	 * @param turboLaser - el nuevo poder del turbo láser.
	 */
	public void setTurboLaser(int turboLaser) {
		this.turboLaser = turboLaser;
	}

	/**
	 * Devuelve el nivel de poder del cañón láser.
	 * @return laserCannon
	 */
	public int getLaserCannon() {
		return laserCannon;
	}

	/**
	 * Cambia el nivel de poder del cañón láser.
	 * @param laserCannon - el nuevo poder de cañón láser.
	 */
	public void setLaserCannon(int laserCannon) {
		this.laserCannon = laserCannon;
	}

	/**
	 * Devuelve el nivel de poder del cañón de iones.
	 * @return ionCannon
	 */
	public int getIonCannon() {
		return ionCannon;
	}

	/**
	 * Cambia el nivel de poder del cañón de iones.
	 * @param ionCannon - el nuevo poder de cañón de iones.
	 */
	public void setIonCannon(int ionCannon) {
		this.ionCannon = ionCannon;
	}

	/**
	 * Devuelve el tipo de escudo de la nave.
	 * @return - typeShield.
	 */
	public String getTypeShield() {
		return typeShield;
	}

	/**
	 * Cambia el tipo de escudo de la nave.
	 * @param typeShield - el nuevo tipo de escudo de la nave.
	 */
	public void setTypeShield(String typeShield) {
		this.typeShield = typeShield;
	}

	/**
	 * Indica si tiene Hyperdrive o no.
	 * @return
	 */
	public boolean isHyperdrive() {
		return hyperdrive;
	}

	/**
	 * Cambia si la nave tiene Hyperdrive o no.
	 * @param hyperdrive - el Hyperdrive.
	 */
	public void setHyperdrive(boolean hyperdrive) {
		this.hyperdrive = hyperdrive;
	}

	/**
	 * Indica si tiene Inteligencia Artificial.
	 * @return IANavigationSystem.
	 */
	public boolean isIANavigationSystem() {
		return IANavigationSystem;
	}

	/**
	 * Cambia si tiene Inteligencia Artificial (AI).
	 * @param iANavigationSystem - AI
	 */
	public void setIANavigationSystem(boolean iANavigationSystem) {
		IANavigationSystem = iANavigationSystem;
	}

	/**
	 * Devuele el rango de la nave.
	 * @return - rank.
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Cambia el rango de la nave.
	 * @param rank - el nuevo rango de la nave.
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	
	
}
