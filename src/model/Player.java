package model;

import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;

import java.util.Calendar;
import java.util.Date;

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

        left = null;
        right = null;

        first = null;
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

    /**
     * Crea el historial de la partida acabada de finalizar por el jugador.
     */
    public void createRecord(){
        String date;
        boolean win = match.isWin();
        int score = match.getScore();
        String time = match.manageMatchTime();
        String delayedTime = "";
        Record.Result result;

        if (win){
            result = Record.Result.VICTORIA;
        }else {
            result = Record.Result.DERROTA;
        }

        if (match.getTime() <= 0){
            delayedTime = "00:10:00";

        }else {
            delayedTime = calculateTime();
        }

        Calendar c = Calendar.getInstance();
        String day = Integer.toString(c.get(Calendar.DATE));
        String month = Integer.toString(c.get(Calendar.MONTH));
        String year = Integer.toString(c.get(Calendar.YEAR));

        date = day + "/" + month + "/" + year;

        Record record = new Record(date, score, win, delayedTime, result);
        addRecord(record);
    }

    /**
     * Calcula el tiempo de juego que le ha tomado al jugador ganar o perder la partida, cuando no se le ha acaba el tiempo.
     * @return El tiempo demorado por el jugador en acabar o perder la partida.
     */
    private String calculateTime(){
        String timeCalculated = "";
        String s = "";
        String m = "";

        String[] timeDelayed = match.manageMatchTime().split(":");

        long hourD = Long.parseLong(timeDelayed[0]);
        long minD = Long.parseLong(timeDelayed[1]);
        long segD = Long.parseLong(timeDelayed[2]);

        long hour = (Match.DURATION_MATCH/3600) - (hourD);
        long minute = ((Match.DURATION_MATCH-hour*3600)/60) - (minD);
        long seg = Match.DURATION_MATCH-(hour*3600+minute*60) - (segD);

        if (minute < 10){
            m = "0" + minute;
        }
        if (seg < 10){
            s = "0" + seg;
        }

        timeCalculated = hour + ":" + m + ":" + s;

        return timeCalculated;
    }

    /**
     * Agrega el Historial creado a la lista simple de historiales del jugador.
     * <pre> El historial que recibe como parametro llamado record es != null</>
     */
    private void addRecord(Record record){
        if (first == null){
            first = record;

        }else {
            first.addRecord(record);
        }
    }






}
