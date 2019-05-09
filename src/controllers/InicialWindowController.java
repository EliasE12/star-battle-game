package controllers;

import com.jfoenix.controls.JFXTextField;
import customExceptions.EmptyDataException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import model.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class InicialWindowController implements Initializable {

    private Game game;

    @FXML
    private JFXTextField tfEnter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
    }

    @FXML
    void enterClicked(ActionEvent event) {
        try {
            game.searchPlayer(tfEnter.getText());
        } catch (EmptyDataException e) {
            e.message();
        }
    }

    @FXML
    void hallFameClicked(ActionEvent event) {

    }
}
