package controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class FallOfFameController implements Initializable {

    @FXML private TableView<Player> tvHallOfFame;
    @FXML private TableColumn<Player, String> tcName;
    @FXML private TableColumn<Player, Integer> tcGlobalScore;
    @FXML private TableColumn<Player, Integer> tcWonMatch;
    @FXML private TableColumn<Player, Integer> tcLostMatch;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }






}
