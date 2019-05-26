package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Excepción

/**
 * Entidad que representa un error que produce nombres de ususario no existen.
 */
public class NotRegisteredUsersException extends Exception {

    // Constructor

    /**
     * Construye la excepción con el mensaje indicado.
     */
    public NotRegisteredUsersException() {
        super("Para poder realizar la acción deseada, se necesitan usuarios registrados");
    }

    // Métodos

    /**
     * Es el mendaje que se muestra cuando se produce la excepción.
     */
    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "No hay usuarios registrados", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
