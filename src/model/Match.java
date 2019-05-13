package model;

import customExceptions.EmptyDataException;

public class Match {

    public enum LeaderType {DOMINATOR, PROTECTOR, STRATEGIST};

    private Faction user;
    private Faction machine;

    private String time;
    private int score;
    private boolean win;


    public Match(String time, int score, boolean win) {
        this.time = time;
        this.score = score;
        this.win = win;
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
        }
    }

    public void chooseEnemy(){

    }
}
