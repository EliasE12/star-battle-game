package threads;

import controllers.GameBoardController;
import model.Match;

// Clase

/**
 * Entidad que representa el cronómetro que mide el tiempo de juego.
 */
public class TimeGameThread extends Thread {

    // Atributos

    /**
     * Es el controlador el cual se encarga de actualizar el tiempo de la partida en curso.
     */
    private GameBoardController gbc;

    // Constructor

    /**
     * Inicializa el cronómetro con la partidad ingresada.
     * @param gbc - controlador el cual posee el metodo que actualiza el tiempo de la partida en curso.
     */
    public TimeGameThread(GameBoardController gbc) {
        this.gbc = gbc;
    }

    /**
     * Es el cronómetro de la partida.
     */
    @Override
    public void run() {
        gbc.updateMatchTime();
    }
}
