package model;

public class Player {

    private Player right;
    private Player left;

    private String userName;
    private int globalScore;
    private int wonGames;
    private int lostGames;

    public Player(String userName, int globalScore, int wonGames, int lostGames) {
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
}
