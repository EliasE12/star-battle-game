package model;

import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;

public class Player {

    private String name;
    private String lastName;
    private String userName;
    private int globalScore;
    private int wonGames;
    private int lostGames;

    private Player right;
    private Player left;

    public Player(String name, String lastName, String userName, int globalScore, int wonGames, int lostGames) {
        this.name = name;
        this.lastName = lastName;
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
    public Player search (String nickName) throws NotExistPlayerException{
        Player found = null;
    	
    	if(nickName.compareTo(nickName) == 0) {
    		found = this;
    	}else if(nickName.compareTo(nickName) < 0) {
            found = left.search(nickName);
      	}else {
            found = right.search(nickName);
    	}

    	if (found == null){
    	    throw new NotExistPlayerException();
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

    /**
     * Elimina el jugador con el nombre de usuario asociado.
     * @param nickName - Es el nombre de usuario del jugador a eliminar.
     * @return el jugador que se ha eliminado. En otro caso devuelve null.
     */
    public Player delete(String nickName){

        if (isLeaf()){
            return null;
        }

        if (userName.compareTo(nickName)==0){
            if (left == null){
                return right;
            }
            if (right == null){
                return left;
            }

            Player successor = right.getMinor();
            right = right.delete(successor.getUserName());
            successor.left = left;
            successor.right = right;
            return successor;

        }else if(userName.compareTo(nickName)>0){
            left = left.delete(nickName);
        }else {
            right = right.delete(nickName);
        }

        return this;

    }

    /**
     * Devuelve el menor jugador del arbol.
     * @return - el menor jugador.
     */
    public Player getMinor(){
        return (left == null) ? this : left.getMinor();
    }

    /**
     * Devuelve el mayor jugador del arbol.
     * @return - el mayor jugador.
     */
    public Player getMajor(){
        return (right == null) ? this : right.getMajor();
    }






}
