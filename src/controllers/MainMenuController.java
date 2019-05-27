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

// Clase

/**
 * Entidad que representa el controlador de la ventana del menú principal.
 */
public class MainMenuController implements Initializable {

    // Relación

    /**
     * Es la relación con la clase Jugador.
     */
    private Player player;

    // Métodos

    /**
     * Inicializa los atributos que se manejan en la ventana.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Cambia el jugador.
     * @param player - El nuevo jugador.
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * Controla la acción de presionar el botón de crear una partida.
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void newMatchClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/SelectionWindowGUI.fxml"));
        Parent root = null;

        try{
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Match match = new Match(Match.DURATION_MATCH, 0, false);
        player.setMatch(match);

        SelectionWindowController ven = loader.getController();
        ven.setPlayer(player);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Selección de Capitanes");
        stage.show();
    }

    /**
     * Controla la acción de presionar el botón ver el historial del jugador.
     * @param event - Es el evento producido al presionar el botón.
     */
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
