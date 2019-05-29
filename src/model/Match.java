package model;

import customExceptions.EmptyDataException;
import customExceptions.MemberLimitException;
import javafx.scene.control.Button;
import model.Faction.SpaceShipType;

import java.io.IOException;
import java.io.Serializable;

// Clase

/**
 * Entidad que representa un partida del juego.
 */
public class Match implements Serializable {

    // Constantes

    /**
     * Indica el numero de casillas que poseen naves dentro del tablero de juego.
     */
    public static final int AMOUNT_OF_MARKERS = 21;

    /**
     * Indica la ruta de los archivos donde se guarda la informacion de los miembros de la(s) faccion(nes)
     */
    public static final String LIVING_BEING_DATA_USER = "data/LIVINGBEING_USER_DATA.csv";
    public static final String ROBOT_DATA_USER = "data/ROBOT_USER_DATA.csv";
    public static final String LIVING_BEING_DATA_MACHINE = "data/LIVINGBEING_MACHINE_DATA.csv";
    public static final String ROBOT_DATA_MACHINE = "data/ROBOT_MACHINE_DATA.csv";

    /**
     * Indica la duración de la partida.
     */
    public static final long DURATION_MATCH_HIGH_LEVEL = 600;
    public static final long DURATION_MATCH_MEDIUM_LEVEL = 900;
    public static final long DURATION_MATCH_LOW_LEVEL = 1200;

    /**
     * Idica la duración del turno.
     */
    public static final long DURATION_TURN_HIGH_LEVEL = 20;
    public static final long DURATION_TURN_MEDIUM_LEVEL = 30;
    public static final long DURATION_TURN_LOW_LEVEL = 40;

    /**
     * Indica el tamaño del tablero de juego.
     */
    public static final int GAME_BOARD_SIZE = 10;

    /**
     * Indica los distintos tipos de líderes que pueden existir.
     */
    public enum LeaderType {DOMINATOR, PROTECTOR, STRATEGIST}

    /**
     * Indica los distintos tipos de posiciones en los que se puede posicionar una nave en el tablero de juego.
     */
    public enum Direction {HORIZONTAL, VERTICAL}

    // Atributos

    /**
     * Es la facción que pertenece al jugador.
     */
    private Faction user;

    /**
     * Es la facción que pertenece a la máquina.
     */
    private Faction machine;


    /**
     * Es el tiempo de juego.
     */
    private long time;

    /**
     * Es el puntaje del jugador en la partida.
     */
    private int score;

    /**
     * Indica si el jugador gana o no la partida.
     */
    private boolean win;

    /**
     * Es el tablero de juego perteneciente al jugador.
     */
    private String[][] gameBoardPlayer;

    /**
     * Es el tablero de juego perteneciente a la máquina.
     */
    private String[][] gameBoardMachine;


    //Constructor

