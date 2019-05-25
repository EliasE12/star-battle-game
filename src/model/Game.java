package model;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;
import customExceptions.NotRegisteredUsersException;

public class Game {

    private Player root;
    private int numberPlayers;

    public Game() {
        this.root = null;
    }


    public int getNumberPlayers() {
        return numberPlayers;
    }

    public boolean isEmpty(){
        if(root == null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * -------
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param userName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NullPointerException se lanzá cuando no encuentra a un jugador.
     * @throws EmptyDataException se lanzá cuando no se ingresa un valor vacio.
     */
    public Player searchPlayer(String userName) throws EmptyDataException, NotExistPlayerException, NotRegisteredUsersException {
    	Player found;

        if (userName.equals("")){
            throw new EmptyDataException();

        }else {
            if (root != null){
                found = root.search(userName);
            }else {
                throw new NotRegisteredUsersException();
            }
        }

        /*if (found == null){
            throw new NotExistPlayerException();
        }*/
        return found;
    }

    /**
     * Se usa recursividad para agregar un nuevo jugador al arbol binario de busqueda
     * @param userName es el nombre del nuevo jugador que se desea agregar al arbol binario
     * @param name es el nombre del nuevo jugador que se desea agregar
     * @param lastName es el apellido del nuevo jugador que se desea agregar
     * @throws EqualUserException se lanzará si al recorrer el arbol binario se encuentra otro jugador, ya agregado, con el mismo nombre de usuario
     * @throws EmptyDataException se lanzará si al agregar el nuevo jugador, uno de los parametros recibidos esta vacio
     */
  
    public void addPlayer(String userName, String name, String lastName) throws EqualUserException, EmptyDataException {

        if (userName.equals("") || name.equals("") || lastName.equals("")){
            throw new EmptyDataException();

        }else {
            Player player = new Player(name , lastName, userName, 0, 0, 0);

            if (root == null){
                root = player;
            }else {
                root.addPlayer(player);
            }
            numberPlayers++;
        }
    }



    public void deletePlayer(String userName)throws EmptyDataException, NotRegisteredUsersException {
        if (userName.equals("")){
            throw new EmptyDataException();

        }else {
            if (root != null){
                root = root.delete(userName);

            }else {
                throw new NotRegisteredUsersException();
            }
        }
        numberPlayers--;
    }
    	
}
