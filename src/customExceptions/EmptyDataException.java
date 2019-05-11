package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyDataException extends Exception {

    public EmptyDataException() {
        super("Para poder realizar la acción deseada, todos los campos correspondientes deben de estar llenados.");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Hay campos necesarios que aún no estan llenados", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
