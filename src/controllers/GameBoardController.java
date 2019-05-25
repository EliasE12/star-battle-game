package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {

    private Player player;

    @FXML private Label gameTimeMachine;
    @FXML private Label gameTimePlayer;
    @FXML private Label lbTimeGlobal;
    @FXML private JFXButton btDreadNought;
    @FXML private JFXButton btBattleCruiser;
    @FXML private VBox destroyerClicked;
    @FXML private JFXButton btDestroyer;
    @FXML private JFXButton btStarFighter;
    @FXML private JFXButton btBomber;
    @FXML private JFXButton btInterceptor;
    @FXML private JFXButton btGunShip;
    @FXML private JFXButton btShuttle;
    @FXML private JFXComboBox<?> cbDirection;
    @FXML private JFXButton playClicked;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void setPlayer(Player player){
        this.player = player;
    }

    @FXML public void battleCruiserClicked(ActionEvent event) {



    }

    @FXML
    public void bomberClicked(ActionEvent event) {

    }

    @FXML
    public void destroyerClicked(ActionEvent event) {

    }

    @FXML
    public void dreadNoughtClicked(ActionEvent event) {

    }

    @FXML
    public void gunShipClicked(ActionEvent event) {

    }

    @FXML
    public void interceptorClicked(ActionEvent event) {

    }

    @FXML
    public void shuttleClicked(ActionEvent event) {

    }

    @FXML
    public void starFighterClicked(ActionEvent event) {

    }


}
