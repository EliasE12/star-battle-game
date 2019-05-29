package controllers;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import model.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Clase

/**
 * Entidad que representa el controlador de la ventana de registro del jugador.
 */
public class RegistrationWindowController implements Initializable {

    // Atributos

    /**
     * Es el campo de texto para el nombre del jugador.
     */
    @FXML private JFXTextField tfName;

    /**
     * Es el campo de texto para el apellido del jugador.
     */
    @FXML private JFXTextField tfLasName;

    /**
     * Es el campo de texto para el nombre de usuario del jugador.
     */
    @FXML private JFXTextField tfUserName;

    // Relación

    /**
     * Es la relación con Game, la clase principal del modelo;
     */
    private Game game;

    // Métodos

    /**
     * Inicializa los atributos que se requieren al iniciarse la ventana.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Cambia el juego.
     * @param game - El nuevo juego.
     */
    public void setGame(Game game){
        this.game = game;
    }

    /**
     * Controla la acción de presionar el botón de cancelar el registro del jugador.
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void cancelClicked(ActionEvent event) {

        try {
            game.saveStateGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Controla la acción de presionar el botón de registrar el jugador.
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void toRegisterClicked(ActionEvent event) {
        try {
            game.addPlayer(tfUserName.getText(), tfName.getText(), tfLasName.getText());
            game.saveStateGame();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        }catch (EmptyDataException e){
            e.message();
        }catch (EqualUserException e){
            e.message();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
