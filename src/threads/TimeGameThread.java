package threads;

import model.Match;

// Clase

/**
 * Entidad que representa el cronómetro que mide el tiempo de juego.
 */
public class TimeGameThread extends Thread {

    // Atributos

    /**
     * Es la partida a la que se le mide el tiempo.
     */
    private Match match;

    // Constructor

    /**
     * Inicializa el cronómetro con la partidad ingresada.
     * @param match - la partida.
     */
    public TimeGameThread(Match match) {
        this.match = match;
    }

    /**
     * Es el cronómetro de la partida.
     */
    @Override
    public void run() {
        match.manageMatchTime();
    }
}
