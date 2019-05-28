package controllers;

import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import model.Player;
import model.Record;

// Clase

/**
 * Entidad que representa el controlador de la ventana del historial del jugador.
 */
public class PlayerHistoryController {

    // Atributos


    /**
     * Es la tabla en la que muestran los datos del historial.
     */
    @FXML private TableView<Record> tbPlayerHistory;

    /**
     * Es la columna en la que muestra el tiempo de duración de la partida.
     */
    @FXML private TableColumn<Record, String> time;

    /**
     * Es la columna en la que se muestra la fecha de la partida.
     */
    @FXML private TableColumn<Record, Date> date;

    /**
     * Es la columna en la que se muestra el puntaje obtenido en la partida.
     */
    @FXML private TableColumn<Record, Integer> score;

    /**
     * Es la columna en la que se muestra el resultado de la partida.
     */
    @FXML private TableColumn<Record, Record.Result> result;

    private Player player;

    // Métodos

    /**
     * Establece e inicializa el formato en que muestran los datos del historial del jugador
     */
    @FXML
    public void initialize() {

    	time.setCellValueFactory(new PropertyValueFactory<Record, String>("time"));
    	date.setCellValueFactory(new PropertyValueFactory<Record, Date>("date"));
    	score.setCellValueFactory(new PropertyValueFactory<Record, Integer>("score"));
        result.setCellValueFactory(new PropertyValueFactory<Record, Record.Result>("result"));


    }


    public void setPlayer(Player player){
        this.player = player;

        printHistorial();
    }

    private void printHistorial(){
        ObservableList<Record> records = FXCollections.observableArrayList();
        Record current = player.getFirst();
        while(current != null){
            records.add(current);
            current = current.getNext();
        }
        tbPlayerHistory.getItems().addAll(records);
    }




}



