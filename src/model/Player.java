package model;

import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

// Clase

/**
 * Entidad que representa un jugador.
 */
public class Player implements Comparable<String>, Serializable {

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

    private int numberRecords;

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
        numberRecords = 0;

        comenzar();
    }

    /**
     *  Es el historial por defecto del jugador.
     */

    private void comenzar(){
        addRecord(new Record("May/12/2019",345,true,"11:33"));
        addRecord(new Record("Jun/23/2019",76,true,"09:51"));
        addRecord(new Record("Ago/09/2019",54,true,"04:13"));
        addRecord(new Record("Sep/22/2019",132,true,"22:54"));
        addRecord(new Record("Dic/25/2019",321,true,"04:11"));

    }


    // Métodos

    /**
     * Devuelve el nombre completo del jugador, compuesto de sunombre y apellido con el que se registro
     * @return
     */
    public String getFullName(){
        return name + " " + lastName;
    }

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
     * Cambia el valor del parametro wonGames.
     * @param wonGames nuevo valor del parameteo wonGames.
     */
    public void setWonGames(int wonGames){
        this.wonGames = wonGames;
    }

    /**
     * Cambia el valor del parametro lostGames.
     * @param lostGames nuevo valor del parametro lostGames.
     */
    public void setLostGames(int lostGames){
        this.lostGames = lostGames;
    }

    /**
     * Cambia el valor del puntaje global.
     * @param globalScore nuevo valor del puntaje global del jugador.
     */
    public void setGlobalScore(int globalScore){
        this.globalScore = globalScore;
    }

    /**
     * Compara el nombre completo del jugador actual y el que se recibe por parámetro.
     * @param fullName - El nombre completo del otro jugador.
     * @return  0 - Si los nombres son iguales.
     *          1 - Si nombre del jugador actual es mayor que el otro.
     *          -1 - Si el nombre del jugador actual es menor que el otro.
     */
    @Override
    public int compareTo(String fullName) {
        int value;

        if (fullName.compareToIgnoreCase(name + " " + lastName) == 0){
            value = 0;
        }else if (fullName.compareToIgnoreCase(name + " " + lastName) < 0){
            value = -1;
        }else {
            value = 1;
        }

        return value;
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
     * @param userN es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NotExistPlayerException se lanzá cuando no encuentra a un jugador.
     */
    public Player search (String userN) throws NotExistPlayerException{
        Player found = null;

        if(userName.compareTo(this.userName) == 0) {
            found = this;

        }else if(userName.compareTo(userN) > 0) {
            if (left != null){
                found = left.search(userName);

            }else {
                throw new NotExistPlayerException();
            }

        }else if (userName.compareTo(userN) < 0){
            if (right != null){
                found = right.search(this.userName);

            }else {
                throw new NotExistPlayerException();
            }
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

        Record record = new Record(date, score, win, delayedTime);
        addRecord(record);
    }

    /**
     * Calcula el tiempo de juego que le ha tomado al jugador ganar o perder la partida, cuando no se le ha acaba el tiempo.
     * @return El tiempo demorado por el jugador en acabar o perder la partida.
     */
    private String calculateTime(){
        long duration = 0;
        String timeCalculated = "";
        String s = "";
        String m = "";

        String[] timeDelayed = match.manageMatchTime().split(":");

        long hourD = Long.parseLong(timeDelayed[0]);
        long minD = Long.parseLong(timeDelayed[1]);
        long segD = Long.parseLong(timeDelayed[2]);

        long hour;
        long minute;
        long seg;

        switch (match.getUser().getLeader().getLevelExperience()){
            case HIGHT:
                duration = Match.DURATION_MATCH_HIGH_LEVEL;
                break;
            case MEDIUM:
                duration = Match.DURATION_MATCH_MEDIUM_LEVEL;
                break;
            case LOW:
                duration = Match.DURATION_MATCH_LOW_LEVEL;
                break;
        }

        hour = (duration/3600) - (hourD);
        minute = ((duration-hour*3600)/60) - (minD);
        seg = duration-(hour*3600+minute*60) - (segD);

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
        numberRecords ++;
    }

    /**
     * Recorre el arbol de jugadores usando el recorrido en preOrden
     * @param list Es la lista en la cual se van a guardar los nodos visitados por el metodo
     */
    public void preOrder(List<Player> list){
        list.add(this);

        if (left != null){
            left.preOrder(list);
        }
        if (right != null){
            right.preOrder(list);
        }
    }

    /**
     * Devuelve la lista de historiales del jugador.
     * @return - La lista.
     */
    public List<Record> recordsToPrint() {
        List<Record> records = new ArrayList<>();

        if (first != null){
            Record current = first;
            while (current != null){
                records.add(current);
                current = current.getNext();
            }
        }

        return records;
    }



    // Bubble

    /**
     * Ordena la lista de historiales del jugador bajo el criterio de fecha.
     */
    public void recordsSortByDate(){

        if (first.getNext() != null){

            for (int i = 0; i < numberRecords; i++){
                Record current = first;
                Record previous = null;
                Record next = first.getNext();

                while(next != null){
                    if (current.getDate().compareTo(next.getDate()) > 0){


                        if (previous != null){
                            Record sig = next.getNext();

                            previous.setNext(next);
                            next.setNext(current);
                            current.setNext(sig);
                        }else {
                            Record sig = next.getNext();

                            first = next;
                            next.setNext(current);
                            current.setNext(sig);
                        }

                        previous = next;
                        next = current.getNext();

                    }else {
                        previous = current;
                        current = next;
                        next = next.getNext();
                    }
                }
            }
        }
    }


    // Insertion

    /**
     * Ordena la lista de historiales del jugador bajo el criterio de puntaje.
     */
    public void recordsSortByScore(){

        if (first.getNext() != null){

            Record p = first;
            Record current = first.getNext();
            Record previous = first;

            while(current != null){
                if (previous.getScore() <= current.getScore()){
                    current = current.getNext();
                    previous = previous.getNext();
                }else {
                    if (first.getScore() > current.getScore()){
                        previous.setNext(current.getNext());
                        current.setNext(first);
                        first = current;
                    }else {
                        p = first;

                        Comparator comparator = new Comparator() {
                            @Override
                            public int compare(Object record1, Object record2) {
                                Record r1 = (Record) record1;
                                Record r2 = (Record) record2;
                                if (r1.getScore() > r2.getScore())
                                 return 1;
                                else if (r1.getScore() < r2.getScore())
                                    return -1;
                                else
                                    return 0;
                            }
                        };

                        while(p.getNext() != null && comparator.compare(p.getNext(),current) == -1){
                            p = p.getNext();
                        }

                        previous.setNext(current.getNext());
                        current.setNext(p.getNext());
                        p.setNext(current);
                    }
                }
                current = previous.getNext();
            }
        }

    }

    // Selection

    /**
     * Ordena la lista de historiales del jugador bajo el criterio de duración de una partida.
     */
    public void recordsSortByTime(){

        if (first.getNext() != null){
            Record n1 = null;
            Record n2 = null;

            if (first == null || first.getNext()== null)
            {
                return;
            }
            for (n1 = first; n1.getNext() != null; n1 = n1.getNext()){
                for (n2 = n1.getNext(); n2 != null; n2 = n2.getNext()) {
                    Record bn2 = before(n2);
                    Record bn1 = before(n1);
                    if (n1.getTime().compareTo(n2.getTime()) > 0){
                        if (n1 == first){
                            if (n1.getNext() == n2){
                                n1.setNext(n2.getNext());
                                n2.setNext(n1);
                                first = n2;
                            }
                            else{
                                Record temp = n2.getNext();
                                n2.setNext(n1.getNext());
                                n1.setNext(temp);
                                bn2.setNext(n1);
                                first = n2;
                            }
                        }else{
                            if (n1.getNext() == n2)
                            {
                                bn1.setNext(n2);
                                Record temp = n2.getNext();
                                n2.setNext(n1);
                                n1.setNext(temp);
                            }
                            else
                            {
                                bn1.setNext(n2);
                                Record temp = n2.getNext();
                                n2.setNext(n1.getNext());
                                n1.setNext(temp);
                                bn2.setNext(n1);
                            }
                        }

                        Record temp = n1;
                        n1 = n2;
                        n2 = temp;

                    }
                }
            }
        }
    }

    /**
     * Cambia el historial del actual.
     * @param s - El historial actual.
     * @return El historial cambiado.
     */
    private Record before( Record s)
    {
        Record prev = null;
        Record current = first;
        while( current != null && current != s )
        {
            prev = current;
            current = current.getNext();
        }
        return current != null ? prev : null;
    }


}
