package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Match;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private Player player;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void setPlayer(Player player){
        this.player = player;
    }

    @FXML
    void newMatchClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/SelectionWindowGUI.fxml"));
        Parent root = null;

        try{
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Match match = new Match(0, 0, false);
        player.setMatch(match);

        SelectionWindowController ven = loader.getController();
        ven.setPlayer(player);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Selección de Capitanes");
        stage.show();
    }

    @FXML
    void recordClicked(ActionEvent event)  {
        Stage stage = new Stage();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/userInterface/PlayerHistory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root));
        stage.setTitle("Historial de partidas");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

}
