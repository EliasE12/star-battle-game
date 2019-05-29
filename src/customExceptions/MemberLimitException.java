package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Excepción

/**
 * Entidad que representa un error que indica el numero maximo y minimo de integarntes que debe poseer una faccion.
 */
public class MemberLimitException extends Exception {

    // Constructor

    /**
     * Construye la excepción con el mensaje indicado.
     */
    public MemberLimitException() {
        super("Al crear a los integrantes de la faccion, deben ser menores a 1000 y mayores a 100");
    }

    // Métodos

    /**
     * Es el mensaje que se muestra cuando se produce la excepción.
     */
    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Numero de integrantes mayor a 1000 o menor a 100", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
