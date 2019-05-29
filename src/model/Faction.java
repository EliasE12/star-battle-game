package model;

import model.LivingBeing.Species;
import model.Match.Direction;
import model.Robot.Funtion;

import java.io.*;

// Clase

/**
 * Entidad que representa una facción.
 */
public class Faction implements Serializable {

    // Constantes

    /**
     * Indica el tipo de naves que pertenecen a la facción.
     */
    public enum SpaceShipType{STARFIGHTER, BOMBER, INTERCEPTOR, GUNSHIP, DREADNOUGHT, DESTROYER, BATTLECRUISER, SHUTTLE}

    // Atributos

    /**
     * Es la raiz del árbol miembros de la faccion.
     */
    private Node root;

    /**
     * Es la primera nave de la lista de naves de la facción.
     */
    private Spaceship first;

    /**
     * Es el nombre de la facción.
     */
    private String name;

    /**
     * Es el número de miembros de la facción.
     */
    private int memberN;

    /**
     * Es el lider de la facción.
     */
    private Leader leader;

    // Constructor

    /**
     * Inicializa los valores de los atributos de la facción.
     * @param name - Es el nombre de la faccion.
     * @param memberN - Es el número de miembros en la facción.
     * @param leader - Es el lider e la facción
     */
    public Faction(String name, int memberN, Leader leader) {
        this.name = name;
        this.memberN = memberN;
        this.leader = leader;
    }

    // Métodos

    /**
     * Devuelve el lider creado por el usuario al momento de comenzar una nueva partida.
     * @return El lider de la faccion del jugador
     */
    public Leader getLeader() {
        return leader;
    }

    /**
     * Verifica si la posición en el tablero de juego en la que se va a colocar una nueva nave, es permitida o no.
     * @param matriz - Es el tablero de juego.
     * @param i - Es la posición i del tablero de juego.
     * @param j - Es la posición j del tablero de juego.
     * @param direction - Es la dirección en la que se va a colocar la nave en el tablero de juego. Puede se HORIZONTAL O VERTICAL.
     * @param sizeSpaceshit - Es el tamaño de la nave, es decir, el número de casillas que ocupará en el tablero de juego.
     * @return - true si la posición en la que se colocará la nave es permitida. False si la posición en la que se colocará la nave no es permitida.
     */
    public boolean checkPosition(String[][] matriz, int i, int j, Direction direction, int sizeSpaceshit) {
        boolean valido = false;
        if (direction.equals(Direction.HORIZONTAL)) {
            int size = 0;
            while(j < matriz[0].length && !valido) {
                if (matriz[i][j].equals("X")) {
                    valido = false;
                } else if (size >= matriz[0].length) {
                    valido = false;
                } else if (size == sizeSpaceshit) {
                    //Verifica si la ultima posición de la nave la casilla siguiente existe otra nave.
                    if(j+1 < matriz[0].length){
                        valido = !matriz[i][j + 1].equals("X");
                    }else{
                        valido = true;
                    }
                }
                size++;
                j++;
            }

        } else if (direction.equals(Direction.VERTICAL)) {
            int size = 0;
            while(i < matriz.length && !valido) {
                if (matriz[i][j].equals("X")) {
                    valido = false;
                } else if (size >= matriz.length) {
                    valido = false;
                } else if (size == sizeSpaceshit) {
                    //Verifica si la ultima posición de la nave la casilla siguiente existe otra nave.
                    if(i+1 < matriz.length){
                        valido = !matriz[i + 1][j].equals("X");
                    }else {
                        valido = true;
                    }

                }
                size++;
                i++;
            }
        }
        return valido;
    }



