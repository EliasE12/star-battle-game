package model;

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



    public void createRandomNumbers(SpaceShipType type, int size, String[][] gameBoard) {
        Match.DIRECTION direction;
        int randomX = 0;
        int randomY = 0;
        int randomD = 0;

        boolean posicion = false;

        while (!posicion) {
            randomX = (int) Math.floor(Math.random() * (0 - (Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE - 1) - 1));
            randomY = (int) Math.floor(Math.random() * (0 - (Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE - 1) - 1));
            randomD = (int) Math.floor(Math.random() * (1 - (2)) + (2 - 1));

        }

        if (randomD == 1){
            direction = Match.DIRECTION.HORIZONTAL;
        }else {
            direction = Match.DIRECTION.VERTICAL;
        }

        posicionarNave(gameBoard, randomX, randomY, direction, size);
    }

    public void posicionarNave(String[][] matriz,int x, int y, Match.DIRECTION direction, int  size_Nave){
        boolean termino = false;

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
