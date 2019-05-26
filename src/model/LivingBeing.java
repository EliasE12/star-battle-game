package model;

// Clase

/**
 * Entidad que representa miembro ser vivo de la facción.
 */
public class LivingBeing extends Member {

    // Constantes

    /**
     * Indica las distinta especies de ser vivo que pueden existir en la facción.
     */
    public enum Species {HUMAN,TWILEK,WOOKIE,TOGRUTA,EWOK,GUNGAN,JAWA,HUTT,SITH}

    // Atributos

    /**
     * Es el nombre del ser vivo
     */
    private String name;

    /**
     * Es el dialecto del ser vivo.
     */
    private String dialect;

    /**
     * Es la especie a la que pertenece el ser vivo.
     */
    private Species species;

    // Constructor

    /**
     * Inicializa los valores de los atributos del ser vivo.
     * @param age
     * @param yearsService
     * @param name
     * @param dialect
     * @param species
     */
    public LivingBeing(int age, int yearsService, String name, String dialect, Species species) {
        super(age, yearsService);
        this.name = name;
        this.dialect = dialect;
        this.species = species;
    }

    // Métodos

    /**
     * Devuelve el nombre del ser vivo.
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del ser vivo.
     * @param name - el nombre.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el dialecto del ser vivo.
     * @return dialect.
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * Cambia el dialecto de un ser vivo.
     * @param dialect - el dialecto
     */
    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    /**
     * Devuelve la especie del ser vivo.
     * @return species.
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Cambia la especie del ser vivo.
     * @param species - la especie.
     */
    public void setSpecies(Species species) {
        this.species = species;
    }
}
