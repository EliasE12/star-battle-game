package controllers;

import com.jfoenix.controls.JFXButton;
import customExceptions.EmptyDataException;
import customExceptions.NotShipsPositionedException;
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
import threads.UpdateThreadMatchTime;

import java.net.URL;
import java.util.ResourceBundle;

// Clase

/**
 * Entidad que representa el controlador de la ventana del tablero de juego.
 */
public class GameBoardController implements Initializable {

    // Atrubutos

    private Player player;
    private JFXButton[][] gameBoardP;
    private JFXButton[][] gameBoardM;

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

        gameBoardP = new JFXButton[Match.GAME_BOARD_SIZE][Match.GAME_BOARD_SIZE];
        gameBoardM = new JFXButton[Match.GAME_BOARD_SIZE][Match.GAME_BOARD_SIZE];

        gameBoardMachine.setDisable(true);
        fillGrid();
    }



    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }



    @FXML
    void playClicked(ActionEvent event) {
        if (!spaceShipsBox.getItems().isEmpty()){
            NotShipsPositionedException np = new NotShipsPositionedException();
            np.message();

        }else {
            UpdateThreadMatchTime umt = new UpdateThreadMatchTime(this);
            umt.setDaemon(true);
            umt.start();

            gameBoadPlayer.setDisable(true);
            gameBoardMachine.setDisable(false);
            fillGridMachine();
        }
    }


    public void updateMatchTime(){
        String time = player.getMatch().manageMatchTime();

        gameTime.setText(time);
    }


    private void fillGrid(){
        for (int i = 0; i < Match.GAME_BOARD_SIZE; i++) {
            for (int j = 0; j < Match.GAME_BOARD_SIZE; j++) {

                JFXButton b = new JFXButton("*");
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

            updateGameBoard(gameBoardP);
        } catch (EmptyDataException e) {
            e.message();
        }
    }

    private void updateGameBoard(Button[][] gameBoard){
        for (int i = 0; i < Match.GAME_BOARD_SIZE; i++) {
            for (int j = 0; j < Match.GAME_BOARD_SIZE; j++) {
                gameBoard[i][j].setText(player.getMatch().getGameBoardPlayer()[i][j]);
            }
        }
    }



    private void fillGridMachine(){
        for (int i = 0; i < Match.GAME_BOARD_SIZE; i++) {
            for (int j = 0; j < Match.GAME_BOARD_SIZE; j++) {

                JFXButton b = new JFXButton("*");
                b.setId(i + "," + j);
                b.setOnAction(event -> actionPlayer(b.getId()));
                b.setPrefHeight(50);
                b.setPrefWidth(50);

                gameBoardM[i][j] = b;
                gameBoardMachine.add(b, j, i);
            }
        }
    }

    private void actionPlayer(String position){
        boolean isShip = player.getMatch().uncoverMachineBox(position);

        if (isShip){
            discoverShip(position, gameBoardM);
        }
    }

    private void discoverShip(String position, Button[][] gameBoard){
        boolean founded = false;

        for (int i = 0; i < Match.GAME_BOARD_SIZE && !founded; i++) {
            for (int j = 0; j < Match.GAME_BOARD_SIZE && !founded; j++) {
                if (position.compareTo(gameBoard[i][j].getId()) == 0){
                    founded = true;

                    gameBoard[i][j].setText("X");

                }
            }
        }
    }
}
