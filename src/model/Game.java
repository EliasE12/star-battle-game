package model;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;
import customExceptions.NotExistPlayerException;
import customExceptions.EmptyPlayerStructureException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase

/**
 * Entidad que representa el Juego.
 */
public class Game {

    // Constantes

    public final static String SERIALITATION_PATH = "data/serialitation.dat";

    // Atributos

    /**
     * Es la raíz del árbol de jugadores.
     */
    private Player root;

    /**
     * Es el número de jugadores en el juego.
     */
    private int numberPlayers;

    // Constructor

    /**
     * Inicializa los valores de los atributos del juego.
     */
    public Game() {
        this.root = null;

        comenzar();
    }

    private void comenzar(){
        root = new Player("Luis_1", "Felipe", "p1", 500, 15, 5);

        Player p2 = new Player("Pepito_2", "Gomez", "p2", 600, 13, 2);
        Player p3 = new Player("Pepita_3", "Perez", "p3", 150, 5, 7);
        Player p4 = new Player("Pep_4", "Andrade", "p4", 300, 8, 3);
        Player p5 = new Player("Alvaro", "nose", "a1", 255, 8, 9);
        Player p6 = new Player("Alfonso", "reyes", "a2", 420, 5, 8);
        Player p7 = new Player("Bella", "Gomez", "c1", 750, 8, 2);
        Player p8 = new Player("Helias", "Caleb", "c2", 625, 9,2);
        Player p9 = new Player("Oscar", "Riascos", "c3", 520, 8, 7);
        Player p10 = new Player("Name", "Nose", "b3", 800, 15, 6);


        try {
            root.addPlayer(p2);
            root.addPlayer(p4);
            root.addPlayer(p7);
            root.addPlayer(p8);
            root.addPlayer(p5);
            root.addPlayer(p3);
            root.addPlayer(p9);
            root.addPlayer(p6);
            root.addPlayer(p10);
        } catch (EqualUserException e) {
            e.printStackTrace();
        }


    }

    // Métodos

    /**
     * Devuelve la raiz del arbol de jugadores.
     * @return La raiz del arbol de jugadores
     */
    public Player getRoot() {
        return root;
    }

    /**
     *Cambia la raiz del arbol de jugadores.
     * @param root La nueva raiz, la cual se va a sustituir la raiz del arbol binario de jugadores
     */
    public void setRoot(Player root) {
        this.root = root;
    }

    /**
     * Devuelve el número de jugadores en el juwgo.
     * @return numberPlayers.
     */
    public int getNumberPlayers() {
        return numberPlayers;
    }

    /**
     * Verifica si el árbol de jugadores está vacío.
     * @return true si el árbol está vacío.
     *         false si el árbol no está vacío.
     */
    public boolean isEmpty(){
        if(root == null){
            return true;
        }else {
            return false;
        }
    }

    /**
     *  Se usa recursiva para localizar un jugador en el arbol que inicia en este nodo.
     * @param userName es el nombre de usuario que se desea buscar. - nameSearch != null
     * @return jugador con el mismo nombre de usuario. Si no lo encuentra retorna null;
     * @throws NullPointerException se lanzá cuando no encuentra a un jugador.
     * @throws EmptyDataException se lanzá cuando no se ingresa un valor vacio.
     */
    public Player searchPlayer(String userName) throws EmptyDataException, NotExistPlayerException, EmptyPlayerStructureException {
    	Player found;

        if (userName.equals("")){
            throw new EmptyDataException();

        }else {
            if (root != null){
                found = root.search(userName);
            }else {
                throw new EmptyPlayerStructureException();
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

    /**
     * Elimina un jugador del juego, indicando su nombre de usuario.
     * @param userName - Es el nombre de usuario del jugador a eliminar.
     */
    public void deletePlayer(String userName)throws EmptyDataException, EmptyPlayerStructureException {
        if (userName.equals("")){
            throw new EmptyDataException();
        }else {
            if (root != null){
                root = root.delete(userName);

            }else {
                throw new EmptyPlayerStructureException();
            }
        }
        numberPlayers--;
    }

    /**
     * Guarda el estado del juego
     */
    public void saveStateGame() {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(SERIALITATION_PATH)));
            oos.writeObject(root);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el estado del juego.
     */
    public void loadStateGame(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(SERIALITATION_PATH)));
            root = (Player) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se encarga de inicialziar el recorrido en preOrden del arbol binario de jugadores
     * @return La lista con los jugadores del arbol.
     */
    private List<Player> treeToList(){
        List<Player> list = new ArrayList<Player>();

        if (root != null){
            root.preOrder(list);
        }

        return list;
    }

    /**
     * Se encarga de crear el ranking de los mejores jugadores agregandolos a la lista para, posteriormente, mostrarla en pantalla.
     * @param list La lista organizada de la cual saldra el rankong de los mejores jugadores.
     * @return La lista de los mejores jugadores del juego.
     */
    public ObservableList<Player> showInformation(List<Player> list){
        ObservableList<Player> data = FXCollections.observableArrayList();

        for (int i = 0; i < 15; i++) {
            data.add(list.get(i));
        }

        return data;
    }

    /**
     * Organiza la lista, utilizando como criterio el nombre completo del jugador, atraves del algoritmo de ordenamiento burbuja.
     * @return La lista organizada de acuerdo a su criterio.
     */
    public List<Player> sortByName(){
        List<Player> list = treeToList();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                if (list.get(j).compareTo(list.get(j+1).getFullName()) == -1){
                    Player temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

    /**
     * Organiza la lista, utlizando como criterio el puntaje global del jugador, atraves del algoritmo de ordenamiento.
     * @return La lista organizada de acuerdo a su criterio.
     */
    public List<Player> sortByScore(){
        List<Player> list = treeToList();

        for (int i = 0; i < list.size(); i++) {
            Player current = list.get(i);
            int j = i;

            while(j > 0 && list.get(j-1).getGlobalScore() < current.getGlobalScore()){
                list.set(j, list.get(j-1));
                j--;
            }
            list.set(j, current);
        }
        return list;
    }

    /**
     * Organiza la lista, utilizando como criterio el numero de victorias del jugador, atraves del algoritmo de ordenamiento.
     * @return La lista organizada de acuerdo a su criterio.
     */
    public List<Player> sortByVictories(){
        List<Player> list = treeToList();

        for (int i = 0; i < list.size()-1; i++) {
            Player min = list.get(i);
            int c = i;

            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).getWonGames() > min.getWonGames()){
                    min = list.get(j);
                    c = j;
                }
            }
            Player aux = list.get(i);
            list.set(i, min);
            list.set(c, aux);
        }
        return list;
    }

}
