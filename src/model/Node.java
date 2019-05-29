package model;

import model.LivingBeing.Species;
import model.Robot.Funtion;

import java.io.Serializable;

// Clase

/**
 * Entidad que presenta un nodo miembro de la facción
 */
public class Node implements Serializable {

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
     * Se encarga comenzar el proceso de agregacion de un nuevo nodo al arbol binario de miembros, verificando que la raiz sea null o no.
     * @param toAdd
     */
    public void addNode(Node toAdd){
        if (toAdd.member.yearsService <= member.yearsService){
            if (left == null){
                left = toAdd;
            }else {
                left.addNode(toAdd);
            }

        }else {
            if(right == null){
                right = toAdd;
            }else {
                right.addNode(toAdd);
            }
        }
    }

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
