package threads;

//Clase

import controllers.GameBoardController;

/**
 * Entidad que representa el cronómetro que mide el tiempo del turno de la partida en curso.
 */
public class TimeTurnThread extends Thread {

    //Atributos

    /**
     * Controlador el cual se encarga de actualziar el tiempo del turno en pantalla.
     */
    private GameBoardController gbc;

    //Constructor

    /**
     *Inicializa el cronómetro del turno con la controladora pasada como parametro.
     * @param gbc Es la controladora donde se ubica el metodo que hace posible actualziar el cronometro en patalla
     */
    public TimeTurnThread(GameBoardController gbc) {
        this.gbc = gbc;
    }

    /**
     * Es el cronometro del turno de la partida.
     */
    @Override
    public void run() {

    }
}
