package model;

// Class
public class LivingBeing extends Member {

    // Constants
    public enum Species {HUMAN,TWILEK,WOOKIE,TOGRUTA,EWOK,GUNGAN,JAWA,HUTT,SITH}

    // Atributes
    private String name;
    private String dialect;
    private Species species;

    // Constructor
    public LivingBeing(int age, int yearsService, String name, String dialect, Species species) {
        super(age, yearsService);
        this.name = name;
        this.dialect = dialect;
        this.species = species;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
