/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.front_end;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * FXML Controller class
 *
 * @author Maher
 */
public class AccueilController implements Initializable {

    @FXML
    private AnchorPane affichage;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button party;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/app/gui/front_end/candidat/publication/Affichage.fxml"));
            // hethom ikabrou lpage 3la 9ad l'affichage ---
            AnchorPane.setTopAnchor(parent, 0.0);
            AnchorPane.setBottomAnchor(parent, 0.0);
            AnchorPane.setLeftAnchor(parent, 0.0);
            AnchorPane.setRightAnchor(parent, 0.0);
            // --------------------------------------------
            affichage.getChildren().clear();
            affichage.getChildren().add(parent);
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //final java.net.URL resource = getClass().getResource("app/utils/el-fichier-mte3ek.mp3");
        //MediaPlayer mediaPlayer = new MediaPlayer(new javafx.scene.media.Media(resource.toString()));
    }

    @FXML
    private void aff_btn(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/app/gui/front_end/candidat/publication/Affichage.fxml"));
            // hethom ikabrou lpage 3la 9ad l'affichage ---
            AnchorPane.setTopAnchor(parent, 0.0);
            AnchorPane.setBottomAnchor(parent, 0.0);
            AnchorPane.setLeftAnchor(parent, 0.0);
            AnchorPane.setRightAnchor(parent, 0.0);
            // --------------------------------------------
            affichage.getChildren().clear();
            affichage.getChildren().add(parent);
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void acc_btn(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/app/gui/front_end/candidat/publication/Ajout.fxml"));
            // hethom ikabrou lpage 3la 9ad l'affichage ---
            AnchorPane.setTopAnchor(parent, 0.0);
            AnchorPane.setBottomAnchor(parent, 0.0);
            AnchorPane.setLeftAnchor(parent, 0.0);
            AnchorPane.setRightAnchor(parent, 0.0);
            // --------------------------------------------
            affichage.getChildren().clear();
            affichage.getChildren().add(parent);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    DropShadow shadow = new DropShadow();

    @FXML
    private void hover_off(MouseEvent event) {
        btn1.setEffect(null);

    }

    @FXML
    private void hover_on(MouseEvent event) {
        btn1.setCursor(Cursor.HAND);
        shadow.setColor(Color.FUCHSIA);
        btn1.setEffect(shadow);
    }

    @FXML
    private void hover_off2(MouseEvent event) {
        btn2.setEffect(null);
    }

    @FXML
    private void hover_on2(MouseEvent event) {
        btn2.setCursor(Cursor.HAND);
        shadow.setColor(Color.FUCHSIA);
        btn2.setEffect(shadow);
    }

    @FXML
    private void music(ActionEvent event) throws IOException {
        InputStream music;
        try {
            music = new FileInputStream("party.wav");
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " n'existe pas");
        }
    }

}
