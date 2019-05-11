package model;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;

public class Game {

    private Player root;

    public Game() {
        this.root = null;
    }
    /**
     * -------
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param nickName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NullPointerException se lanzá cuando no encuentra a un jugador.
     * @throws EmptyDataException se lanzá cuando no se ingresa un valor vacio.
     */
    public Player searchPlayer(String nickName) throws EmptyDataException, NullPointerException{
    	Player found = null;

        if (nickName.equals("")){
            throw new EmptyDataException();

        }else {
            found = root.search(nickName);
        }

        if(found == null) {
            throw new NullPointerException();
        }
        return found;
    }

  
    public void addPlayer(String nickName, String name, String lastName) throws EqualUserException, EmptyDataException {

        if (nickName.equals("") || name.equals("") || lastName.equals("")){
            throw new EmptyDataException();

        }else {
            Player player = new Player(name , lastName, nickName, 0, 0, 0);

            if (root == null){
                root = player;
            }else {
                root.addPlayer(player);
            }
        }
    }
    
    	
}