    /**
     * Crea posiciones en X y Y aleatorias, para verificar si es posible posicionar la nave ha crear en dicha posicion.
     * <pre> la matriz en la cual se va ha posicionar la nave tiene que ser != null</>
     * @param type el tipo de nave ha crear
     * @param size el tamano de la nave
     * @param gameBoard la matriz en la cual se posicionara la nave
     */
    public void createRandomNumbers(SpaceShipType type, int size, String[][] gameBoard) {
        Direction direction = null;
        int randomX = 0;
        int randomY = 0;
        int randomD=0;

        boolean valid = false;
        while (!valid) {
            randomX = (int) Math.floor(Math.random() * (Match.GAME_BOARD_SIZE - (0 + 1)) + 0);
            randomY = (int) Math.floor(Math.random() * (Match.GAME_BOARD_SIZE - (0 + 1)) + 0);
            randomD = (int) Math.floor(Math.random() * 2+1);

            if (randomD == 1){
                direction = Direction.HORIZONTAL;
            }else if(randomD == 2){
                direction = Direction.VERTICAL;
            }

            boolean checkAdjacentBoxes = checkAdjacentBoxes(randomX,randomY,gameBoard);
            boolean checkPosition = checkPosition(gameBoard, randomX, randomY, direction, size);
            valid = checkPosition && checkAdjacentBoxes;

        }

        positionShip(randomX, randomY, direction, size,gameBoard);
    }


