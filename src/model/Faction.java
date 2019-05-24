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



    public void createRandomNumbers(SpaceShipType type, int size){
        int randomX;
        int randomY;
        int randomD;

        boolean posicion = false;

        while(!posicion){
            int posX = (int)Math.floor(Math.random()*(0-(Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE-1) - 1));
            int posY = (int)Math.floor(Math.random()*(0-(Match.GAME_BOARD_SIZE - 1)) + ((Match.GAME_BOARD_SIZE-1) - 1));
            int Direction = (int)Math.floor(Math.random()*(1-(2)) + (2 - 1));

            
        }
    }
}
