package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NotShipsPositionedException extends Exception {

    public NotShipsPositionedException() {
        super("Para poder comenzar a jugar, todas las naves tienen que estar posicionadas");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Aun hay naves que no se han posicionado en el tablero de juego", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
