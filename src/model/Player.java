package model;

import customExceptions.EqualUserException;

public class Player {

    private String name;
    private String userName;
    private int globalScore;
    private int wonGames;
    private int lostGames;

    private Player right;
    private Player left;

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
    
    /**
     * -------
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param nickName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NullPointerException se lanzá cuando no encuentra a un jugador.
     */
    public Player search (String nickName) throws NullPointerException{
    	
    	if(this.name.compareTo(nickName) == 0) {
    		return this;
    	}else if(this.name.compareTo(nickName) < 0) {
    		return (right == null)? null : right.search(nickName);    		
      	}else {
      		return (left == null)? null : left.search(nickName);
    	}
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
