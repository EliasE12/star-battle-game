package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Excepción

/**
 * Entidad que representa un error que indica que los campos en los que se requieren datos están vacíos.
 */
public class EmptyDataException extends Exception {

    // Constreuctor

    /**
     * Construye la excepción con el mensaje indicado.
     */
    public EmptyDataException() {
        super("Para poder realizar la acción deseada, todos los campos correspondientes deben de estar llenados.");
    }

    // Métodos

    /**
     * Es el mendaje que se muestra cuando se produce la excepción.
     */
    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Hay campos necesarios que aún no estan llenados", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
