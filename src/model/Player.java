package model;

import customExceptions.EqualUserException;

public class Player {

    private String name;
    private String lastName;
    private String userName;
    private int globalScore;
    private int wonGames;
    private int lostGames;

    private Player right;
    private Player left;
    private Record first;

    public Player(String name, String lastName, String userName, int globalScore, int wonGames, int lostGames) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.globalScore = globalScore;
        this.wonGames = wonGames;
        this.lostGames = lostGames;

        right = null;
        left = null;
        first = null;
    }

    public Player getRight() {
        return right;
    }

    public Player getLeft() {
        return left;
    }

    public Record getRecord(){
        return first;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
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
    
    /**
     * -------
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param nickName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NullPointerException se lanzá cuando no encuentra a un jugador.
     */
    public Player search (String nickName) {
        Player found = null;
    	
    	if(nickName.compareTo(nickName) == 0) {
    		found = this;
    	}else if(nickName.compareTo(nickName) < 0) {
            found = left.search(nickName);
      	}else {
            found = right.search(nickName);
    	}

    	return found;
    }
    
    
    /**
     * Verifica si el nodo actual de este arbol es un hoja.
     * Es hoja si no tiene nodos hijos.
     * @return Verdadero si es una hoja, si es lo contrario falso.
     */
    public boolean isLeaf() {
    	return (right == null && left == null);
    }



    
}
