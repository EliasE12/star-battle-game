package model;
import model.Match.Direction;

public class Faction {

    public enum SpaceShipType{STARFIGHTER, BOMBER, INTERCEPTOR, GUNSHIP, DREADNOUGHT, DESTROYER, BATTLECRUISER, SHUTTLE};

    private Node root;
    private Spaceship first;

    private String name;
    private int memberN;
    private Leader leader;


    public Faction(String name, int memberN, Leader leader) {
        this.name = name;
        this.memberN = memberN;
        this.leader = leader;
    }


    private boolean verificarPosition(String[][] gb, int posF, int postC, Direction direction, int sizeSpaceshit) {
        boolean valido = false;
        if (direction.equals(Direction.HORIZONTAL)) {
            int size = 0;
            for (int i = 0; i < gb.length && !valido; i++) {
                if (i == posF) {
                    if (!gb[i][postC].equals("")) {
                        return false;
                    } else {
                        gb[i][postC] = "*";
                        size++;
                    }

                    if (size == sizeSpaceshit) {
                        valido = true;
                    }
                }
            }
        } else if (direction.equals(Direction.VERTICAL)) {
            int size = 0;
            for (int j = 0; j < gb[0].length && !valido; j++) {
                if (j == postC) {
                    if (!gb[posF][j].equals("")) {
                        return false;
                    } else {
                        gb[j][postC] = "*";
                        size++;
                    }

                    if (size == sizeSpaceshit) {
                        valido = true;
                    }
                }
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
        int randomD;

        boolean posicion = false;

        while (!posicion) {
            randomX = (int) Math.floor(Math.random() * (0 - (Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE - 1) - 1));
            randomY = (int) Math.floor(Math.random() * (0 - (Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE - 1) - 1));
            randomD = (int) Math.floor(Math.random() * (1 - (2)) + (2 - 1));

            if (randomD == 1){
                direction = Direction.HORIZONTAL;
            }else {
                direction = Direction.VERTICAL;
            }

            posicion = verificarPosition(gameBoard, randomX, randomY, direction, size);

        }
        posicionarNave(gameBoard, randomX, randomY, direction, size);
    }


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
