package threads;

import controllers.GameBoardController;

public class WinnerThread extends Thread {

    private GameBoardController gbc;
    private boolean stop;

    public WinnerThread(GameBoardController gbc) {
        this.gbc = gbc;
        stop = false;
    }

    @Override
    public void run() {
        while(!stop){
            gbc.checkUncoveredShips();
            stopped();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void stopped(){
        boolean finishMachine = gbc.getPlayer().getMatch().checkUncoveredShips(gbc.getPlayer().getMatch().getGameBoardPlayer(), gbc.getGameBoardP());
        boolean finishUser = gbc.getPlayer().getMatch().checkUncoveredShips(gbc.getPlayer().getMatch().getGameBoardMachine(), gbc.getGameBoardM());

        if (finishMachine || finishUser){
            stop = true;
        }
    }
}