    /**
     * Inicializa los valores de los atributos de la partida.
     * @param time - El tiempo de juego.
     * @param score . El puntaje del jugador en la partida.
     * @param win - Indica si el jugador gana o na la partida.
     */
    public Match(long time, int score, boolean win) {
        this.time = time;
        this.score = score;
        this.win = win;

        gameBoardPlayer = new String[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
        gameBoardMachine = new String[GAME_BOARD_SIZE][GAME_BOARD_SIZE];

        fillMatrix(gameBoardPlayer);
        fillMatrix(gameBoardMachine);
    }

    /**
     * Devuelve la faccion creada por el usuario.
     * @return La faccion del jugador.
     */
    public Faction getUser() {
        return user;
    }

    /**
     * Devuelve el valor que posee el atributo time de la clase Match.
     * @return El valor y/o numero que posee el parametro time.
     */
    public long getTime(){
        return time;
    }

    /**
     * Cambia el valor del parametro time.
     * @param time Es el nuevo valor que se le dara al parametro time
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Devuelve el valor del parametro score de la clase Match.
     * @return El valor y/o numero que posee el parametro score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Cambia el valor del parametro score.
     * @param score Es el nuevo valor para el paramtro score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Devuelve el valor del parametro win de la clase Match.
     * @return true si el jugador gano la partida en curso. False en caso contrario.
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Devuelve la matriz que contiene el tablero de juego del jugador.
     * @return gameBoardPlayer.
     */
    public String[][] getGameBoardPlayer() {
        return gameBoardPlayer;
    }

    /**
     * Devuelve la matriz que contiene el tablero de juego de la máquina.
     * @return gameBoardMachine
     */
    public String[][] getGameBoardMachine() {
        return gameBoardMachine;
    }

    /**
     *Identifica si el jugador o la maquina ya destaparon todas las casillas de us enemigo en el trablero de juego.
     * @param gameBoard Es la matriz de Strings donde se verificara si esta una nave alli posicionada.
     * @param gameBoard2 Es la matriz de botones donde se verificara que el jugador o la maquina ya la hallan destapado.
     * @return True si ya destapo todas las casillas donde hay partes de naves. False en caso contrario.
     */
    public boolean checkUncoveredShips( String[][] gameBoard, Button[][] gameBoard2){
        boolean uncovered = false;
        int counter = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j].equals("X") && gameBoard2[i][j].isDisable()){
                    counter ++;
                }
            }
        }
        if (counter == AMOUNT_OF_MARKERS){
            uncovered = true;
        }

        return uncovered;
    }

    /**
     * Pinta la matriz que representa el tablero de juego.
     * @param matrix - La matriz que se va a pintar.
     */
    private void fillMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = "*";
            }
        }
    }

    /**
     * Maneja el tiempo de duración de la partida.
     * @return El tiempo de la partida actualizado
     */
    public String manageMatchTime(){
        String s = "";
        time --;

        long hour = (time/3600);
        long minute = ((time-hour*3600)/60);
        long seg = time-(hour*3600+minute*60);

        if (seg < 10){
            s = "0" + seg;

        }else {
            s += seg;
        }

        String matchTime = "00" + ":0" + minute + ":" + s;

        return matchTime;
    }

    /**
     * Metodo que se encarga de crear la faccion con su debido capitan, para comenzar la nueva partida.
     * @param factionName el nombre de la nueva faccion
     * @param members numero de miembros que va ha poseer la faccion
     * @param type tipo de lider que va a poseer la faccion
     * @param leaderName nombre del lider de la nueva faccion
     * @param experience experiencia de combate del nuevo lider de la nueva faccion
     * @throws EmptyDataException - Se lanza cuando algunos de los parametros son nulos o estan vacios.
     */
    public void createUserFaction(String factionName, int members, LeaderType type, String leaderName, Leader.LevelExperience experience) throws EmptyDataException, IOException, MemberLimitException {

        if (factionName.equals("") || type == null || leaderName.equals("") || experience == null){
            throw new EmptyDataException();

        }else {
            if (members > 1000 || members < 100){
                throw new MemberLimitException();

            }else {
                Leader leader1 = null;

                switch (type){
                    case DOMINATOR:
                        leader1 = new Dominator(leaderName, experience, false);
                        break;

                    case PROTECTOR:
                        leader1 = new Protector(leaderName, experience, false);
                        break;

                    case STRATEGIST:
                        leader1 = new Strategist(leaderName, experience, false);
                        break;
                }
                Faction faction = new Faction(factionName, members, leader1);
                user = faction;
                user.createMembers(LIVING_BEING_DATA_USER, ROBOT_DATA_USER, members);

                createMachineFaction(members, type, experience);
            }
        }
    }

    /**
     * Metodo que se encarga de crear la faccion enemiga, dependiendo de la faccion creada por el usaurio
     * @param members numero de miembros que poseera la faccion enemiga
     * @param leaderType tipo de lider que dirigira la faccion enemiga
     * @param experience nivel de experiencia del capitan de la faccion enemiga
     */
    private void createMachineFaction(int members, LeaderType leaderType, Leader.LevelExperience experience) throws IOException {
        Leader leader = null;

        switch (leaderType){
            case DOMINATOR:
                leader = new Protector("Protector", experience, false);
                break;

            case PROTECTOR:
                leader = new Strategist("Strategist", experience, false);
                break;

            case STRATEGIST:
                leader = new Dominator("Dominator", experience, false);
        }
        Faction faction = new Faction("Machine", members, leader);
        machine = faction;
        machine.createMembers(LIVING_BEING_DATA_MACHINE, ROBOT_DATA_MACHINE, members);
    }

    /**
     * Se encarga de calcular el tamano de la nave pasada por parametro.
     * @param spaceShipType tipo de nave a calcular el tamano
     * @return El tamano de la nave especificada por parametro
     */
    private int calculateSizeShip(SpaceShipType spaceShipType){
        int size = 0;

        switch (spaceShipType){
            case BOMBER:
                size = Bomber.SIZE;
                break;

            case GUNSHIP:
                size = Gunship.SIZE;
                break;

            case SHUTTLE:
                size = Shuttle.SIZE;
                break;

            case DESTROYER:
                size = Destroyer.SIZE;
                break;

            case DREADNOUGHT:
                size = Dreadnought.SIZE;
                break;

            case INTERCEPTOR:
                size = Interceptor.SIZE;
                break;

            case STARFIGHTER:
                size = Starfigther.SIZE;
                break;

            case BATTLECRUISER:
                size = Battlecruiser.SIZE;
                break;
        }
        return size;
    }

    /**
     * Inicializa el llamado a los metodos que se encargan de crear las naves en las posiciones escogidas por el jugador.
     * <pre>La matriz gameBoardPlayer donde se van a posicionar las naves del jugador, debe ser != null</>
     * <pre>La matriz gameBoardMachine donde se van a posicionar las naves de la maquina, debe ser != null</>
     * @param spaceShipType tipo de nave a crear y/o posicionar
     * @param direction direccion en la que se va a posicionar la nave
     * @param position posicion donde se creara la nueva nave
     * @throws EmptyDataException - se lanza cuando alguno de lso parametros es nulo o esta vacio
     */
    public void createSpaceShips(SpaceShipType spaceShipType, Direction direction, String position)throws EmptyDataException{
        if (spaceShipType == null || direction == null){
            throw new EmptyDataException();

        }else {
            int size;
            size = calculateSizeShip(spaceShipType);

            String[] p = position.split(",");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);

            user.positionShip(x, y, direction, size,gameBoardPlayer);
            machine.createRandomNumbers(spaceShipType, size, gameBoardMachine);
        }
    }

    /**
     * Se encarga de verificar que si en la posicion, pasada como parametro, haya ubicada una nave en el tablero de juego del jugador.
     * @param position posicion donde se verificara, en el tablero de juego del jugador, si hay una nave posicionada
     * @return true si en la posicion, pasada por parametro, hay una nave. False en caso contrario.
     */
    public boolean uncoverPlayersBox(String position){
        boolean discoveredShip = false;

        String[] p = position.split(",");
        int x = Integer.parseInt(p[0]);
        int y = Integer.parseInt(p[1]);

        if (gameBoardPlayer[x][y].equals("X")){
            disableAdjoiningCells(x,y,gameBoardPlayer);
            discoveredShip = true;
        }else{
            gameBoardPlayer[x][y] = "#";
        }

        return discoveredShip;
    }

    /**
     * Se encarga de verificar que si en la posicion, pasada como parametro, haya ubicada una nave en el tablero de juego de la maquina.
     * @@param position posicion donde se verificara, en el tablero de juego de la maquina, si hay una nave posicionada
     * @return True si en la posicion pasada como parametro hay una nave. False en caso contrario.
     */
    public boolean uncoverMachineBox(String position){
        boolean discoveredShip = false;

        String[] p = position.split(",");
        int x = Integer.parseInt(p[0]);
        int y = Integer.parseInt(p[1]);

        if (gameBoardMachine[x][y].equals("X")){
            disableAdjoiningCells(x,y,gameBoardMachine);
            discoveredShip = true;
        }

        return discoveredShip;
    }

    /**
     *Verifica que la partida haya sido ganada por el jugador.
     * @return true si la partida la gano el jugador. False en caso contrario.
     */
    public boolean winner(){
        boolean win = false;



        return win;
    }

    /**
     * Se encarga de generar aleatoriamente la posicion del boton que seleccionara la maquina en su debido turno.
     * @return
     */
    public String generatePositionMachine(){
        int x = (int) Math.floor(Math.random() * (GAME_BOARD_SIZE - (0 + 1)) + 0);
        int y =  (int) Math.floor(Math.random() * (GAME_BOARD_SIZE - (0 + 1)) + 0);


        return (x+","+y);
    }


    /**
     * Permite al jugador o a la maquina deshabilitar las casillas contiguas a la posición pasada que no tenga partes de la nave
     * @param i posición de la fila del tablero.
     * @param j posición de la columna del tablero.
     * @param matriz matriz que contiene las naves.
     */
    private void disableAdjoiningCells(int i, int j,String[][] matriz) {
        int size = matriz.length;
        if(matriz[i][j].equals("X")) {

            //Verifica el extremo superior derecho
            if((i-1 >= 0 && j+1 < size)) {
                if(!matriz[i-1][j+1].equals("X")) {
                    matriz[i-1][j+1] = "#";
                }
            }
            //Verifica el extremo superior izquierdo
            if(i-1 >= 0 && j-1 >= 0) {
                if(!matriz[i-1][j-1].equals("X")) {
                    matriz[i-1][j-1] = "#";
                }
            }
            //Verifica el extremo inferior derecho.
            if(i+1 < size && j+1 < size) {
                if(!matriz[i+1][j+1].equals("X")) {
                    matriz[i+1][j+1] = "#";
                }
            }

            //Verifica el extremo inferior izquierdo.
            if(i+1 < size  && j-1 >= 0) {
                if(!matriz[i+1][j-1].equals("X")) {
                    matriz[i+1][j-1] = "#";
                }
            }

            //Verifica la parte superior
            if(i-1 >= 0) {
                if(!matriz[i-1][j].equals("X")) {
                    matriz[i-1][j] = "#";
                }
            }
            //Verifica la parte inferior
            if(i+1 <= size){
                if(!matriz[i+1][j].equals("X")) {
                    matriz[i+1][j] = "#";
                }
            }

        }
    }

    /**
     * Inicializa el proceso de la creacion de las naves espaciales, una ves acabada la primera ronda en el tablero de juego.
     * @param gameBoardM Es el tablero de juego donde se ubican las naves de la maquina.
     * @param gameBoardP Es el tablero de juego donde se ubican las naves del jugador.
     */
    public void battle(Button[][] gameBoardM, Button[][] gameBoardP){
        boolean finishPlayer = checkUncoveredShips(gameBoardMachine, gameBoardM);
        boolean finishMachine = checkUncoveredShips(gameBoardPlayer, gameBoardP);

        user.createFleet(finishPlayer, SpaceShipType.BATTLECRUISER);
        user.createFleet(finishPlayer, SpaceShipType.BOMBER);
        user.createFleet(finishPlayer, SpaceShipType.DESTROYER);
        user.createFleet(finishPlayer, SpaceShipType.DREADNOUGHT);
        user.createFleet(finishPlayer, SpaceShipType.GUNSHIP);
        user.createFleet(finishPlayer, SpaceShipType.INTERCEPTOR);
        user.createFleet(finishPlayer, SpaceShipType.SHUTTLE);
        user.createFleet(finishPlayer, SpaceShipType.STARFIGHTER);

        machine.createFleet(finishMachine, SpaceShipType.BATTLECRUISER);
        machine.createFleet(finishMachine, SpaceShipType.BOMBER);
        machine.createFleet(finishMachine, SpaceShipType.DESTROYER);
        machine.createFleet(finishMachine, SpaceShipType.DREADNOUGHT);
        machine.createFleet(finishMachine, SpaceShipType.GUNSHIP);
        machine.createFleet(finishMachine, SpaceShipType.INTERCEPTOR);
        machine.createFleet(finishMachine, SpaceShipType.SHUTTLE);
        machine.createFleet(finishMachine, SpaceShipType.STARFIGHTER);
    }


}
