package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyDataException extends Exception {

    public EmptyDataException() {
        super("Para poder iniciar sesión, debe escribir su nombre de usuario.");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "El campo de inicio de sesión está vacío.", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
