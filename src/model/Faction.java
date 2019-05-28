package model;
import model.Match.Direction;

// Clase

/**
 * Entidad que representa una facción.
 */
public class Faction {

    // Constantes

    /**
     * Indica el tipo de naves que pertenecen a la facción.
     */
    public enum SpaceShipType{STARFIGHTER, BOMBER, INTERCEPTOR, GUNSHIP, DREADNOUGHT, DESTROYER, BATTLECRUISER, SHUTTLE};

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
     * @param posF - Es la posición x del tablero de juego.
     * @param posC - Es la posición y del tablero de juego.
     * @param direction - Es la dirección en la que se va a colocar la nave en el tablero de juego. Puede se HORIZONTAL O VERTICAL.
     * @param sizeSpaceshit - Es el tamaño de la nave, es decir, el número de casillas que ocupará en el tablero de juego.
     * @return - true si la posición en la que se colocará la nave es permitida. False si la posición en la que se colocará la nave no es permitida.
     */
    private boolean verificarPosition(String[][] matriz, int posF, int posC, Direction direction, int sizeSpaceshit) {
        boolean valido = false;
        if (direction.equals(Direction.HORIZONTAL)) {
            int size = 0;
            for (int j = posC; j < matriz[0].length && !valido; j++) {
                if (matriz[posF][j].equals("X")) {
                    valido = false;
                } else if (size >= matriz[0].length) {
                    valido = false;
                } else if (size == sizeSpaceshit) {
                    valido = true;
                }
                size++;
            }

        } else if (direction.equals(Direction.VERTICAL)) {
            int size = 0;
            for (int j = posF; j < matriz.length && !valido; j++) {
                if (matriz[posF][j].equals("X")) {
                    valido = false;
                } else if (size >= matriz.length) {
                    valido = false;
                } else if (size == sizeSpaceshit) {
                    valido = true;
                }
                size++;

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

        boolean valido = false;

        while (!valido) {
            randomX = (int) Math.floor(Math.random() * (Match.GAME_BOARD_SIZE - (0 + 1)) + 0);
            randomY = (int) Math.floor(Math.random() * (Match.GAME_BOARD_SIZE - (0 + 1)) + 0);
            randomD = (int) Math.floor(Math.random() * 2+1);

            if (randomD == 1){
                direction = Direction.HORIZONTAL;
            }else if(randomD == 2){
                direction = Direction.VERTICAL;
            }

            valido = verificarPosition(gameBoard, randomX, randomY, direction, size);
            System.out.println(valido);
        }

        posicionarNave(gameBoard,randomX, randomY, direction, size);
    }


    /**
     * Posiciona una nueva nave en una posición permitida del tablero de juego.
     * @param matriz - Es el tablero de juego.
     * @param x - Es la posición x del tablero de juego.
     * @param y - Es la posición y del tablero de juego.
     * @param direction - s la dirección en la que se va a colocar la nave en el
     *      *                    tablero de juego. Puede se HORIZONTAL O VERTICAL.
     * @param size_Nave - Es el tamaño de la nave, es decir, el número de casillas que ocupará en el tablero de juego.
     */
    public void posicionarNave(String[][] matriz, int x, int y, Direction direction, int  size_Nave){
        boolean termino = false;

        if (verificarPosition(matriz, x, y, direction, size_Nave)){

            switch (direction) {
                case HORIZONTAL:
                    for (int j = y; !termino; j++) {
                        matriz[x][j] = "X";
                        size_Nave--;
                        if (size_Nave < 1) {
                            termino = true;
                        }
                    }
                    break;

                case VERTICAL:
                    for (int i = x; !termino; i++) {
                        matriz[i][y] = "X";
                        size_Nave--;
                        if (size_Nave < 1) {
                            termino = true;
                        }
                    }
                    break;
            }
        }
    }




}
