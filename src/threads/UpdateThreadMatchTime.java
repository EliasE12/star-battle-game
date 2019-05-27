package threads;

import controllers.GameBoardController;
import javafx.application.Platform;
import model.Match;

// Excepción

/**
 * Entidad que representa el hilo que actualiza el tiempo de la partida.
 */
public class UpdateThreadMatchTime extends Thread {

    // atributos

    /**
     * Es el tiempo que se va actualizar la duración de la partida.
     */
    private static final int SLEEP_TIME = 1000;

    /**
     * Es la partida a la que se va a actualizar el tiempo.
     */
    private GameBoardController gbc;

    /**
     * Actualiza el cronómetro con la partida.
     * @param gbc - El controlador el cual es el encargado de actualizar el tiempo del juego en la interfaz del usuario.
     */
    public UpdateThreadMatchTime(GameBoardController gbc) {
        this.gbc = gbc;
    }

    /**
     * Actualiza el cronómetro de la partida.
     */
    @Override
    public void run() {
        while(gbc.getPlayer().getMatch().getTime() > 0){
            TimeGameThread timeGameThread = new TimeGameThread(gbc);
            Platform.runLater(timeGameThread);

            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
