package model;

public class Faction {

    private Node root;
    private Spaceship first;

    private String name;
    private int memberN;
    private Leader leader;

    public Faction(String name, int memberN, Leader leader) {
        this.name = name;
        this.memberN = memberN;
        this.leader = leader;
    }
}
