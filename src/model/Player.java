package model;

import customExceptions.EqualUserException;

public class Player {

    private Player right;
    private Player left;

    private String name;
    private String userName;
    private int globalScore;
    private int wonGames;
    private int lostGames;

    public Player(String name ,String userName, int globalScore, int wonGames, int lostGames) {
        this.name = name;
        this.userName = userName;
        this.globalScore = globalScore;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
    }

    public Player getRight() {
        return right;
    }

    public Player getLeft() {
        return left;
    }

    public String getName(){
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public int getGlobalScore() {
        return globalScore;
    }

    public int getWonGames() {
        return wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void addPlayer(Player toAdd) throws EqualUserException {
        if(userName.compareTo(toAdd.getUserName()) == 0){
            throw new EqualUserException();

        }else if (userName.compareTo(toAdd.getUserName()) < 0){
            if (left == null){
                left = toAdd;
            }else {
                left.addPlayer(toAdd);
            }

        }else if (userName.compareTo(toAdd.getUserName()) > 0){
            if (right == null){
                right = toAdd;
            }else {
                right.addPlayer(toAdd);
            }
        }
    }
}
