package model;

import model.LivingBeing.Species;
import model.Robot.Funtion;

// Clase

/**
 * Entidad que presenta un nodo miembro de la facción
 */
public class Node {

    // Constantes

    /**
     * Indica el tipo de miembro ser vivo.
     */
    public final static String MEMBER_LIVINGBEING = "LivingBeing";

    /**
     * Indica el tipo de miembro robot.
     */
    public final static String MEMBER_ROBOT = "Bobot";

    // Atributos

    /**
     * Es el nodo miembro izquierdo.
     */
    private Node left;

    /**
     * Es el nodo miembro derecho.
     */
    private Node right;

    // Relación

    /**
     * Relacion con la clase miembro.
     */
    protected Member member;

    // Constructor

    /**
     * Inicializa los atributos y relaciones de la clase nodo.
     */
    public Node(){
        left = null;
        right = null;
        member = null;
    }

    // Métodos

    /**
     * Agrega un nuevo miembro de al árbol de miembros.
     * @param typeMember - El tipo de miembro.
     * @param age - La edad del miembro.
     * @param yearsService - Son los años de servicio del miembro.
     * @param name - El nombre del miembro.
     * @param dialect - El dialecto del miembro.
     * @param species - La especie del miembro.
     * @param model - El modelo del miembro
     * @param funtion - Es la función del miembro.
     */
    public void addMember(String typeMember, int age, int yearsService, String name, String dialect, Species species, String model, Funtion funtion) { }

    /**
     * Agrega un nuevo ser vivo al álbol de miembros.
     * @param age - La edad del ser vivo
     * @param yearsService - Los años de servicio del ser vivo.
     * @param name - El nombre del ser vivo.
     * @param dialect - El dialecto del vivo.
     * @param species - La especie del ser vivo.
     */
    private void addLivingBeing(int age, int yearsService, String name, String dialect, Species species){}

    /**
     * Agrega un nuevo robot al árbol de miembros.
     * @param age - La edad del robot
     * @param yearsService - Los años de servicio del robot.
     * @param model - El modelo del robot.
     * @param funtion - la función del robot.
     */
    private void addRobot(int age, int yearsService, String model, Funtion funtion){}

    /**
     * Devuelve le nodo izquierdo del árbol.
     * @return left.
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Cambia el nodo izquierdo del árbol.
     * @param left - El nevo nodo izquierdo.
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Devuelve el nodo derecho del árbol.
     * @return right.
     */
    public Node getRight() {
        return right;
    }

    /**
     * Cambia el nodo derecho del árbol.
     * @param right - El nuevo nodo derecho.
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Devuelve el miembro.
     * @return member.
     */
    public Member getMember() {
        return member;
    }

    /**
     * Cambia el miembro.
     * @param member - El miembro
     */
    public void setMember(Member member) {
        this.member = member;
    }
}
