package controllers;

import customExceptions.EmptyDataException;
import customExceptions.EqualUserException;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import model.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationWindowController implements Initializable {

    private Stage stage;

    private Game game;

    @FXML private JFXTextField tfName;

    @FXML private JFXTextField tfLasName;

    @FXML private JFXTextField tfUserName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setGame(Game game){
        this.game = game;
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        stage.close();
    }

    @FXML
    void toRegisterClicked(ActionEvent event) {
        try {
            game.addPlayer(tfUserName.getText(), tfName.getText(), tfLasName.getText());
            stage.close();

        }catch (EmptyDataException e){
            e.message();
        }catch (EqualUserException e){
            e.message();
        }
    }
}
