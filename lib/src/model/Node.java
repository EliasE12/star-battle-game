package model;

import model.LivingBeing.Species;
import model.Robot.Funtion;

// Class
public class Node {

    // Constants
    public final static String MEMBER_LIVINGBEING = "LivingBeing";
    public final static String MEMBER_ROBOT = "Bobot";

    // Atributes
    private Node left;
    private Node right;

    // Relaction
    protected Member member;

    // Constructor
    public Node(){
        left = null;
        right = null;
        member = null;
    }

    // Methods
    public void addMember(String typeMember, int age, int yearsService, String name, String dialect, Species species, String model, Funtion funtion) { }

    private void addLivingBeing(int age, int yearsService, String name, String dialect, Species species){}
    private void addRobot(int age, int yearsService, String model, Funtion funtion){}


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
