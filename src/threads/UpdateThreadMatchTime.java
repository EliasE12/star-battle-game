package threads;

import controllers.GameBoardController;
import javafx.application.Platform;

// Excepción

/**
 * Entidad que representa el hilo que actualiza el tiempo de la partida.
 */
public class UpdateThreadMatchTime extends Thread {

    // atributos

    /**
     * Es el tiempo en que se va actualizar la duración de la partida.
     */
    private static final int SLEEP_TIME = 1000;

    /**
     * Es el controlador donde se va a actualizar el tiempo.
     */
    private GameBoardController gbc;

    /**
     * Es la condicion de parada del ciclo que realiza el hilo
     */
    private boolean stop;

    /**
     * Actualiza el cronómetro con la partida.
     * @param gbc - El controlador el cual es el encargado de actualizar el tiempo del juego en la interfaz del usuario.
     */
    public UpdateThreadMatchTime(GameBoardController gbc) {
        this.gbc = gbc;
        stop = false;
    }

    /**
     * Actualiza el cronómetro de la partida.
     */
    @Override
    public void run() {
        while(!stop){

            TimeGameThread timeGameThread = new TimeGameThread(gbc);
            Platform.runLater(timeGameThread);
            stopped();

            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Se encarga de verificar la continuidad del ciclo del hilo, inspeccionando que el tiempo de la partida en curso aun sea mayor que 0.
     */
    private void stopped(){
        boolean finishMachine = gbc.getPlayer().getMatch().checkUncoveredShips(gbc.getPlayer().getMatch().getGameBoardPlayer(), gbc.getGameBoardP());
        boolean finishUser = gbc.getPlayer().getMatch().checkUncoveredShips(gbc.getPlayer().getMatch().getGameBoardMachine(), gbc.getGameBoardM());

        if (gbc.getPlayer().getMatch().getTime() <= 0 || (finishMachine || finishUser)){
            stop = true;
        }
    }
}
