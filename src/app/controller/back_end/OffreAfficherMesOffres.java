/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.back_end;

import app.entity.OffreDeTravail;
import app.service.CategorieCrud;
import app.service.OffreDeTravailCrud;
import app.service.SocieteCrud;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Anis
 */
public class OffreAfficherMesOffres implements Initializable {

    ObservableList<OffreDeTravail> listOffre = FXCollections.observableArrayList();
    public static OffreDeTravail offreActuelle = null;

    @FXML
    private Button btnAjout;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableColumn<OffreDeTravail, String> c3;
    @FXML
    private TableColumn<OffreDeTravail, String> c4;
    @FXML
    private TableColumn<OffreDeTravail, Integer> c5;
    @FXML
    private TableView<OffreDeTravail> T;
    @FXML
    private Button btns;
    @FXML
    private Button btnM;
    @FXML
    private TextField recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnM.setDisable(true);
        btns.setDisable(true);

        List<OffreDeTravail> liste = OffreDeTravailCrud.getInstance().getOffreDeTravailBySociete(app.MainApp.getSession().getSocieteId());

        liste.forEach((offreDeTravail) -> {
            try {
                offreDeTravail.setNomCategorie(CategorieCrud.getInstance().getCatById(offreDeTravail.getCategorieId()).getNom());
            } catch (Exception e) {
            }
            listOffre.add(offreDeTravail);
        });

        c3.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c4.setCellValueFactory(new PropertyValueFactory<>("description"));
        c5.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        T.setItems(listOffre);
    }

    @FXML
    private void ajouterOffre(ActionEvent event) {
        MainWindowController.chargerInterface(
                getClass().getResource("/app/gui/back_end/societe/offre_de_travail/Ajouter.fxml")
        );
    }

    @FXML
    private void select(MouseEvent event) {
        offreActuelle = T.getSelectionModel().getSelectedItem();
        btnM.setDisable(false);
        btns.setDisable(false);
    }

    @FXML
    private void supprimerOffre(ActionEvent event) {
        OffreDeTravailCrud.getInstance().SupprimerOffre(offreActuelle.getId());
        offreActuelle = null;
        btnM.setDisable(true);
        btns.setDisable(true);
        T.refresh();
        MainWindowController.chargerInterface(
                getClass().getResource("/app/gui/back_end/societe/offre_de_travail/AfficherMesOffres.fxml")
        );
    }

    @FXML
    private void modifierOffre(ActionEvent event) {
        if (offreActuelle != null) {
            MainWindowController.chargerInterface(
                    getClass().getResource("/app/gui/back_end/societe/offre_de_travail/Modifier.fxml")
            );
        }
    }

    @FXML
    private void rechercheOffre(KeyEvent event) {

        List<OffreDeTravail> offres = OffreDeTravailCrud.getInstance().rechercheOffre(recherche.getText());

        offres.forEach(offreDeTravail -> {
            listOffre.add(offreDeTravail);
        });

        T.setItems(listOffre);
    }

    private void afficherparsociete(ActionEvent event) {
        List<OffreDeTravail> offre = OffreDeTravailCrud.getInstance().getOffreDeTravailBySociete(app.MainApp.getSession().getSocieteId());

        offre.forEach(offreDeTravail -> {
            listOffre.add(offreDeTravail);
        });

        T.setItems(listOffre);
    }

}
