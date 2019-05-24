package controllers;

import customExceptions.EmptyDataException;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXComboBox;
import model.Leader;
import model.Match;
import model.Player;
import com.jfoenix.controls.JFXTextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectionWindowController implements Initializable {

    private Player player;

    @FXML
    private ImageView dominatorImage;

    @FXML
    private ImageView protectorImage;

    @FXML
    private ImageView strategistImage;

    @FXML
    private JFXTextField tfFactionName;

    @FXML
    private JFXTextField tfMembers;

    @FXML
    private JFXTextField tfCaptainName;

    @FXML
    private JFXComboBox<Leader.LevelExperience> cbExperienceLevel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbExperienceLevel.getItems().addAll(Leader.LevelExperience.LOW, Leader.LevelExperience.MEDIUM, Leader.LevelExperience.HIGHT);
    }


    public void setPlayer(Player player){
        this.player = player;
    }

    @FXML
    void dominatorClicked(MouseEvent event) {

        try {
            int members = Integer.parseInt(tfMembers.getText());
            player.getMatch().createUserFaction(tfFactionName.getText(), members, Match.LeaderType.DOMINATOR, tfCaptainName.getText(), cbExperienceLevel.getValue());

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Espacio en banco o caracter invalido digitado", ButtonType.CLOSE);
            alert.setHeaderText("La cantidad de miembros de la nueva faccion debe ser un numero");
            alert.show();

        }catch (EmptyDataException e){
            e.message();
        }
    }

    @FXML
    void estrategistClicked(MouseEvent event) {
        try {
            int members = Integer.parseInt(tfMembers.getText());
            player.getMatch().createUserFaction(tfFactionName.getText(), members, Match.LeaderType.STRATEGIST, tfCaptainName.getText(), cbExperienceLevel.getValue());

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Espacio en banco o caracter invalido digitado", ButtonType.CLOSE);
            alert.setHeaderText("La cantidad de miembros de la nueva faccion debe ser un numero");
            alert.show();

        }catch (EmptyDataException e){
            e.message();
        }
    }

    @FXML
    void protectorClicked(MouseEvent event) {
        try {
            int members = Integer.parseInt(tfMembers.getText());
            player.getMatch().createUserFaction(tfFactionName.getText(), members, Match.LeaderType.PROTECTOR, tfCaptainName.getText(), cbExperienceLevel.getValue());

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Causado por:\n" + "Espacio en banco o caracter invalido digitado", ButtonType.CLOSE);
            alert.setHeaderText("La cantidad de miembros de la nueva faccion debe ser un numero");
            alert.show();

        }catch (EmptyDataException e){
            e.message();
        }

    }
}
