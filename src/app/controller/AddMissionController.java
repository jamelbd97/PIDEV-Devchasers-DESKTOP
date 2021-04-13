/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.entity.Mission;
import app.service.MissionCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Types;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Akram
 */
public class AddMissionController implements Initializable {

    @FXML
    private Text topText;
    @FXML
    private Button btnRetour;
    @FXML
    private TextField inputId;
    @FXML
    private TextField inputDescription;
    @FXML
    private Button btnAjout;
    @FXML
    private DatePicker Dateid;
    @FXML
    private TextField inputnbheure;
    @FXML
    private TextField inputprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mission(ActionEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("/app/gui/societe/mission/afficherMission.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
//    private void loadDate(){
//    ObservableList<Mission> abList = FXCollections.observableArrayList();
//        colnumsalle.setCellValueFactory(new PropertyValueFactory<>("num_salle"));
//        colnomoffre.setCellValueFactory(new PropertyValueFactory<>("nom_offre"));
//        coldatedebut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
//        coldatefin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
//        colspecialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
//        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//
//        Service_Evenement rt = new Service_Evenement();
//        List old = rt.listeventid();
//        abList.addAll(old);
//        tab.setItems(abList);
//        tab.refresh();
//    }

    @FXML
    private void ajout(ActionEvent event) {
         MissionCrud missionCrud = new MissionCrud();

        String nom = inputId.getText();
        String nbheure = inputnbheure.getText();
        String prix = inputprix.getText();
        String description = inputDescription.getText();
        Date d = null;
        try {
            d = java.sql.Date.valueOf(Dateid.getValue());
        } catch (Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
        }
        Mission mission = new Mission(nom,description,d,Integer.parseInt(nbheure), Integer.parseInt(prix));
        missionCrud.ajouterMission(mission);
        
        mission(event);

//MissionCrud rt = new MissionCrud();
//        rt.(new mission(inputId.getText(),inputDescription.getText(), Date.valueOf(Dateid.getValue()), inputnbheure.getText(), inputprix.getText()));
//        JOptionPane.showMessageDialog(null, "evenement ajouté");
        

    }
   
    
}