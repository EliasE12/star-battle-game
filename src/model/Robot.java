package model;

// Class
public class Robot extends Member {

    // Constants
    public enum Funtion {COMBAT,ASTRONOMECHANICAL,DOCTOR,PROTOCOL}

    // Atributes
    private String model;
    private Funtion funtion;

    // Constructor
    public Robot(int age, int yearsService, String model, Funtion funtion) {
        super(age, yearsService);
        this.model = model;
        this.funtion = funtion;
    }

    // Methods
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Funtion getFuntion() {
        return funtion;
    }

    public void setFuntion(Funtion funtion) {
        this.funtion = funtion;
    }
}
