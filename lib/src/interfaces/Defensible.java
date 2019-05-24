package interfaces;

public interface Defensible {

	public static final String LIGHTNING_SHIELD = "Raycoat Shield";
	public static final String PARTICLE_SHIELD = "Particle Shield";
	public static final String CONCUSSION_SHIELD = "Concussion Shield";
	public static final double LIGHTNING_RESISTANCE =0.95;
	public static final double PARTICLE_RESISTANCE = 0.82;
	public static final double COUNSSION_RESISTANCE = 0.6;
	
	public double shieldCapacity();
	
}
