package controllers;

import com.jfoenix.controls.JFXTextField;
import customExceptions.EmptyDataException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import model.Game;
import model.Player;
import java.net.URL;
import java.util.ResourceBundle;

public class InicialWindowController implements Initializable {


    @FXML
    private JFXTextField tfEnter;

    private Game game;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
    }


    @FXML
    void enterClicked(ActionEvent event) {

        try {
            Player found = game.searchPlayer(tfEnter.getText());

            if (found != null) {
                //Mostrar la siguiente ventana
            }

        } catch (EmptyDataException e) {
            e.message();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Nombre de usuario incorrecto o usuario no registrado", ButtonType.CLOSE);
            alert.setHeaderText("Usuario no encontrado");
            alert.show();
        }

    }

    @FXML
    void toRegisterClicked(ActionEvent event) {

    }

    @FXML
    void hallFameClicked(ActionEvent event) {

    }


    @FXML
    void deletePlayerClicked(ActionEvent event) {

    }

}