package controllers;

import customExceptions.EmptyDataException;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Match;
import model.Player;
import model.Faction.SpaceShipType;
import  model.Match.Direction;

import java.net.URL;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {

    private Player player;
    private Button[][] gameBoardP;
    private Button[][] gameBoardM;

    @FXML
    private JFXComboBox<SpaceShipType> spaceShipsBox;

    @FXML
    private JFXComboBox<Direction> horientationBox;

    @FXML
    private GridPane gameBoadPlayer;

    @FXML
    private GridPane gameBoardMachine;

    @FXML
    private Label turnTimePlayer;

    @FXML
    private Label turnTimeMachine;

    @FXML
    private Label gameTime;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spaceShipsBox.getItems().addAll(SpaceShipType.SHUTTLE, SpaceShipType.BOMBER, SpaceShipType.INTERCEPTOR, SpaceShipType.GUNSHIP, SpaceShipType.STARFIGHTER, SpaceShipType.DESTROYER, SpaceShipType.BATTLECRUISER, SpaceShipType.DREADNOUGHT);
        horientationBox.getItems().addAll(Direction.HORIZONTAL, Direction.VERTICAL);

        gameBoardP = new Button[Match.GAME_BOARD_SIZE][Match.GAME_BOARD_SIZE];
        gameBoardM = new Button[Match.GAME_BOARD_SIZE][Match.GAME_BOARD_SIZE];

        gameBoardMachine.setDisable(true);
        fillGrid();
    }



    public void setPlayer(Player player){
        this.player = player;
    }



    @FXML
    void playClicked(ActionEvent event) {

    }



    private void fillGrid(){
        for (int i = 0; i < Match.GAME_BOARD_SIZE; i++) {
            for (int j = 0; j < Match.GAME_BOARD_SIZE; j++) {

                Button b = new Button("*");
                b.setId(i + "," + j);
                b.setOnAction(event -> action(b));
                b.setPrefHeight(50);
                b.setPrefWidth(50);

                gameBoardP[i][j] = b;
                gameBoadPlayer.add(b, j, i);
            }
        }
    }


    private void action(Button b){
        SpaceShipType s = spaceShipsBox.getValue();

        try {
            player.getMatch().createSpaceShips(s, horientationBox.getValue(), b.getId());

            spaceShipsBox.getItems().remove(s);

            for (int i = 0; i < Match.GAME_BOARD_SIZE; i++) {
                for (int j = 0; j < Match.GAME_BOARD_SIZE; j++) {
                    gameBoardP[i][j].setText(player.getMatch().getGameBoardPlayer()[i][j]);
                }
            }
        } catch (EmptyDataException e) {
            e.message();
        }
    }
}
