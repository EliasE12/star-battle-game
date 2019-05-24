package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EqualUserException extends Exception {

    public EqualUserException() {
        super("Para crear un perfil, el nombre de usuario debe ser único");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Se ha encontrado otro jugador con el mismo nombre de usuario", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
