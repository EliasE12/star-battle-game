package controllers;

import com.jfoenix.controls.JFXTextField;
import customExceptions.EmptyDataException;
import customExceptions.EmptyPlayerStructureException;
import customExceptions.NotExistPlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Clase

/**
 * Entdad que representa el controlador de la ventana de iniciar a jugar.
 */
public class LoginWindowController implements Initializable {

    // Atributos

    /**
     * Es el campo de texto para ingresar el nombre de usuario del jugador.
     */
    @FXML private JFXTextField tfEnter;

    /**
     *
     */
    private String borrar;

    // Relación

    /**
     * Es la relación con Juego, la clase principal del modelo.
     */
    private Game game;

    // Métodos

    /**
     * Inicializa los atributos y relaciones de la clase, necesarios manejar la ventana.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();

    }

    /**
     * Controla la acción de presionar el botón para entrar a jugador
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void enterClicked(ActionEvent event) {
        try {
            Player found = game.searchPlayer(tfEnter.getText());
            System.out.println(found.getUserName());

            if (found != null) {
                startMainMenu(found, event);
            }

        } catch (EmptyDataException e) {
            e.message();
        }catch (NotExistPlayerException e) {
            e.message();
        } catch (EmptyPlayerStructureException e) {
            e.message();
        }
    }

    /**
     * Controla la acción de presionar el botón de registrar un jugador.
     * @param event - Es el evento producido al presionar el botón.
     */
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
        ven.setGame(game);

        stage.setTitle("Ventana de Registro");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    /**
     * Controla la acción de presionar el botón para ver el salón de la fama.
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void hallFameClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/HallOfFameGUI.fxml"));

        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Salon de la Fama");
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Controla la acción de presionar el botón para eliminar un jugador.
     * @param event - Es el evento producido al presionar el botón.
     */
    @FXML
    void deletePlayerClicked(ActionEvent event) {
        try {
            game.deletePlayer(tfEnter.getText());
        } catch (EmptyDataException e) {
            e.message();
        } catch (EmptyPlayerStructureException e) {
            e.message();
        }
    }

    /**
     * Vuelve a la ventana de inicio, con la información del jugador indicado.
     * @param found - Es el jugador indicado.
     * @param event - Es el evento producido al presionar el botón..
     */
    private void startMainMenu(Player found, ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/MainMenuGUI.fxml"));
        Parent root = null;

        try{
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        MainMenuController ven = loader.getController();
        ven.setPlayer(found);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu principal");
        stage.show();
    }

}