package model;

import customExceptions.EmptyDataException;
import model.Faction.SpaceShipType;

public class Match {

    public static final long DURATION_MATCH = 600000;
    public static final long DURATION_TURN = 60000;

    public static final int GAME_BOARD_SIZE = 10;


    public enum LeaderType {DOMINATOR, PROTECTOR, STRATEGIST};
    public enum Direction {HORIZONTAL, VERTICAL};


    private Faction user;
    private Faction machine;

    private int time;
    private int score;
    private boolean win;

    private String[][] gameBoardPlayer;
    private String[][] gameBoardMachine;


    public Match(int time, int score, boolean win) {
        this.time = time;
        this.score = score;
        this.win = win;

        gameBoardPlayer = new String[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
        gameBoardMachine = new String[GAME_BOARD_SIZE][GAME_BOARD_SIZE];

        fillMatrix(gameBoardPlayer);
        fillMatrix(gameBoardMachine);
    }

    public String[][] getGameBoardPlayer() {
        return gameBoardPlayer;
    }

    public String[][] getGameBoardMachine() {
        return gameBoardMachine;
    }

    private void fillMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = "*";
            }
        }
    }

    public void manageMatchTime(){

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
    public void createUserFaction(String factionName, int members, LeaderType type, String leaderName, Leader.LevelExperience experience) throws EmptyDataException{

        if (factionName.equals("") || type == null || leaderName.equals("") || experience == null){
            throw new EmptyDataException();

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

            //Modificado
            createMachineFaction(members, type, experience);
        }
    }


    //Metodo modificado
    /**
     * Metodo que se encarga de crear la faccion enemiga, dependiendo de la faccion creada por el usaurio
     * @param members numero de miembros que poseera la faccion enemiga
     * @param leaderType tipo de lider que dirigira la faccion enemiga
     * @param experience nivel de experiencia del capitan de la faccion enemiga
     */
    private void createMachineFaction(int members, LeaderType leaderType, Leader.LevelExperience experience){
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


    //Metodo modificado
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

            user.posicionarNave(gameBoardPlayer, x, y, direction, size);
            machine.createRandomNumbers(spaceShipType, size, gameBoardMachine);
        }
    }


    //Metodo Modificado
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
            discoveredShip = true;
        }

        return discoveredShip;
    }


    //Metodo modificado
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
            discoveredShip = true;
        }

        return discoveredShip;
    }


    //Metodo modificado
    public boolean winner(){
        boolean win = false;



        return win;
    }
}
