package controllers;

import com.jfoenix.controls.JFXTextField;
import customExceptions.EmptyDataException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Game;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicialWindowController implements Initializable {

    private Game game;

    @FXML private JFXTextField tfEnter;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
    }


    @FXML
    void enterClicked(ActionEvent event) {

        try {
            Player found = game.searchPlayer(tfEnter.getText());

            if (found != null) {

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
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/RegistrationWindowGUI.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegistrationWindowController ven = loader.getController();
        ven.setStage(stage);
        ven.setGame(game);

        stage.setTitle("Ventana de Registro");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void hallFameClicked(ActionEvent event) {
        Stage stage = new Stage();

        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/userInterface/HallOfFameGUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Salon de la Fama");
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    void deletePlayerClicked(ActionEvent event) {

    }

}