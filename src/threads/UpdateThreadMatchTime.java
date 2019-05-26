package threads;

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
    private Match match;

    /**
     * Actualiza el cronómetro con la partida.
     * @param match - la partida.
     */
    public UpdateThreadMatchTime(Match match) {
        this.match = match;
    }

    /**
     * Actualiza el cronómetro de la partida.
     */
    @Override
    public void run() {
        while(true){
            TimeGameThread timeGameThread = new TimeGameThread(match);
            Platform.runLater(timeGameThread);

            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
