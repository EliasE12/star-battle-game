package model;

import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;

// Clase

/**
 * Entidad que representa un jugador.
 */
public class Player {

    // Atributos

    /**
     * Es el nombre del jugador.
     */
    private String name;

    /**
     * Es el apellido del jugador.
     */
    private String lastName;

    /**
     * Es el nombre de usuario del jugador.
     */
    private String userName;

    /**
     * Es el puntaje del jugador.
     */
    private int globalScore;

    /**
     * Es el número de partidos ganadas por jugador.
     */
    private int wonGames;

    /**
     * Es el número de partidas perdidas por el jugador.
     */
    private int lostGames;

    /**
     * Es el jugador derecho del jugador actual.
     */
    private Player right;

    /**
     * Es el jugador izquierdo del jugador actual.
     */
    private Player left;

    /**
     * Es la partida actual.
     */
    private Match match;

    /**
     * Es el primer historial del jugador.
     */
    private Record first;

    // Constructor

    /**
     * Inicializa los atributos y relaciones del jugador.
     * @param name - El nombre del jugador.
     * @param lastName - El apellido del jugador.
     * @param userName El nombre de usuario del jugador.
     * @param globalScore - El puntaje del jugador.
     * @param wonGames - Las partidos ganadas del jugador.
     * @param lostGames - Las partidas perdidas del jugador.
     */
    public Player(String name, String lastName, String userName, int globalScore, int wonGames, int lostGames) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.globalScore = globalScore;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
    }

    // Métodos

    /**
     * Devuelve el jugador derecho del jugador actual.
     * @return right.
     */
    public Player getRight() {
        return right;
    }

    /**
     * Cambia el jugador derecho del jugador actual
     * @return left.
     */
    public Player getLeft() {
        return left;
    }

    /**
     * Devuelve el nombre del jugador
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Devuelve el apellido del jugador
     * @return lastName
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Devuelve el nombre de usuario del jugador.
     * @return userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Devuelve el puntaje del jugador.
     * @return globalScore
     */
    public int getGlobalScore() {
        return globalScore;
    }

    /**
     * Devuelve las partidas ganadas del jugador.
     * @return wonGames
     */
    public int getWonGames() {
        return wonGames;
    }

    /**
     * Devuelve las partidas perdidas del jugador.
     * @return lostGames
     */
    public int getLostGames() {
        return lostGames;
    }

    /**
     * Devuelve la partida.
     * @return match
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Devuelve el primer historial del jugador.
     * @return first
     */
    public Record getFirst() {
        return first;
    }

    /**
     * Cambia la partida del jugador.
     * @param match - la partida.
     */
    public void setMatch(Match match) {
        this.match = match;
    }

    /**
     * Se usa recursividad para agregar a un nuevo jugador al arbol binario, utilizando como criterio su nombre de usaurio
     * @param toAdd jugador el cual se agregará al arbol binario
     * @pre Player != null
     * @throws EqualUserException se lanzará cuando halle un jugador ya agregado, con el mismo nombre de usuario
     */
    public void addPlayer(Player toAdd) throws EqualUserException {

        if(userName.compareTo(toAdd.getUserName()) == 0){
            throw new EqualUserException();

        }else if (toAdd.userName.compareTo(this.userName) < 0){
            if (left == null){
                left = toAdd;
            }else {
                left.addPlayer(toAdd);
            }

        }else if (toAdd.userName.compareTo(this.userName) > 0){
            if (right == null){
                right = toAdd;
            }else {
                right.addPlayer(toAdd);
            }
        }
    }
    
    /**
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param userName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NotExistPlayerException se lanzá cuando no encuentra a un jugador.
     */
    public Player search (String userName) throws NotExistPlayerException{
        Player found = null;
    	
    	if(userName.compareTo(this.userName) == 0) {
    		found = this;
    	}else if(userName.compareTo(this.userName) < 0) {
    	    if (left != null){
                found = left.search(userName);
            }
      	}else {
    	    if (right != null){
                found = right.search(this.userName);
            }
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
     * @param userName - Es el nombre de usuario del jugador a eliminar.
     * @return el jugador que se ha eliminado. En otro caso devuelve null.
     */
    public Player delete(String userName) {

        if (isLeaf()){
            return null;
        }

        if (this.userName.compareTo(userName)==0){
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

        }else if(this.userName.compareTo(userName)>0){
            if (left != null){
                left = left.delete(userName);
            }

        }else {
            if (right != null){
                right = right.delete(userName);
            }
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
