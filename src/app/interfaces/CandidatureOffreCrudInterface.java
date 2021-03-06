/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.interfaces;

import app.entity.CandidatureOffre;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public interface CandidatureOffreCrudInterface {

    public ObservableList<CandidatureOffre> getCandidaturesOffre();

    public ObservableList<CandidatureOffre> getCandidaturesOffresBySociete(int idSociete);

    public CandidatureOffre getCandidatureOffreByCandidatOffre(int idCandidat, int idOffre);

    public void ajouterCandidature(CandidatureOffre candidatureOffre);

    public void modifierEtat(CandidatureOffre candidatureOffre);

    public CandidatureOffre getCandidaturesOffreById(int idCandidature);

}
