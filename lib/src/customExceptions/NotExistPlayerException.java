package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NotExistPlayerException extends Exception{

    public NotExistPlayerException(){
        super("Nombre de uusario incorrecto o jugador no registrado");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "El jugador buscado no existe", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
