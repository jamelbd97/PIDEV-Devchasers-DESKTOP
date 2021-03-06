/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.interfaces;

import app.entity.Revue;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public interface RevueCrudInterface {

    public boolean controleEtoiles(int nbEtoiles);

    public boolean controleObjet(String objet);

    public boolean controleDescription(String description);

    public boolean controleBadWords(String texte);

    public void ajouterRevue(Revue r);

    public void modifierRevue(Revue r);

    public void supprimerRevue(Revue r);

    public ObservableList<Revue> getRevuesParOffre(int idOffreDeTravail);

    public ObservableList<Revue> getRevuesParOffreParObjet(int idOffreDeTravail, String objet);

    public ObservableList<Revue> getAllRevues();

}
