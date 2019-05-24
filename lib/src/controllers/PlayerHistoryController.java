package controllers;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import model.Record;

public class PlayerHistoryController {

    @FXML
    private TableView<Record> tbPlayerHistory;

    @FXML
    private TableColumn<Record, String> time;

    @FXML
    private TableColumn<Record, Date> date;

    @FXML
    private TableColumn<Record, Integer> score;

    @FXML
    private TableColumn<Record, Record.Result> result;

    
    @FXML
    public void initialize() {
    	time.setCellValueFactory(new PropertyValueFactory<Record, String>("time"));
    	date.setCellValueFactory(new PropertyValueFactory<Record, Date>("date"));
    	score.setCellValueFactory(new PropertyValueFactory<Record, Integer>("score"));
        result.setCellValueFactory(new PropertyValueFactory<Record, Record.Result>("result"));
    }


}



