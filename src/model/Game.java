package model;

import customExceptions.EmptyDataException;

public class Game {

    private Player root;

    public Game() {
        this.root = null;
    }

    public void searchPlayer(String nickName) throws EmptyDataException {
        if (nickName.equals("")){
            throw new EmptyDataException();

        }else {


        }
    }

    private void createPlayer(){

    }
}
