package model;

public abstract class Spaceship {

	//Relaciones
	private Spaceship next;
	private Spaceship previus;
	
	//Atributos
	
	/*
	 * Nombre de la nave espacial
	 */
	protected String name;
	/*
	 * Limite de tripulacción de la nave.
	 */
	protected int staffLimit;
	/*
	 * Modelo de la nave.
	 */
	protected String model;
	/*
	 * Volumen que tiene la nave.
	 */
	protected double volume;
	/*
	 * Combustible de la nave.
	 */
	protected double fuelRatio;	
	/*
	 * Salud de la nave.
	 */
	protected int healt;
	
	
	public Spaceship(String name, int staffLimit, String model, double volume, double fuelRatio, int healt) {
		this.name = name;
		this.staffLimit = staffLimit;
		this.model = model;
		this.volume = volume;
		this.fuelRatio = fuelRatio;
		this.healt = healt;
		this.next = null;
		this.previus = null;
	}


	public Spaceship getNext() {
		return next;
	}


	public void setNext(Spaceship next) {
		this.next = next;
	}


	public Spaceship getPrevius() {
		return previus;
	}


	public void setPrevius(Spaceship previus) {
		this.previus = previus;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStaffLimit() {
		return staffLimit;
	}


	public void setStaffLimit(int staffLimit) {
		this.staffLimit = staffLimit;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getVolume() {
		return volume;
	}


	public void setVolume(double volume) {
		this.volume = volume;
	}


	public double getFuelRatio() {
		return fuelRatio;
	}


	public void setFuelRatio(double fuelRatio) {
		this.fuelRatio = fuelRatio;
	}


	public int getHealt() {
		return healt;
	}


	public void setHealt(int healt) {
		this.healt = healt;
	}
	
	
	
	
	
	
	
	
	
}
