package threads;

//Clase

import controllers.GameBoardController;
import javafx.application.Platform;

/**
 * Entidad que representa el hilo que actualiza el tiempo del turno de la partida en curso.
 */
public class UpdateThreadTurnTime extends Thread {

    //Constantes

    /**
     * Representa el tiempo que tinene que dormir el hilo para actualizar el tiempo del turno de la partida en curso.
     */
    private static final long SLEEP_TIME = 1000;

    //Relaciones

    /**
     * Es la relacion con la controladora que hace posible actualzar el tiempo del turno en pantalla.
     */
    private GameBoardController gbc;

    //Constructor

    /**
     * Inicialzia la relacion con la controladora para actualizar el tiempo del turno en pantalla.
     * @param gbc
     */
    public UpdateThreadTurnTime(GameBoardController gbc) {
        this.gbc = gbc;
    }

    /**
     * Metodo que crea el hilo que permite actualizar el tiempo del turno en pantalla.
     */
    @Override
    public void run() {
        while (true){
            TimeTurnThread ttt = new TimeTurnThread(gbc);
            Platform.runLater(ttt);

            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
