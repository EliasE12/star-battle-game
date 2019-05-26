package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// Excepción

/**
 *
 * Entidad que representa un error que indica que un jugador no existe.
 */
public class NotExistPlayerException extends Exception{

    // Constructor

    /**
     * Construye la excepción en el indicado.
     */
    public NotExistPlayerException(){
        super("Nombre de uusario incorrecto o jugador no registrado");
    }

    // Métodos

    /**
     * Es el mensaje que se muestra cuando se produce la excepción.
     */
    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "El jugador buscado no existe", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
