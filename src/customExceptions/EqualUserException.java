package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Excepción

/**
 * Entidad que representa un error que indica que dos jugadores son iguales.
 */
public class EqualUserException extends Exception {

    // Constructor

    /**
     * Construye la excepción con el mensaje indicado.
     */
    public EqualUserException() {
        super("Para crear un perfil, el nombre de usuario debe ser único");
    }

    // Métodos

    /**
     * Es el mensaje que se muestra cuando se produce la excepción.
     */
    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Se ha encontrado otro jugador con el mismo nombre de usuario", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
