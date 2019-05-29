package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import model.Player;
import model.Record;

import java.util.List;

// Clase

/**
 * Entidad que representa el controlador de la ventana del historial del jugador.
 */
public class PlayerHistoryController {

    // Atributos

    /**
     * Es contener donde se muestran el historial del jugador.
     */
    @FXML
    private ScrollPane spPrintHistorialPlayer;

    /**
     * Es el contenedor auxiliar para mostrar el hostorial dej jugador.
     */
    private Pane pPrintHistorialPlayer;

    /**
     * Es el jugador.
     */
    private Player player;

    // Métodos

    /**
     * Establece e inicializa el formato en que muestran los datos del historial del jugador
     */
    @FXML
    public void initialize() {
        pPrintHistorialPlayer = new Pane();
    }

    /**
     * Cambia el vaor de la relacion con la clase Player para posteriormente inicializar el proceso de pintar el historial del jugador, si lo posee.
     * @param player el nuevo valor de la relacion con Player
     */
    public void setPlayer(Player player){
        this.player = player;
        printHistorial();
    }

    /**
     * Pinta la lista enlazada en pantalla, con todos los datos del historial del jugador.
     */
    private void printHistorial(){

        List<Record> recordList = player.recordsToPrint();

        int desplace = 0;
        int counter = 0;
        for (Record record: recordList) {

            BorderPane borderPane = new BorderPane();
            borderPane.setPrefSize(200.0, 155.0);
            borderPane.setLayoutX(desplace);
            borderPane.setLayoutY(20.0);


            TextArea textArea = new TextArea();
            textArea.setStyle("-fx-background-color: #4b899a");
            textArea.setText(record.toString());
            textArea.setPrefSize(200.0, 155.0);

            borderPane.setBottom(textArea);
            borderPane.setStyle("-fx-background-color:  #1e90ff");

            pPrintHistorialPlayer.getChildren().addAll(borderPane);

            if (counter != recordList.size() - 1) {

                Line line1 = new Line(borderPane.getLayoutX() + 200, borderPane.getLayoutY() + 100, borderPane.getLayoutX() + 200 + 190, borderPane.getLayoutY() + 100);
                Line line2 = new Line(borderPane.getLayoutX() + 200, borderPane.getLayoutY() + 150, borderPane.getLayoutX() + 200 + 190, borderPane.getLayoutY() + 150);

                Line f1 = new Line(line1.getStartX() + 100, line1.getStartY(), line1.getStartX() + 90, line1.getStartY() - 10);
                Line f2 = new Line(line1.getStartX() + 100, line1.getStartY(), line1.getStartX() + 90, line1.getStartY() + 10);

                Line f3 = new Line(line2.getStartX(), line2.getStartY(), line2.getStartX() + 10, line2.getStartY() - 10);
                Line f4 = new Line(line2.getStartX(), line2.getStartY(), line2.getStartX() + 10, line2.getStartY() + 10);

                pPrintHistorialPlayer.getChildren().addAll(line1, line2, f1, f2, f3, f4);
                spPrintHistorialPlayer.setContent(pPrintHistorialPlayer);
            }
            counter++;
            desplace += 300;
        }
    }

    /**
     * Controla la accion de ordenar el historial del jugador utilizando como criterio la fecha.
     * @param event Es el evento que se produce al presionar el boton.
     */
    @FXML
    void sortByDateClicked(ActionEvent event) {
        player.recordsSortByDate();
        printHistorial();
        System.out.println("Ordenado");
    }

    /**
     * Controla la accion de ordenar el historial del jugador utilizando como criterio el puntaje obtenido en dicha partida.
     * @param event Es el evento que se produce al presionar el boton.
     */
    @FXML
    void sortByScoreClicked(ActionEvent event) {
        player.recordsSortByScore();
        printHistorial();
    }

    /**
     * Controla la accion de ordenar el historial del jugador utilizando como criterio el tiempo demorado en dicha partida.
     * @param event Es el evento que se produce al presionar el boton.
     */
    @FXML
    void sortByTimeClicked(ActionEvent event) {
        player.recordsSortByTime();
        printHistorial();
    }



}



