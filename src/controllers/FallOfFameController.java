package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;
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

    @FXML
    void returnClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/LoginWindowGUI.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Iniciar Sesión");
        stage.show();
    }






}
