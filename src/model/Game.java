package model;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;

public class Game {

    private Player root;

    public Game() {
        this.root = null;
    }

    public Player searchPlayer(String nickName) throws EmptyDataException {
        Player found = null;

        if (nickName.equals("")){
            throw new EmptyDataException();

        }else {


            if (found == null){
                throw new NullPointerException();
            }
        }
        return found;
    }

    public void addPlayer(String nickName, String name) throws EqualUserException {
        Player player = new Player(name ,nickName, 0, 0, 0);

        if (root == null){
            root = player;
        }else {
            root.addPlayer(player);
        }
    }
}
