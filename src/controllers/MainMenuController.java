package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
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



    @FXML
    private ImageView ivMainImage;


    // Relación

    /**
     * Es la relación con la clase Jugador.
     */
    private Player player;



    private Game game;


    // Métodos

    /**
     * Inicializa los atributos que se manejan en la ventana.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivMainImage.setImage(new Image("ImagenCentral.jpg"));
    }

    /**
     * Cambia el jugador.
     * @param player - El nuevo jugador.
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * Devuelve la relacion con la clase Game
     * @return la relacion con Game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Cambia el vaor de la relacion con la clase Game
     * @param game el nuevo valor de la relacion con Game
     */
    public void setGame(Game game) {
        this.game = game;
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

        Match match = new Match(0, 0, false);
        player.setMatch(match);

        SelectionWindowController ven = loader.getController();
        ven.setGame(this.game);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/PlayerHistory.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PlayerHistoryController ven = loader.getController();
        ven.setPlayer(player);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Historial de partidas");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

}
