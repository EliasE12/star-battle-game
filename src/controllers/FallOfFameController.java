package controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

        tcName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
        tcGlobalScore.setCellValueFactory(new PropertyValueFactory<Player,Integer>("globalScore"));
        tcWonMatch.setCellValueFactory(new PropertyValueFactory<Player,Integer>("wonMatch"));
        tcLostMatch.setCellValueFactory(new PropertyValueFactory<Player,Integer>("lostMatch"));

    }






}
