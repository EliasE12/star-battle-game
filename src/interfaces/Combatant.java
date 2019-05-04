package interfaces;

public interface Combatant {
	/**
	 * Daño del turbo laser.
	 */
	public final static int TURBO_LASER_DAMAGE = 100;
	
	/**
	 * Daño del cañon laser.
	 */
	public final static int LASER_CANNON_DAMAGE = 250;
	/**
	 * Daño del cañon de iones.
	 */
	public final int ION_CANNON_DAMAGE = 1500;
	/**
	 * Daño del torpedo de proton. 
	 */
	public final int PROTON_TORPEDO_DAMAGE = 700;
	
	public int maximunDamage();
}
