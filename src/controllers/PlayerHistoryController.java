package controllers;

import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import model.Player;
import model.Record;

// Clase

/**
 * Entidad que representa el controlador de la ventana del historial del jugador.
 */
public class PlayerHistoryController {

    // Atributos


    @FXML
    private Pane pPrintHistorialPlayer;

    private Player player;

    // Métodos

    /**
     * Establece e inicializa el formato en que muestran los datos del historial del jugador
     */
    @FXML
    public void initialize() {

    }


    public void setPlayer(Player player){
        this.player = player;
        printHistorial();
    }

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
            }
            counter++;
            desplace += 300;
        }
    }


}



