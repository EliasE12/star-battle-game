package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Clase

/**
 * Entidad que representa el ejecutor del juego.
 */
public class Main extends Application {

    // Métodos

    /**
     * Carga e inicializa en juego.
     * @param primaryStage - Es el scenario principal.
     * @throws Exception - Es el error que se produce cuando no se puede cargar la ventana principal.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindowGUI.fxml"));
        primaryStage.setTitle("Iniciar Sesión");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Main

    /**
     * Es el método principal del juego.
     * Inicializa el juego.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
