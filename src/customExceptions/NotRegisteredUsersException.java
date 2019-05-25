package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NotRegisteredUsersException extends Exception {

    public NotRegisteredUsersException() {
        super("Para poder realizar la acción deseada, se necesitan usuarios registrados");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "No hay usuarios registrados", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
