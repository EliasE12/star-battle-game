package customExceptions;

import com.jfoenix.controls.JFXDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class EmptyDataException extends Exception {

    public EmptyDataException() {
        super("To be able to log in, you need to type your username.");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Caused by \n" + "The login field is empty.", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
