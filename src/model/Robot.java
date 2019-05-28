package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un miembro de tipo robot.
 */
public class Robot extends Member implements Serializable {

    // Constants

    /**
     * Indica las distintas funciones a las que puede dedicar el robot.
     */
    public enum Funtion {COMBAT,ASTRONOMECHANICAL,DOCTOR,PROTOCOL}

    // Atributos

    /**
     * Es el modelo del robot.
     */
    private String model;

    /**
     * Es la función del robot.
     */
    private Funtion funtion;

    // Constructor

    /**
     * Inicializa los atributos del robot.
     * @param age - La edad del robot.
     * @param yearsService - los años de servicio del robot.
     * @param model - El modelo del robot.
     * @param funtion - la función del robot.
     */
    public Robot(int age, int yearsService, String model, Funtion funtion) {
        super(age, yearsService);
        this.model = model;
        this.funtion = funtion;
    }

    // Métodos

    /**
     * Devuelve el modelo del robot.
     * @return model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Cambia el modelo del robot.
     * @param model - El nuevo  modelo del robot.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Devuelve la función del robot.
     * @return funtion.
     */
    public Funtion getFuntion() {
        return funtion;
    }

    /**
     * Cambia la función del robot.
     * @param funtion - La nueva función del robot.
     */
    public void setFuntion(Funtion funtion) {
        this.funtion = funtion;
    }
}
