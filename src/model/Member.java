package model;

// Clase

import java.io.Serializable;

/**
 * Entidad que representa un miembro de la facción.
 */
public abstract class Member implements Serializable {

    // Atributos

    /**
     * Es la edad del miembro.
     */
    protected int age;

    /**
     * Son los años de servicio del mien¿mbro a la facción.
     */
    protected int yearsService;

    // Constructor

    /**
     * Inincializa los valores de los atributos de un miembro.
     * @param age -La edad del miembro.
     * @param yearsService - Los años de servicio del miembro.
     */
    public Member(int age, int yearsService) {
        this.age = age;
        this.yearsService = yearsService;
    }

    // Métodos

    /**
     * Devuelve la edad del miembro.
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Cambia la edad del miembro.
     * @param age - la nueva edad del miembro.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *Devuelve los años de servicio del miembro.
     * @return yearsService.
     */
    public int getYearsService() {
        return yearsService;
    }

    /**
     * Cambia los años de servicio del miembro.
     * @param yearsService - loa nuevos años de servicio del miembro.
     */
    public void setYearsService(int yearsService) {
        this.yearsService = yearsService;
    }
}
