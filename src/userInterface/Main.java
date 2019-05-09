package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("InicialWindowGUI.fxml"));
        primaryStage.setTitle("Iniciar Sesión");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

/*    public void sumarTotales(){
        int suma = 0;

        for (int i = 0; i < array.size(); i++) {

            if (array.get(i) instanceof LineaTelefonica){

                suma += array.get(i).calcularCosto();

            }else {
                suma += array.get(i).calcularCosto();
            }

        }

    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