    /**
     * Posiciona una nueva nave en una posición permitida del tablero de juego.
     * @param matriz - Es el tablero de juego.
     * @param i - Es la posición i del tablero de juego.
     * @param j - Es la posición j del tablero de juego.
     * @param direction - s la dirección en la que se va a colocar la nave en el
     *      *                    tablero de juego. Puede se HORIZONTAL O VERTICAL.
     * @param size_Nave - Es el tamaño de la nave, es decir, el número de casillas que ocupará en el tablero de juego.
     */
    public void positionShip(int i, int j, Direction direction, int size_Nave,String[][] matriz) {
        if(checkPosition(matriz, i, j, direction, size_Nave)) {
            if(checkAdjacentBoxes(i, j,matriz)) {


                boolean termino = false;
                if (direction.equals(Direction.HORIZONTAL)) {
                    while (!termino) {
                        matriz[i][j] = "X";
                        size_Nave--;
                        if (size_Nave < 1) {
                            termino = true;
                        }
                        j++;
                    }
                } else {
                    while (!termino) {
                        matriz[i][j] = "X";
                        size_Nave--;
                        if (size_Nave < 1) {
                            termino = true;
                        }
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Verifica si las casillas contiguas a la parte de la naves tienen naves cercanas.
     * @param i	fila de la matriz.
     * @param j columna de la matriz.
     * @return true : Si no existen casilla contiguas a la matriz.
     * 		   false : Si existe casillas contiguas a la matriz.
     */
    private boolean checkAdjacentBoxes(int i, int j,String[][] matriz) {
        boolean found = false;
        int size = matriz.length;
        int contador = 0;

        if(matriz[i][j].equals("X")) {
            contador++;
        }

        //Verifica el extremo superior derecho
        if((i-1 >= 0 && j+1 < size)) {
            if(matriz[i-1][j+1].equals("X")) {
                contador++;
            }
        }
        //Verifica el extremo superior izquierdo
        if(i-1 >= 0 && j-1 >= 0) {
            if(matriz[i-1][j-1].equals("X")) {
                contador++;
            }
        }
        //Verifica la parte superior
        if(i-1 >= 0) {
            if(matriz[i-1][j].equals("X")) {
                contador++;
            }
        }

        //Verifica la derecha de la matriz
        if(j+1 < size) {
            if(matriz[i][j+1].equals("X")) {
                contador++;
            }
        }

        //Verifica la izquierda de la matriz.
        if(j-1 >= 0) {
            if(matriz[i][j-1].equals("X")) {
                contador++;
            }
        }

        //Verifica la parte inferior
        if(i+1 < size){
            if(matriz[i+1][j].equals("X")) {
                contador++;
            }
        }
        //Verifica el extremo inferior derecho.
        if(i+1 < size && j+1 < size) {
            if(matriz[i+1][j+1].equals("X")) {
                contador++;
            }
        }

        //Verifica el extremo inferior izquierdo.
        if(i+1 < size  && j-1 >= 0) {
            if(matriz[i+1][j-1].equals("X")) {
                contador++;
            }
        }


        found = contador <= 0;

        return found;


    }


    /**
     * Comienza el proceso de creacion de los miembros de la faccion, con la llamada a los metodos de crear seres vivos y crear robots.
     * @param livingBeingPath Es la ruta del archivo de texto, donde se guarda la informacion de los seres vivos.
     * @param robotPath Es la ruta del archivo de texto, donde se guarda la informacion de los robots.
     * @param n Es el numero de miembros, tando de robots como de seres vivos, que el usuario quiere crear.
     * @throws IOException Se lanza cuando no se encuentra o el archivo de texto esta corrupto.
     */
    public void createMembers(String livingBeingPath, String robotPath, int n) throws IOException {
        int livingBeingsN = n - ((n*10)/100);
        int robotsN = ((n*10)/100);

        createLivingBeings(livingBeingPath, livingBeingsN);
        createRobots(robotPath, robotsN);
    }

    /**
     * Agrega los nuevos nodos al arbol de miembros.
     * @param toAdd Es el nodo a agregar.
     */
    private void addNode(Node toAdd){
        if (root == null){
            root = toAdd;

        }else {
            root.addNode(toAdd);
        }
    }

    /**
     * Se encarga de leer y, posteriormente, crear a los miembros que son seres vivos con todos sus datos obtenidos del archivo de texto de seres vivos.
     * @param path Es la ruta del archivo de texto, el cual posee toda la informacion de los miembros que son seres vivos.
     * @param limit Es el limite de miemrbros a crear.
     * @throws IOException Se lanza cuando el archivo de texto con la informacion, no se encuentra o esta corrupto.
     */
    private void createLivingBeings(String path, int limit) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        int counter = 0;
        String line = br.readLine();
        while(line != null && counter < limit){
            Node node = new Node();

            String[] words = line.split(",");
            int age = Integer.parseInt(words[0]);
            int yearsService = Integer.parseInt(words[1]);
            String name = words[2];
            String dialect = words[3];
            Species species = decideSpecies(words[4]);

            Member member = new LivingBeing(age, yearsService, name, dialect, species);
            node.setMember(member);

            addNode(node);

            line = br.readLine();
            counter ++;
        }
    }

    /**
     * Identifica el tipo de especie que es el ser vivo a crear, con la informacion proporcionada por el archivo de texto.
     * @param specie Es la especie la cual se a identificar.
     * @return La especie del ser vivo identificada.
     */
    private Species decideSpecies(String specie){
        Species species = null;

        switch (specie){
            case "Human":
                species = Species.HUMAN;
                break;
            case "Twilek":
                species = Species.TWILEK;
                break;
            case "Wookie":
                species = Species.WOOKIE;
                break;
            case "Togruta":
                species = Species.TOGRUTA;
                break;
            case "Ewok":
                species = Species.EWOK;
                break;
            case "Gungan":
                species = Species.GUNGAN;
                break;
            case "Jawa":
                species = Species.JAWA;
                break;
            case "Hutt":
                species = Species.HUTT;
                break;
            case "Sith":
                species = Species.SITH;
                break;
        }
        return species;
    }

    /**
     * Se encarga de leer y, posteriormente, crear a los miembros que son robots con todos sus datos obtenidos del archivo de texto de robots.
     * @param path Es la ruta del archivo de texto, el cual posee toda la informacion de los miembros que son robots.
     * @param limit Es el limite de miembros a crear.
     * @throws IOException Se lanza cuando el archivo de texto con la informacion, no se encuentra o esta corrupto.
     */
    private void createRobots(String path, int limit) throws IOException {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        int counter = 0;
        String line = br.readLine();
        while(line != null && counter < limit){
            Node node = new Node();

            String[] words = line.split(",");
            int age = Integer.parseInt(words[0]);
            int yearsService = Integer.parseInt(words[1]);
            String model = words[2] + "-" + words[3];
            Funtion funtion = decideFuntion(words[4]);

            Member member = new Robot(age, yearsService, model, funtion);
            node.setMember(member);

            addNode(node);

            line = br.readLine();
            counter ++;
        }
    }

    /**
     * Identifica el tipo de funcion que posee el robot a crear, con la informacion proporcionada por el archivo de texto.
     * @param funtion Es la funcion la cual se a identificar.
     * @return La funcion del robot identificada.
     */
    private Funtion decideFuntion(String funtion){
        Funtion f = null;

        switch (funtion){
            case "Combat":
                f = Funtion.COMBAT;
                break;
            case "Astronomechanical":
                f = Funtion.ASTRONOMECHANICAL;
                break;
            case "Doctor":
                f = Funtion.DOCTOR;
                break;
            case "Protocol":
                f = Funtion.PROTOCOL;
                break;
        }
        return f;
    }

    /**
     * Se encarga de crear la flota de la faccion, tanto del jugador como de la maquina.
     * @param win True si el jugador gano. False en caso contrario.
     * @param type Es el tipo de nave a crear.
     */
    public void createFleet(boolean win, SpaceShipType type){
        Spaceship spaceship = null;

        switch (type){
            case BATTLECRUISER:
                if (win){
                    spaceship = new Battlecruiser("Battlecruiser", 100, "BR-1", 1000, Battlecruiser.AMOUNT_LIFE, 50, 50, 50, Battlecruiser.LIGHTNING_SHIELD, true, true);
                }else {
                    spaceship = new Battlecruiser("Battlecruiser", 100, "BR-1", 1000, Battlecruiser.AMOUNT_LIFE/2, 50, 50, 50, Battlecruiser.LIGHTNING_SHIELD, true, true);
                }
                break;

            case STARFIGHTER:
                if (win){
                    spaceship = new Starfigther("Starfigther", 1, "SR-1", 1000, Starfigther.AMOUNT_LIFE, 5);
                }else {
                    spaceship = new Starfigther("Starfigther", 1, "SR-1", 1000, Starfigther.AMOUNT_LIFE/2, 5);
                }
                break;

            case INTERCEPTOR:
                if (win){
                    spaceship = new Interceptor("Interceptor", 1, "IR-1", 1000, Interceptor.AMOUNT_LIFE, 5, 10, 30);
                }else {
                    spaceship = new Interceptor("Interceptor", 1, "IR-1", 1000, Interceptor.AMOUNT_LIFE/2, 5, 10, 30);
                }
                break;

            case GUNSHIP:
                if (win){
                    spaceship = new Gunship("Gunship", 1, "GP-1", 1000, Gunship.AMOUNT_LIFE, 5, 5, 5, 5, Gunship.PARTICLE_SHIELD, true);
                }else {
                    spaceship = new Gunship("Gunship", 1, "GP-1", 1000, Gunship.AMOUNT_LIFE/2, 5, 5, 5, 5, Gunship.PARTICLE_SHIELD, true);
                }
                break;

            case BOMBER:
                if (win){
                    spaceship = new Bomber("Bomber", 1, "BE-1", 1000, Bomber.AMOUNT_LIFE, 5, 50);
                }else {
                    spaceship = new Bomber("Bomber", 1, "BE-1", 1000, Bomber.AMOUNT_LIFE/2, 5, 50);
                }
                break;
            case DREADNOUGHT:
                if (win){
                    spaceship = new Dreadnought("Dreadnought", 300, "DT-1", 1000, Dreadnought.AMOUNT_LIFE, true, 80, 80, 80);
                }else {
                    spaceship = new Dreadnought("Dreadnought", 300, "DT-1", 1000, Dreadnought.AMOUNT_LIFE/2, true, 80, 80, 80);
                }
                break;

            case DESTROYER:
                if (win){
                    spaceship = new Destroyer("Destroyer", 70, "DR-1", 1000, Destroyer.AMOUNT_LIFE, 30, 30);
                }else {
                    spaceship = new Destroyer("Destroyer", 70, "DR-1", 1000, Destroyer.AMOUNT_LIFE/2, 30, 30);
                }
                break;
            case SHUTTLE:
                if (win){
                    spaceship = new Shuttle("Shuttle", 2, "SE-1", 1000, Shuttle.AMOUNT_LIFE, 2, 2);
                }else {
                    spaceship = new Shuttle("Shuttle", 2, "SE-1", 1000, Shuttle.AMOUNT_LIFE/2, 2, 2);
                }
                break;
        }
        addSpaceShip(spaceship);
    }

    /**
     * Agrega las naves creadas a la lista de naves de la faccion.
     * <pre> la nueva nave toAdd es != null.</>
     * @param toAdd Es la nueva nave a agregar.
     */
    private void addSpaceShip(Spaceship toAdd){
        if (first == null){
            first = toAdd;
        }else {
            Spaceship current = first;
            while(current.getNext() != null){
                current = current.getNext();
            }

            current.setNext(toAdd);
            current.getNext().setPrevius(current);
        }
    }
}
