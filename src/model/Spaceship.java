package model;

// Clase

/**
 * Entidad que representa una nave.
 */
public abstract class Spaceship {

	//Relaciones

	/**
	 * Es la nave siguiente de la nave actual.
	 */
	private Spaceship next;

	/**
	 * Es la nave anterior de la nave actual.
	 */
	private Spaceship previus;
	
	//Atributos
	
	/**
	 * Nombre de la nave espacial
	 */
	protected String name;

	/**
	 * Limite de tripulacción de la nave.
	 */
	protected int staffLimit;

	/**
	 * Modelo de la nave.
	 */
	protected String model;

	/**
	 * Volumen que tiene la nave.
	 */
	protected double volume;

	/**
	 * Combustible de la nave.
	 */
	protected double fuelRatio;

	/**
	 * Salud de la nave.
	 */
	protected int healt;
	
	// Constructor

	/**
	 * Inicializa los atributos y relaciones de una nave.
	 * @param name - El nombre de la nave.
	 * @param staffLimit - El límite de miembros de la nave.
	 * @param model - El modelo de la nave.
	 * @param fuelRatio - La relación de combustible de la nave.
	 * @param healt - La salub de la nave.
	 */
	public Spaceship(String name, int staffLimit, String model, double fuelRatio, int healt) {
		this.name = name;
		this.staffLimit = staffLimit;
		this.model = model;
		this.fuelRatio = fuelRatio;
		this.healt = healt;
		this.next = null;
		this.previus = null;
	}


	// Métodos

	/**
	 * Devuelve la siguiente nave.
	 * @return next.
	 */
	public Spaceship getNext() {
		return next;
	}

	/**
	 * Cambia la siguiente nave
	 * @param next - La nueva siguiente nave.
	 */
	public void setNext(Spaceship next) {
		this.next = next;
	}

	/**
	 * Devuelve la anterior nave.
	 * @return previus.
	 */
	public Spaceship getPrevius() {
		return previus;
	}

	/**
	 * Cambia la anave anterior.
	 * @param previus - La nueva nave anterior.
	 */
	public void setPrevius(Spaceship previus) {
		this.previus = previus;
	}

	/**
	 * Devuelve el nombre de la nave.
	 * @return name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Cambia el nombre de la nave.
	 * @param name - El nuevo nombre.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el límite de miembros de la nave.
	 * @return staffLimit.
	 */
	public int getStaffLimit() {
		return staffLimit;
	}

	/**
	 * Cambia en límite de miembros de la nave.
	 * @param staffLimit - El nuevo límite de miembros.
	 */
	public void setStaffLimit(int staffLimit) {
		this.staffLimit = staffLimit;
	}

	/**
	 * Devuelve el modelo de la nave.
	 * @return model.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Cambia el model de la nave.
	 * @param model - El nuevo modelo.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Devuelve la razón de combustible de la nave.
	 * @return fuelRatio.
	 */
	public double getFuelRatio() {
		return fuelRatio;
	}

	/**
	 * Cambia la razón de combustible de la nave
	 * @param fuelRatio - La nueva razón de combustible.
	 */
	public void setFuelRatio(double fuelRatio) {
		this.fuelRatio = fuelRatio;
	}

	/**
	 * Devuelve la salub de la nave.
	 * @return healt.
	 */
	public int getHealt() {
		return healt;
	}

	/**
	 * Cambia la salub de la nave
	 * @param healt - La nueva salub.
	 */
	public void setHealt(int healt) {
		this.healt = healt;
	}
	
	
	
	
	
	
	
	
	
}
