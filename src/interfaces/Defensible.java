package interfaces;

// Interface

/**
 * Entidad que representa que una nave puede defenderse.
 */
public interface Defensible {

	// Constantes

	/**
	 * Es el rayo luminoso.
	 */
	public static final String LIGHTNING_SHIELD = "Raycoat Shield";

	/**
	 * Es el rayo de partículas.
	 */
	public static final String PARTICLE_SHIELD = "Particle Shield";

	/**
	 * ES el rayo de concussión.
	 */
	public static final String CONCUSSION_SHIELD = "Concussion Shield";

	/**
	 * ES la resistencia del rayo luminoso.
	 */
	public static final double LIGHTNING_RESISTANCE =0.95;

	/**
	 * Es la resistencia del rayo de partículas.
	 */
	public static final double PARTICLE_RESISTANCE = 0.82;

	/**
	 * Es la resistencia del rayo de concussión.
	 */
	public static final double COUNSSION_RESISTANCE = 0.6;

	// Métodos

	/**
	 *
	 * @return
	 */
	public double shieldCapacity();
	
}
